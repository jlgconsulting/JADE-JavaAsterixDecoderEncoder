/* 
* Created by dan-geabunea on 5/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade;

import java.net.DatagramPacket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JadeApplication {


    public static void main(String[] args) {
        BlockingQueue<DatagramPacket> rawQueue = new ArrayBlockingQueue<>(2000);
        UdpReader reader = new UdpReader(rawQueue);
        DatagramConvertor convertor = new DatagramConvertor(rawQueue);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(reader);
        executorService.submit(convertor);
    }
}
