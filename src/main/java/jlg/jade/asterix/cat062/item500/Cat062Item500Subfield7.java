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
 * Item 500 Subfield 7 - Accuracy of acceleration (cartesian)
 * Unit of measure: 0.25m/s^2
 */
public class Cat062Item500Subfield7 extends FixedLengthAsterixData {
    private int accuracyForAccelerationX;
    private int accuracyForAccelerationY;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accuracyForAccelerationX = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        this.accuracyForAccelerationY = UnsignedNumericDecoder.decodeFromOneByte(input, offset + 1);

        appendItemDebugMsg("AA (X Component)", this.accuracyForAccelerationX);
        appendItemDebugMsg("AA (Y Component)", this.accuracyForAccelerationY);
    }

    /**
     * @return The estimated accuracy for the cartesian acceleration
     * on the x component.
     * Unit of measure: 0.25m/s^2
     */
    public int getAccuracyForAccelerationX() {
        return accuracyForAccelerationX;
    }

    /**
     * @return The estimated accuracy for the cartesian acceleration
     * on the y component.
     * Unit of measure: 0.25m/s^2
     */
    public int getAccuracyForAccelerationY() {
        return accuracyForAccelerationY;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item500Subfield7 - Accurracy of Acceleration";
    }
}
