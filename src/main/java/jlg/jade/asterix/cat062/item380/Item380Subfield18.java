/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.Constants;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Item 380 Subfield 18 - Ground Speed
 * Ground Speed in two's complement form referenced to WGS84
 * Unit of measure: 0.22 kt
 * Validation: -2 NM/s ≤ Ground Speed < 2 NM/s
 */
public class Item380Subfield18 extends FixedLengthAsterixData {
    private int groundSpeed;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.groundSpeed = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Ground Speed", this.groundSpeed);
    }

    @Override
    protected boolean validate(){
        double groundSpeedInNmPerSecond = groundSpeed * Constants.FROM_ASTERIX_GROUND_SPEED_TO_KNOTS * Constants.FROM_KNOT_TO_NM_PER_SECOND;
        if(groundSpeedInNmPerSecond >= -2 && groundSpeedInNmPerSecond <= 2){
            return true;
        }
        appendDebugMsg("Ground speed is not valid (between -2 and 2 Nm/s)");
        appendNewLine();

        return false;
    }

    @Override
    protected String setDisplayName() {
        return "Item380Subfield18 - Ground Speed";
    }

    public int getGroundSpeed() {
        return groundSpeed;
    }

    /**
     * @return The Ground Speed converted in knots (NM / hour).
     */
    public double getGroundSpeedKnots() {
        return groundSpeed * Constants.FROM_ASTERIX_GROUND_SPEED_TO_KNOTS;
    }
}
