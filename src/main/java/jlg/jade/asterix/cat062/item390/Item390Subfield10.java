/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Item 390 Subfield 10 - Current Cleared Flight Level
 * Unit of measure: 1/4 FL (25 ft)
 */
public class Item390Subfield10 extends FixedLengthAsterixData {
    private int cfl;
    private int cflFlightLevel;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.cfl = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("CFL", this.cfl);
    }

    /**
     * @return The current cleared flight level in Asterix UM (1/4 FL)
     */
    public int getCfl() {
        return cfl;
    }

    /**
     * @return The current cleared flight level in FL
     */
    public int getCflInFlightLevel() {
        /**
         * @implSpec LSB = 1/4 FL => we divide by 4 to get FL value
         */
        return cfl / 4;
    }

    @Override
    protected String setDisplayName() {
        return "Item390Subfield10 - Current Cleared Flight Level";
    }
}
