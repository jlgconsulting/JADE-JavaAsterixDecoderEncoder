/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat004 Item035 - Track Number 2
 * Together with I004/030, this item defines the track pair in
 * conflict.
 *
 * @implSpec 1. This is the track number of the second track involved in the conflict in
 * case of an STCA or a RIMCA.
 * 2. For the other Safety Net functions, this item is not used.
 * 3. This track number is distributed in this field exactly as it was received
 * from the Radar Processor Unit and its range is depending on the range
 * used by that unit
 */
public class Cat004Item035 extends FixedLengthAsterixData {
    private int trackNumber;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.trackNumber = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Track Number", this.trackNumber);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item035 - Track Number 2";
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
