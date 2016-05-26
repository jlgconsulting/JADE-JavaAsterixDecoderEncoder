/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat065;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat 065 Item 000 - Message Type
 * This Data Item allows for a more convenient handling of the
 * messages at the receiver side by further defining the type of
 * transaction.
 */
public class Cat065Item000 extends FixedLengthAsterixData {
    private int messageType;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.messageType = UnsignedNumericDecoder.decodeFromOneByte(input,offset);
        appendItemDebugMsg("Message Type", this.messageType);
    }

    @Override
    protected String setDisplayName() {
        return "Cat065Item000 - Message Type";
    }

    public int getMessageType() {
        return messageType;
    }
}
