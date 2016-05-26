/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Item 380 Subfield 26 - Indicated air speed
 * Unit of measure: knot
 * Validation: 0 Kt ≤ Indicated Airspeed ≤ 1100 Kt
 */
public class Item380Subfield26 extends FixedLengthAsterixData {
    private int indicatedAirSpeed;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.indicatedAirSpeed =
                Byte.toUnsignedInt(input[offset]) * 256 + Byte.toUnsignedInt(input[offset + 1]);
        appendItemDebugMsg("Indicated air speed", this.indicatedAirSpeed);
    }

    @Override
    protected boolean validate(){
        if(indicatedAirSpeed >= 0 && indicatedAirSpeed <= 1100){
            return true;
        }
        appendDebugMsg("Subfield is not valid (must be between 0 and 1100 kt)");
        appendNewLine();
        return false;
    }

    @Override
    protected String setDisplayName() {
        return "Item380Subfield26 - Indicated Air Speed";
    }

    /**
     * @return The indicated air speed expressed in knots
     */
    public int getIndicatedAirSpeed() {
        return indicatedAirSpeed;
    }
}
