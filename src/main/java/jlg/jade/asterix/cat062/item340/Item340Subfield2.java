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
 * Item 340 Subfield 2 - Measured Position
 *
 * @implSpec 1. In case of a plot, the measured bias-corrected polar coordinates;
 * 2. In case of a sensor local track, the measured bias-corrected
 * polar co-ordinates of the plot associated to the track;
 * 3. In case of a local track without detection, the extrapolated biascorrected
 * polar co-ordinates.
 */
public class Item340Subfield2 extends FixedLengthAsterixData {
    private int measuredDistance;
    private int measuredAzimuth;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.measuredDistance = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.measuredAzimuth = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + 2);

        appendItemDebugMsg("Measured distance (1/256 NM)", this.measuredDistance);
        appendItemDebugMsg("Measured azimuth (0.0055 deg)", this.measuredAzimuth);
    }

    /**
     * @return The measured distance to the aircraft
     * Unit of measure: 1/256 Nautical Miles
     */
    public int getMeasuredDistance() {
        return measuredDistance;
    }

    /**
     * @return The measured azimuth to the aircraft
     * Unit of measure: 0.0055 degrees
     */
    public int getMeasuredAzimuth() {
        return measuredAzimuth;
    }
}
