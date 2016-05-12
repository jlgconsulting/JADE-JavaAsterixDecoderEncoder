/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item500;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.UnsignedNumericDecoder;

/**
 * Item 500 - Subfield 1 - Estimated accurracy og track position (cartesian)
 * Estimated accuracy (i.e. standard deviation) of the
 * calculated position of a target expressed in Cartesian co-ordinates
 * Unit of measure: 0.5 m
 */
public class Item500Subfield1 extends FixedLengthAsterixData {
    private int accuracyOfPositionX;
    private int accuracyOfPositionY;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accuracyOfPositionX = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.accuracyOfPositionY = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + 2);

        appendItemDebugMsg("APC X (Cartesian component)", this.accuracyOfPositionX);
        appendItemDebugMsg("APC Y (Cartesian component)", this.accuracyOfPositionY);
    }

    /**
     * @return The accurracy of the cartesian position on X axis,
     * expressed in 0.5 m
     */
    public int getAccuracyOfPositionX() {
        return accuracyOfPositionX;
    }

    /**
     * @return The accurracy of the cartesian position on Y axis,
     * expressed in 0.5 m
     */
    public int getAccuracyOfPositionY() {
        return accuracyOfPositionY;
    }
}
