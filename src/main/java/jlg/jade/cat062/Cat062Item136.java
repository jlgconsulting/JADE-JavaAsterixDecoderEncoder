/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.TwoComplementDecoder;

/**
 * Cat 062 Item 136 - Measured Flight Level (MFL)
 * Last valid and credible flight level used to update the track, in
 * two’s complement form. The criteria to determine the credibility of the flight level are Tracker
 * dependent.Credible means: within reasonable range of change with respect to the previous detection
 * Validation: -15FL to 1500 FL
 */
public class Cat062Item136 extends FixedLengthAsterixData {
    private int measuredFLightLevel;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.measuredFLightLevel = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Measured Flight Level (0.25FL)", this.measuredFLightLevel);
        appendItemDebugMsg("Measured Flight Level (FL)", getMeasuredFlightLevelInFL());
    }

    @Override
    protected boolean validate() {
        int minAllowedValue = -60;
        int maxAllowedValue = 6000;
        if (this.measuredFLightLevel >= minAllowedValue && this.measuredFLightLevel <= maxAllowedValue) {
            return true;
        }
        appendDebugMsg("MFL is not valid. The MFL must be between -15 and 1500 Asterix UM.");
        appendNewLine();
        return false;
    }

    /**
     * @return The measured flight level, expressed as 0.25 FL units
     */
    public int getMeasuredFlightLevel() {
        return measuredFLightLevel;
    }

    /**
     * @return The measured flight level, expressed in FL
     */
    public int getMeasuredFlightLevelInFL() {
        return measuredFLightLevel / 4;
    }
}
