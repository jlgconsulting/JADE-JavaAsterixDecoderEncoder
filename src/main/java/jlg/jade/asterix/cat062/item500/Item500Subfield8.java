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
 * Item 500 Sibfield 8 - Estimated accuracy of ROCD
 * Unit of measure: 6.25 feet / minute
 */
public class Item500Subfield8 extends FixedLengthAsterixData {
    private int accuracyForRocd;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accuracyForRocd = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("Accuracy for ROCD", this.accuracyForRocd);
    }

    /**
     * @return The accuracy for the rate of climb and descent
     * Unit of measure: 6.25 feet / min
     */
    public int getAccuracyForRocd() {
        return accuracyForRocd;
    }

    @Override
    protected String setDisplayName() {
        return "Item500Subfield8 - Accurracy of ROCD";
    }
}
