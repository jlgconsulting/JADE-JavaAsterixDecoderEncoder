/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.ModeACode;

import java.util.BitSet;

/**
 * Asterix Cat 062 Item 060 - Mode 3/A - Optional
 * Mode-3/A code converted into octal representation.
 */
public class Cat062Item060 extends FixedLengthAsterixData {
    private boolean modeAChange;
    private int modeADecimal;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet firstOctetBits = BitSet.valueOf(new byte[]{input[offset]});

        /**
         * @implNote
         * We interpret bit 5 to determine if the mode 3A has changed
         * In the ICD, it says bit 14, but when we use bit set, because of
         * eandianess we need to interrogate bit number 5. We transform the first octet
         * to bits, and we look at it in reverse
         */
        final int CHANGE_BIT = 5;
        int firstOctetValueForModeA;
        if(firstOctetBits.get(CHANGE_BIT)){
            this.modeAChange = true;
            //assume bit 5 is 0 => we subtract 32 (2 pow 5) from octet value (as if bit 5 was 0)
            firstOctetValueForModeA = Byte.toUnsignedInt(input[offset]) - 32;
        }
        else{
            this.modeAChange = false;
            firstOctetValueForModeA = Byte.toUnsignedInt(input[offset]);
        }

        this.modeADecimal =
                firstOctetValueForModeA*256 +
                Byte.toUnsignedInt(input[offset+1]);


        appendItemDebugMsg("Mode A changed", this.modeAChange);
        appendItemDebugMsg("Mode A value (decimal)", this.modeADecimal);
        appendItemDebugMsg("Mode A value (octal)", this.getModeAOctal());
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    /**
     * @return True, if the Mode A has changed since last update, false otherwise
     */
    public boolean getModeAChange() {
        return modeAChange;
    }

    /**
     * @return The value of Mode 3A in decimal format
     */
    public int getModeADecimal() {
        return modeADecimal;
    }

    public String getModeAOctal() {
        return ModeACode.toOctal(this.modeADecimal);
    }
}
