/* 
* Created by dan-geabunea on 4/29/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.TwoComplementDecoder;

/**
 * Item 380 Subfield 13 - Barometric Vertical Rate
 * Unit of measure is 6.25 feet / minute
 */
public class Item380Subfield13 extends FixedLengthAsterixData {
    private int barometricVerticalRate;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.barometricVerticalRate = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Barometric vertical rate", this.barometricVerticalRate);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    /**
     * @return The barometric vertical rate in 6.25 ft/min
     */
    public int getBarometricVerticalRate() {
        return barometricVerticalRate;
    }
}
