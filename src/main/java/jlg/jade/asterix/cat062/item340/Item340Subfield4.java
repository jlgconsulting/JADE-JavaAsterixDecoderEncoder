/*
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item340;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

import java.util.BitSet;

/**
 * Item 340 Subfield 4 - Last Measured Mode C Code
 */
public class Item340Subfield4 extends FixedLengthAsterixData {
    private boolean codeValidation;
    private boolean codeGarbled;
    private int lastMeasuredModeC;

    @Override
    protected int setSizeInBytes() {
        return 2;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        final int BIT_INDEX_OF_VALIDATION = 7;
        this.codeValidation = bs.get(BIT_INDEX_OF_VALIDATION);

        final int BIT_INDEX_OF_GARBLE = 6;
        this.codeGarbled = bs.get(BIT_INDEX_OF_GARBLE);

        int firstOctetValueWithoutGrableAndValidation = input[offset];
        if (bs.get(BIT_INDEX_OF_VALIDATION)) {
            firstOctetValueWithoutGrableAndValidation -= 128;
        }
        if (bs.get(BIT_INDEX_OF_GARBLE)) {
            firstOctetValueWithoutGrableAndValidation -= 64;
        }
        final int BIT_INDEX_SIGN = 5;
        if (bs.get(BIT_INDEX_SIGN)) {
            //two complement form 2^n - x - 1 where n = 5 in our case
            firstOctetValueWithoutGrableAndValidation = 32 - firstOctetValueWithoutGrableAndValidation - 1;
        }
        this.lastMeasuredModeC = firstOctetValueWithoutGrableAndValidation * 256 + UnsignedNumericDecoder
                .decodeFromOneByte(input, offset + 1);

        appendItemDebugMsg("Code validation", this.codeValidation);
        appendItemDebugMsg("Code garbeled", this.codeGarbled);
        appendItemDebugMsg("Last measured Mode C", this.lastMeasuredModeC);
    }

    @Override
    protected boolean validate() {
        final int MIN = -48;    //-12 FL
        final int MAX = 5080;   //1270 FL

        if (this.lastMeasuredModeC >= MIN && this.lastMeasuredModeC <= MAX) {
            return true;
        }
        appendDebugMsg("Subfiled not valid. Mode C should be between -48 and 5080.");
        return false;
    }

    @Override
    protected String setDisplayName() {
        return "Item340Subfield4 - Last Measured Mode-C Code";
    }

    /**
     * @return True, if the mode c code has been validated, false otherwise
     */
    public boolean getCodeValidation() {
        return codeValidation;
    }

    /**
     * @return True, if the mode c code is garbled, false otherwise
     */
    public boolean isCodeGarbled() {
        return codeGarbled;
    }

    /**
     * @return The last measured Mode C code in 1/4 FL (25 ft)
     */
    public int getLastMeasuredModeC() {
        return lastMeasuredModeC;
    }
}
