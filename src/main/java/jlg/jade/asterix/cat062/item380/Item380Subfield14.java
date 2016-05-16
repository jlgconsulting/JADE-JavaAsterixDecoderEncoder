/* 
* Created by dan-geabunea on 4/29/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Item 380 Subfield #14 - Geometric Vertical Rate
 * Unit of measure: 6.25 ft / minute
 */
public class Item380Subfield14 extends FixedLengthAsterixData {
    private int geometricVerticalRate;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.geometricVerticalRate = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Geometric vertical rate", this.geometricVerticalRate);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    public int getGeometricVerticalRate() {
        return geometricVerticalRate;
    }
}
