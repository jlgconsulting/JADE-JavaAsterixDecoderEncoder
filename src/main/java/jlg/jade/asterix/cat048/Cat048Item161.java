/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat048Item161 - Track Number
 * An integer value representing a unique reference to a track record within a particular track file.
 */
public class Cat048Item161 extends FixedLengthAsterixData {
    private int trackNumber;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.trackNumber = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);

        appendItemDebugMsg("Track number", this.trackNumber);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item161 - Track Number";
    }

    /**
     * @return should return true for track number values between 0 and 4095
     */
    @Override
    protected boolean validate() {
        if (this.trackNumber < 0 || this.trackNumber > 4095) {
            appendDebugMsg(
                    "Item is not valid. Range should be between 0 and 4095. Track number:" + this.trackNumber);
            return false;
        }
        return true;
    }

    public int getTrackNumber() {
        return trackNumber;
    }
}
