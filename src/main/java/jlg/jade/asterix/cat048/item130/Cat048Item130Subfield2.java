/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048.item130;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat048Item130Subfield2 - Number of received replies for (M)SSR
 */
public class Cat048Item130Subfield2 extends FixedLengthAsterixData {
    private int receivedReplies;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.receivedReplies = UnsignedNumericDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Number of received replies for (M)SSR", this.receivedReplies);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130Subfield2 - Number of received replies for (M)SSR";
    }

    public int getReceivedReplies() {
        return receivedReplies;
    }
}
