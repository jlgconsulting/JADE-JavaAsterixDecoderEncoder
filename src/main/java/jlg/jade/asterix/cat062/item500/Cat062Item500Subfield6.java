/* 
* Created by dan-geabunea on 5/13/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item500;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Accurcy of track velocity (cartesian)
 * Unit of measure: 0.25 m/s
 */
public class Cat062Item500Subfield6 extends FixedLengthAsterixData {
    private int accuracyForVelocityX;
    private int accuracyForVelocityY;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accuracyForVelocityX = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        this.accuracyForVelocityY = UnsignedNumericDecoder.decodeFromOneByte(input, offset + 1);

        appendItemDebugMsg("ATV (X Component)", this.accuracyForVelocityX);
        appendItemDebugMsg("ATV (Y Component)", this.accuracyForVelocityY);
    }

    /**
     * @return The accuracy for the cartesian track velocity - vx component
     * Unit of measure: 0.25 m/s
     */
    public int getAccuracyForVelocityX() {
        return accuracyForVelocityX;
    }

    /**
     * @return The accuracy for the cartesian track velocity - vy component
     * Unit of measure: 0.25 m/s
     */
    public int getAccuracyForVelocityY() {
        return accuracyForVelocityY;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item500Subfield6 - Accurracy of Track Velocity";
    }
}
