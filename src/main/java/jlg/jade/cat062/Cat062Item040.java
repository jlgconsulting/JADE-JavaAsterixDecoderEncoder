/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixItem;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 040 - Track number - Mandatory
 * Unique identification of a track
 */
public class Cat062Item040 extends FixedLengthAsterixItem {
    private int trackNb;

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {
        this.trackNb =
                Byte.toUnsignedInt(input[offset]) * 256 +
                Byte.toUnsignedInt(input[offset + 1]);

        appendItemDebugMsg("Track number", trackNb);

        return offset + this.sizeInBytes;
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    public int getTrackNb() {
        return trackNb;
    }
}
