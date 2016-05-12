/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item500;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.UnsignedNumericDecoder;

/**
 * Item 500 Subfield 4 - Accurracy of track geometric altitude
 * Estimated accuracy (i.e. standard deviation) of the
 * calculated geometric altitude of a target.
 * Unit of measure: 6.25 ft
 */
public class Item500Subfield4 extends FixedLengthAsterixData {
    private int accuracyForGeometricAltitude;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accuracyForGeometricAltitude = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("AGA (Accuracy Geometric Altitude)", this.accuracyForGeometricAltitude);
    }

    /**
     * @return The accurracy for the track geometric altitude
     * Unit of measure: 6.25 ft
     */
    public int getAccuracyForGeometricAltitude() {
        return accuracyForGeometricAltitude;
    }
}
