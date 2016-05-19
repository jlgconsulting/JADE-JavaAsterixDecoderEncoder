/* 
* Created by dan-geabunea on 5/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade;

import jlg.jade.asterix.AsterixDataBlock;

import java.net.DatagramPacket;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class DatagramConvertor implements Runnable {

    private BlockingQueue<DatagramPacket> rawQueue;
    private int numberOfQueueItems;
    private int numberOfReceivedBytes;

    public DatagramConvertor(BlockingQueue<DatagramPacket> rawQueue) {
        this.rawQueue = rawQueue;
    }

    @Override
    public void run() {
        System.out.println("Start Convertor");
        AsterixDecoder asterixDecoder = new AsterixDecoder(62);
        while (true) {
            try {
                DatagramPacket datagramPacket = rawQueue.take();
                try {
                    List<AsterixDataBlock> dataBlocks = asterixDecoder.decode(
                            datagramPacket.getData(),
                            0,
                            datagramPacket.getLength()
                    );
                    numberOfQueueItems++;
                    numberOfReceivedBytes += datagramPacket.getLength();
                    System.out.println("Processed " + numberOfQueueItems + " datagrams (" + numberOfReceivedBytes +
                            ") bytes");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Processed " + numberOfQueueItems + " from raw queue");
            }
        }
    }
}
