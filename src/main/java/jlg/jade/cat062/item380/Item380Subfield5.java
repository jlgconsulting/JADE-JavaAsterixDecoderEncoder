/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.AsterixSubfield;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Item 380 Subfield #5 - True Air Speed
 * Unit of measure: knots
 */
public class Item380Subfield5 extends AsterixSubfield{
    private int trueAirSpeedKn;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {
        this.trueAirSpeedKn =
                Byte.toUnsignedInt(input[offset])* 256 +
                Byte.toUnsignedInt(input[offset+1]);

        appendItemDebugMsg("True air speed (kn)", this.trueAirSpeedKn);

        return offset + this.sizeInBytes;
    }

    @Override
    protected boolean validate() {
        if(this.trueAirSpeedKn < 0 || this.trueAirSpeedKn > 2046){
            appendDebugMsg("Subfield not valid. True Airspeed is invalid (not between 0 and 2046). Airspeed: " + this.trueAirSpeedKn);
            return false;
        }

        return true;
    }

    /**
     * @return The true air speed of the aircraft in knots
     */
    public int getTrueAirSpeedKn() {
        return trueAirSpeedKn;
    }
}
