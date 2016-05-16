/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item340;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.abstraction.ModeACode;
import jlg.jade.asterix.AsterixItemLength;

import java.util.BitSet;

/**
 * Item 340 Subfield 5 - Last Measured Mode 3/A Code
 */
public class Item340Subfield5 extends FixedLengthAsterixData {
    private boolean codeValidation;
    private boolean codeGarbled;
    private boolean smoothed;
    private int lastMeasuredModeACode;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        final int BIT_INDEX_OF_VALIDATION = 7;
        this.codeValidation = bs.get(BIT_INDEX_OF_VALIDATION);

        final int BIT_INDEX_OF_GARBLE = 6;
        this.codeGarbled = bs.get(BIT_INDEX_OF_GARBLE);

        final int BIT_INDEX_OF_SMOOTH = 5;
        this.smoothed = bs.get(BIT_INDEX_OF_SMOOTH);

        int firstOctetValueWithoutVGL = Byte.toUnsignedInt(input[offset]);
        if (bs.get(BIT_INDEX_OF_VALIDATION)) {
            firstOctetValueWithoutVGL -= 128;
        }
        if (bs.get(BIT_INDEX_OF_GARBLE)) {
            firstOctetValueWithoutVGL -= 64;
        }
        if (bs.get(BIT_INDEX_OF_SMOOTH)) {
            firstOctetValueWithoutVGL -= 32;
        }
        this.lastMeasuredModeACode = firstOctetValueWithoutVGL * 256 + Byte.toUnsignedInt(input[offset + 1]);

        appendItemDebugMsg("Code validation", this.codeValidation);
        appendItemDebugMsg("Code garbled", this.codeGarbled);
        appendItemDebugMsg("Code smoothed", this.isSmoothed());
        appendItemDebugMsg("Last measured Mode A Code (dec)", this.lastMeasuredModeACode);
        appendItemDebugMsg("Last measured Mode A Code (octal)", getLastMeasuredModeACodeOctal());
    }

    /**
     * @return True, if the mode a code has been validated, false otherwise
     */
    public boolean getCodeValidation() {
        return codeValidation;
    }

    /**
     * @return True, if the code is garbled, false, otherwise
     */
    public boolean isCodeGarbled() {
        return codeGarbled;
    }

    /**
     * @return True, if the code is smoothed, false otherwise
     * @implSpec Normal code is derived from the reply of the transponder
     * Smoothed code is provided by a sensor local tracker. Smoothed MODE 3/A data (L = 1) will
     * be used in case of absence of MODE 3/A code information in the plot or in case of difference
     * between plot and sensor local track MODE 3/A code information.
     */
    public boolean isSmoothed() {
        return smoothed;
    }

    /**
     * @return The last measured Mode A code, in decimal
     */
    public int getLastMeasuredModeACode() {
        return lastMeasuredModeACode;
    }

    /**
     * @return The last measured Mode A code, in octal
     */
    public String getLastMeasuredModeACodeOctal() {
        return ModeACode.toOctal(this.lastMeasuredModeACode);
    }
}
