/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.Constants;

/**
 * Item 380 Subfield 27 - Mach Number
 * Unit of measure: 0.008 Mach Number
 * Validation: 0 ≤ Mach Number ≤ 4.096 (Aorx Mach 32)
 */
public class Cat062Item380Subfield27 extends FixedLengthAsterixData {
    private int machNumber;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.machNumber =
                Byte.toUnsignedInt(input[offset]) * 256 + Byte.toUnsignedInt(input[offset + 1]);
        appendItemDebugMsg("Mach number", this.machNumber);
        appendItemDebugMsg("Mach speed", getMachSpeed());
    }

    @Override
    protected boolean validate(){
        if(machNumber >= 0 && machNumber <= 4096){
            return true;
        }
        appendDebugMsg("Subfield is not valid. Value must be between 0 and 4096.");
        return false;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item380Subfield27 - Mach Number";
    }

    /**
     * @return The mach number in Asterix unit of measure
     */
    public int getMachNumber() {
        return machNumber;
    }

    /**
     * @return The real mach speed as a double value.
     */
    public double getMachSpeed() {
        return machNumber * Constants.FROM_ASTERIX_MACH_NB_TO_REAL_MACH_SPEED;
    }
}
