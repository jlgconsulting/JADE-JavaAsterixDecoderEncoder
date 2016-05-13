/* 
* Created by dan-geabunea on 5/13/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item500;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.UnsignedNumericDecoder;

/**
 * Item 500 Subfield 5 - Accuracy of track barometric altitude
 * Estimated accuracy (i.e. standard deviation) of the
 * calculated barometric altitude of the track.
 * Unit of emasure: 1/4 FL
 */
public class Item500Subfield5 extends FixedLengthAsterixData {
    private int accuracyForBarometricAltitude;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accuracyForBarometricAltitude = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("ABA (Barometric altitude component)", this.accuracyForBarometricAltitude);
    }

    /**
     * @return The accuracy of the track barometric altitude, expressed in 1/4 FL
     */
    public int getAccuracyForBarometricAltitude() {
        return accuracyForBarometricAltitude;
    }
}
