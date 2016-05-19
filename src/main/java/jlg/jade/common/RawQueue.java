/* 
* Created by dan-geabunea on 5/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
public class RawQueue{
    private BlockingQueue<DatagramPacket> rawQueue;

    public RawQueue(){
        this.rawQueue = new ArrayBlockingQueue<>(1000);
    }

    public BlockingQueue<DatagramPacket> getRawQueue() {
        return rawQueue;
    }
}
