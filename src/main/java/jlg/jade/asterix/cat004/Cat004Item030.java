package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat 004 Item 030 - Track Number 1
 * This is the track number of the first track involved in the conflict in case
 * of an STCA or a RIMCA or the track involved in case of one of the other
 * Safety Net functions.
 * This track number is distributed in this field exactly as it was received
 * from the Radar Processor Unit (identified by I004/015) and its range is
 * depending on the range used by that unit
 */
public class Cat004Item030 extends FixedLengthAsterixData {
    private int trackNumber;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.trackNumber = UnsignedNumericDecoder.decodeFromTwoBytes(input,offset);
        appendItemDebugMsg("Track Number", this.trackNumber);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item030 - Track Number 1";
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
