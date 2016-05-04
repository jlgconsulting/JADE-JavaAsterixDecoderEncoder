/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;

/**
 * Item 380 Subfield 17 - Track angle
 * Unit of measure: 0.0055 degrees
 */
public class Item380Subfield17 extends FixedLengthAsterixData {
    private int trackAngle;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.trackAngle =
                Byte.toUnsignedInt(input[offset]) * 256 +
                Byte.toUnsignedInt(input[offset + 1]);
        appendItemDebugMsg("Track angle", this.trackAngle);
    }

    public int getTrackAngle() {
        return trackAngle;
    }
}
