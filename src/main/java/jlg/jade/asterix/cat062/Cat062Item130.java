/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.Constants;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat 062 Item 130 - Calculated Track Geometric Altitude - Opt
 * Vertical distance between the target and the projection of its
 * position on the earth’s ellipsoid, as defined by WGS84, in two’s
 * complement form
 *
 * @implSpec The source of altitude is identified in bits (SRC)
 * of item I062/080 Track Status
 * Validation: -1500 ft < ga < 150000 ft
 * Unit of measure: 6.25 ft
 */
public class Cat062Item130 extends FixedLengthAsterixData {
    private int geometricAltitude;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.geometricAltitude = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Geometric Altitude (6.25 ft)", this.geometricAltitude);
    }

    @Override
    protected boolean validate() {
        int minAllowedVal = -240;   // -1500 / 6.25
        int maxAllowedVal = 24000;  // 150000 / 6.25

        if (geometricAltitude >= minAllowedVal && geometricAltitude <= maxAllowedVal) {
            return true;
        }

        appendDebugMsg("Geometric altitude is invalid. Should be between -1500 and 150000.");
        appendNewLine();
        return false;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item130 - Calculated Track Geometric Altitude";
    }

    /**
     * @return The Geometric altitude, expressed as 6.25 ft units
     */
    public int getGeometricAltitude() {
        return geometricAltitude;
    }

    /**
     * Set the geometric altitude, expressed as 6.25 ft units
     */
    public void setGeometricAltitude(int geometricAltitude) {
        this.geometricAltitude = geometricAltitude;
    }

    /**
     * @return The geometric altitude, expressed in feet.
     */
    public double getGeometricAltitudeFeet() {
        return geometricAltitude / Constants.FROM_ASTERIX_ALT_TO_FEET;
    }
}
