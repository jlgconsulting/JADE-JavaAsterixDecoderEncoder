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
 * Item 290 Subfield 3 - SSR Age
 * Age of the last secondary detection used to update the track
 */
public class Item290Subfield3 extends FixedLengthAsterixData {
    private int ssrAge;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.ssrAge = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("SSR Age", ssrAge);
        appendItemDebugMsg("SSR Age (sec)", getSsrAgeSeconds());
    }

    /**
     * @return The SSR age in 1/4 sec
     */
    public int getSsrAge() {
        return ssrAge;
    }

    /**
     * @return The SSR age in seconds
     */
    public int getSsrAgeSeconds() {
        return ssrAge / Constants.FROM_QUARTER_OF_SEC_TO_SEC;
    }
}
