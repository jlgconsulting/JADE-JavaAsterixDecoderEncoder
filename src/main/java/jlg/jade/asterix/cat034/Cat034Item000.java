/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat034 Item000 - Message Type
 * This Data Item allows for a more convenient handling of the messages at the receiver side by further defining the type of transaction.
 */
public class Cat034Item000 extends FixedLengthAsterixData {
    private int messageType;

    @Override
    protected int setSizeInBytes() {
        return 1;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.messageType = UnsignedNumericDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Message Type", this.messageType);
    }

    @Override
    protected String setDisplayName() {
        return "Cat034 Item000 - Message Type";
    }

    public int getMessageType() {
        return messageType;
    }
}
