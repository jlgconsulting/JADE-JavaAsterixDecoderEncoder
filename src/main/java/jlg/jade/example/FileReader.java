/* 
* Created by dan-geabunea on 5/24/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.example;

import jlg.finalframe.FinalFrameReader;

import java.io.*;
import java.util.concurrent.BlockingQueue;

class FileReader implements Runnable {
    private final BlockingQueue<byte[]> rawQueue;
    private final String filePath;

    FileReader(BlockingQueue<byte[]> rawQueue, String[] args){
        this.rawQueue = rawQueue;
        this.filePath = args[2];
    }

    @Override
    public void run() {
        int nbFinalFramePackets = 0;
        int nbBytesReceived = 0;
        long startTime = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(new File(filePath))) {
            FinalFrameReader ffReader = new FinalFrameReader();
            AsterixDecoder asterixDecoder = new AsterixDecoder(62);
            while (is.available() > 0) {
                byte[] ffPayload = ffReader.read(is);
                if (ffPayload != null) {
                    this.rawQueue.put(ffPayload);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("FINISHED in " + ((endTime - startTime) / 1000) + " seconds");
    }
}
