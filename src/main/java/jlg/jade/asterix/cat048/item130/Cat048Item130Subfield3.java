/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048.item130;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat048Item130Subfield3 - Amplitude of (M)SSR reply
 */
public class Cat048Item130Subfield3 extends FixedLengthAsterixData{
    private int amplitudeOfReply;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.amplitudeOfReply = TwoComplementDecoder.decodeFromOneByte(input, offset);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130Subfield3 - Amplitude of (M)SSR reply";
    }

    public int getAmplitudeOfReply() {
        return amplitudeOfReply;
    }
}
