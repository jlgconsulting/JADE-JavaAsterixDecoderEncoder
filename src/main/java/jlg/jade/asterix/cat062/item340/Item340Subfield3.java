/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item340;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Item 340 Subfield 3 - Measured 3D Height
 */
public class Item340Subfield3 extends FixedLengthAsterixData {
    private int measured3dDistance;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.measured3dDistance = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Measured 3D distance (25 ft)", this.measured3dDistance);
    }

    /**
     * @return The measured 3D distance to the aircraft
     * Unit of measure: 25 feet
     */
    public int getMeasured3dDistance() {
        return measured3dDistance;
    }

    @Override
    protected String setDisplayName() {
        return "Item340Subfield3 - Measured 3D Height";
    }
}
