/* 
* Created by dan-geabunea on 5/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.example;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixDecoder;
import jlg.jade.asterix.counters.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

class DatagramConvertor implements Runnable {
    private final BlockingQueue<byte[]> rawQueue;
    private boolean isLogEnabled = false;
    private final Log logger;
    private int numberOfQueueItems;
    private int numberOfReceivedBytes;
    private int numberOfReceivedBytesFinalFrame;
    private final String allowedCategories;

    DatagramConvertor(BlockingQueue<byte[]> rawQueue, String[] args) {
        this.rawQueue = rawQueue;
        this.logger = LogFactory.getLog("jlg.jade");
        this.isLogEnabled = Boolean.parseBoolean(args[1]);
        this.allowedCategories = args[3];
    }

    @Override
    public void run() {
        //initialise item counters
        DefaultDecodingReport asterixDecodingReport = new DefaultDecodingReport();


        System.out.println("Start Datagram Convertor");
        logger.debug("Start Datagram Convertor");

        //init asterix decoder
        List<Integer> categoriesToDecode = new ArrayList<>();
        if (allowedCategories.contains("62")) {
            categoriesToDecode.add(62);
        }
        if (allowedCategories.contains("65")) {
            categoriesToDecode.add(65);
        }
        if (allowedCategories.contains("4")) {
            categoriesToDecode.add(4);
        }
        if(allowedCategories.contains("150")){
            categoriesToDecode.add(150);
        }
        if(allowedCategories.contains("48")){
            categoriesToDecode.add(48);
        }
        if(allowedCategories.contains("34")){
            categoriesToDecode.add(34);
        }

        AsterixDecoder asterixDecoder = new AsterixDecoder(categoriesToDecode);

        long startTime = System.currentTimeMillis();
        int index = 0;
        while (true) {
            try {
                byte[] rawData = rawQueue.take();

                try {
                    List<AsterixDataBlock> dataBlocks = asterixDecoder.decode(
                            rawData,
                            0,
                            rawData.length
                    );
                    numberOfQueueItems++;
                    numberOfReceivedBytes += rawData.length;
                    numberOfReceivedBytesFinalFrame += rawData.length + 12;
                    if (isLogEnabled) {
                        for (AsterixDataBlock adb : dataBlocks) {
                            logger.debug(adb.getDebugString());
                            asterixDecodingReport.update(adb);

                            //item counters are printed every 100 data blocks
                            if(index % 100 == 0) {
                                logger.debug(asterixDecodingReport.toDebugString());
                            }
                        }
                        index++;
                    }
                    System.out.println("Processed " +
                            numberOfQueueItems + " datagrams/packets (" +
                            numberOfReceivedBytes +
                            ") bytes (" + numberOfReceivedBytesFinalFrame + ") received bytes in " +
                            "FF. Elapsed time " +
                            (System.currentTimeMillis() - startTime) / 1000 + " sec");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
