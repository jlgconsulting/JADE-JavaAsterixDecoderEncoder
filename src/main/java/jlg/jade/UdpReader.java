/* 
* Created by dan-geabunea on 5/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.BlockingQueue;

public class UdpReader implements Runnable {
    private final int PORT = 3001;
    private final int MAX_PACKET_SIZE = 65507;
    private final int TIMEOUT = 5000;
    private BlockingQueue<DatagramPacket> rawQueue;

    public UdpReader() {
    }

    public UdpReader(BlockingQueue<DatagramPacket> rawQueue) {
        this.rawQueue = rawQueue;
    }

    public void run() {
        System.out.println("Starting UdpReader.");

        int receivedDatagrams = 0;
        int receivedBytes = 0;
        try (DatagramSocket client = new DatagramSocket(PORT)) {
            client.setSoTimeout(TIMEOUT);
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[MAX_PACKET_SIZE], MAX_PACKET_SIZE);
                client.receive(packet);
                receivedDatagrams++;
                receivedBytes += packet.getLength();
                //System.out.println("Received datagram size " + packet.getLength());
                rawQueue.put(packet);
            }
        } catch (Exception e) {
            System.out.println("Stop UdpReader");
            System.out.println("Processed " + receivedDatagrams + " datagrams (" + receivedBytes + ") bytes.");
        }
    }
}
