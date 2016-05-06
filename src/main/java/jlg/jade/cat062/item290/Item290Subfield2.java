/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item290;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.UnsignedNumericDecoder;
import jlg.jade.common.Constants;

/**
 * Item 290 Subfield 2 - PSR Age
 * Age of the last primary detection used to update the track
 */
public class Item290Subfield2 extends FixedLengthAsterixData {
    private int psrAge;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.psrAge = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("PSR Age", this.psrAge);
        appendItemDebugMsg("PSR Age (sec)", getPsrAgeSeconds());

    }

    /**
     * @return The PSR age in 1/4 seconds
     */
    public int getPsrAge() {
        return psrAge;
    }

    /**
     * @return The PSR age in seconds
     */
    public int getPsrAgeSeconds() {
        return psrAge / Constants.FROM_QUARTER_OF_SEC_TO_SEC;
    }
}
