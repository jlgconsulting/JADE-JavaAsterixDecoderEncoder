/* 
* Created by dan-geabunea on 5/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.example;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.counters.Cat062ItemCounter;
import jlg.jade.asterix.counters.Cat065ItemCounter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;

class DatagramConvertor implements Runnable {
    private final BlockingQueue<byte[]> rawQueue;
    private boolean isLogEnabled = false;
    private final Log logger;
    private int numberOfQueueItems;
    private int numberOfReceivedBytes;
    private int numberOfReceivedBytesFinalFrame;

    DatagramConvertor(BlockingQueue<byte[]> rawQueue, String[] args) {
        this.rawQueue = rawQueue;
        this.logger = LogFactory.getLog("jlg.jade");
        this.isLogEnabled = Boolean.parseBoolean(args[1]);
    }

    @Override
    public void run() {
        Cat062ItemCounter cat062ItemCounter = new Cat062ItemCounter();
        Cat065ItemCounter cat065ItemCounter = new Cat065ItemCounter();

        System.out.println("Start Convertor");
        AsterixDecoder asterixDecoder = new AsterixDecoder(62, 65);
        long startTime = System.currentTimeMillis();
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
                            String s = adb.getDebugString();
                            logger.debug(adb.getDebugString());
                        }
                    }
                    System.out.println("Processed " +
                            numberOfQueueItems + " datagrams/packets (" +
                            numberOfReceivedBytes +
                            ") bytes (" + numberOfReceivedBytesFinalFrame + ") received bytes in FF. Elapsed time " +
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
