/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item290;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.common.Constants;

/**
 * Item 290 - Subfield 1 - Track Age
 * Actual track age since first occurence
 * Unit of measure 0.25 seconds
 */
public class Item290Subfield1 extends FixedLengthAsterixData {
    private int trackAge;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        trackAge = Byte.toUnsignedInt(input[offset]);
        appendItemDebugMsg("Track age (1/4sec)", trackAge);
    }

    /**
     * @return The track age in 1/4 seconds
     */
    public int getTrackAge() {
        return trackAge;
    }

    /**
     * @return The track age, expressed in seconds
     */
    public double getTrackAgeSeconds() {
        return trackAge / Constants.FROM_QUARTER_OF_SEC_TO_SEC;
    }
}
