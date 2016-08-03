/* 
* Created by dan-geabunea on 5/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class JadeApplication {

    public static void main(String[] args) {
        System.out.println("Java Asterix Decoder Encoder");
        BlockingQueue<byte[]> rawQueue = new ArrayBlockingQueue<>(4000);
        String mode = args[0];
        if(!mode.equals("udp") && !mode.equals("file")){
            throw new RuntimeException("Invalid mode. First parameter must be udp or file.");
        }
        switch (mode){
            case "udp":{
                ParseUdpUnicastData(rawQueue,args);
                break;
            }
            case "file":{
                ParseFileData(rawQueue,args);
                break;
            }
            default:{
                throw new RuntimeException("Invalid mode. First parameter must be udp or file.");
            }
        }
    }

    private static void ParseUdpUnicastData(BlockingQueue<byte[]> rawQueue, String[] args) {
        UdpReader reader = new UdpReader(rawQueue, args);
        DatagramConvertor convertor = new DatagramConvertor(rawQueue,args);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(reader);
        executorService.submit(convertor);
    }

    private static void ParseFileData(BlockingQueue<byte[]> rawQueue, String[] args) {
        FileReader reader = new FileReader(rawQueue, args);
        DatagramConvertor convertor = new DatagramConvertor(rawQueue,args);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(reader);
        executorService.submit(convertor);
    }
}
