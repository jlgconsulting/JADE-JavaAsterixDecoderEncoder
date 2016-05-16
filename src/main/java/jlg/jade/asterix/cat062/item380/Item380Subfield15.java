/* 
* Created by dan-geabunea on 4/29/2016.
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
 * Item 380 Subfield 15 - Roll Angle
 * Unit of measure: 0.01 degrees, expressed in two's complement form
 */
public class Item380Subfield15 extends FixedLengthAsterixData{
    private int rollAngle;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.rollAngle = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Roll Angle", this.rollAngle);
        appendItemDebugMsg("Roll Angle (deg)", getRollAngleDegrees());
    }

    @Override
    protected boolean validate() {
        /**
         * @implSpec -180 ≤ Roll Angle ≤ 180
         */

        return getRollAngleDegrees() >= -180 && getRollAngleDegrees() <= 180;
    }

    public int getRollAngle() {
        return rollAngle;
    }

    public int getRollAngleDegrees(){
        return (int) (this.rollAngle * Constants.FROM_ASTERIX_ROLL_ANGLE_TO_DEGREES);
    }
}
