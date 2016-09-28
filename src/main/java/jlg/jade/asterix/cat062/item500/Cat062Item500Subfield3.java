/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item500;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Item 500 Subfield 3 - Estimated accurracy of the track position WSG-84
 * Estimated accuracy (i.e. standard deviation) of the
 * calculated position of a target expressed in WGS-84
 * Unit of measure: 180/2 pow 25 degrees
 */
public class Cat062Item500Subfield3 extends FixedLengthAsterixData {
    private int accurracyForPositionLat;
    private int accurracyForPositionLon;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accurracyForPositionLat = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.accurracyForPositionLon = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + 2);

        appendItemDebugMsg("APW (Latitude component)", this.accurracyForPositionLat);
        appendItemDebugMsg("APW (Longotude component)", this.accurracyForPositionLon);
    }

    /**
     * @return The estimated accurracy for the latitude component of
     * the calculated position (WSG 84).
     * Unit of measure: 180/2 pow 25 degrees
     */
    public int getAccurracyForPositionLat() {
        return accurracyForPositionLat;
    }

    /**
     * @return The estimated accurracy for the longitude component of
     * the calculated position (WSG 84).
     * Unit of measure: 180/2 pow 25 degrees
     */
    public int getAccurracyForPositionLon() {
        return accurracyForPositionLon;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item500Subfield3 - Accurracy of Track Position WSG-84";
    }
}
