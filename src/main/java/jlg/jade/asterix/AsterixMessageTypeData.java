/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.common.UnsignedNumericDecoder;

/**
 * This Data Item allows for a more convenient handling of the
 * messages at the receiver side by further defining the type of
 * transaction. This is a base class to be implemnted by all items that
 * represent message types on one octet
 */
public abstract class AsterixMessageTypeData extends FixedLengthAsterixData {
    private int messageType;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.messageType = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("Message Type (0=SDPD Status, 1=End of Batch, 2=Service Status)", this.messageType);

    }

    public int getMessageType() {
        return messageType;
    }
}
