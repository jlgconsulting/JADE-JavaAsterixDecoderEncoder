/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.TwoComplementDecoder;
import jlg.jade.common.Constants;

/**
 * Item 380 Subfield 23 - Geometric altitude
 * Altitude in two’s complement form: -1500 ft ≤ Altitude ≤ 150000 ft
 * Unit of measure: 6.25 ft
 */
public class Item380Subfield23 extends FixedLengthAsterixData {
    private int geometricAltitude;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.geometricAltitude = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Geometric altitude", this.geometricAltitude);
    }

    @Override
    protected boolean validate() {
        int minAllowedVal = -240;   // -1500 ft
        int maxAllowedVal = 24000;  // 150000 ft

        if (geometricAltitude >= minAllowedVal && geometricAltitude <= maxAllowedVal) {
            return true;
        }
        appendDebugMsg("Subfield is invalid (not between -240 (-1500ft) and 24000 (150000ft)");
        appendNewLine();
        return false;
    }

    public int getGeometricAltitude() {
        return geometricAltitude;
    }

    /**
     * @return The geometric altitude expressed in feet. The result is converted to an
     * integer, so a slight loss of precision will take place
     */
    public int getGeometricAltitudeFeet() {
        return (int) (geometricAltitude * Constants.FROM_ASTERIX_ALTITUDE_TO_FT);
    }
}
