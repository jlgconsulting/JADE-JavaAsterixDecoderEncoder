/* 
* Created by dan-geabunea on 5/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.BlockingQueue;

public class UdpReader implements Runnable {
    private int port = 3001;
    private final int MAX_PACKET_SIZE = 65507;
    private final int TIMEOUT = 5000;
    private BlockingQueue<byte[]> rawQueue;

    public UdpReader() {
    }

    public UdpReader(BlockingQueue<byte[]> rawQueue, String[] args) {
        if(args[2] != null){
            this.port = Integer.parseInt(args[2]);
        }
        this.rawQueue = rawQueue;
    }

    public void run() {
        ParseUdpData();
    }

    private void ParseUdpData() {
        System.out.println("Starting UdpReader on port " + port);

        int receivedDatagrams = 0;
        int receivedBytes = 0;
        try (DatagramSocket client = new DatagramSocket(port)) {
            client.setSoTimeout(TIMEOUT);
            byte[] buffer = new byte[MAX_PACKET_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, MAX_PACKET_SIZE);
            while (true) {
                client.receive(packet);
                receivedDatagrams++;
                receivedBytes += packet.getLength();

                //copy raw array
                byte[] rawBytes = new byte[packet.getLength()];
                System.arraycopy(buffer,0,rawBytes,0,packet.getLength());

                rawQueue.put(rawBytes);
            }
        } catch (Exception e) {
            System.out.println("Stop UdpReader");
            System.out.println("Processed " + receivedDatagrams + " datagrams (" + receivedBytes + ") bytes.");
        }
    }
}
