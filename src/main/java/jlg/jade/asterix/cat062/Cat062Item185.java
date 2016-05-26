/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.Constants;

/**
 * Cat 062 item 185 - Calculated Track Velocity - Optional
 * Calculated track velocity expressed in Cartesian co-ordinates,
 * in two’s complement form.
 * Unit of measure: 0.25 m/s
 * Validation:
 * -8192m/s ≤ Vx ≤ 8191.75m/s
 * -8192m/s ≤ Vy ≤ 8191.75m/s
 */
public class Cat062Item185 extends FixedLengthAsterixData {
    private int vx;
    private int vy;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.vx = input[offset]*256 + Byte.toUnsignedInt(input[offset+1]);
        this.vy = input[offset+2]*256 + Byte.toUnsignedInt(input[offset+3]);
    }

    @Override
    protected boolean validate() {
        //The ICD validation can never be infringed on decoding since -32768 and 32767 are the maximum
        //signed values that can be represented on 2 octets. Validation can be used for encoding.
        int minVal = -8192 * Constants.FROM_ASTERIX_TO_METERS_PER_SECOND;
        int maxVal = (int) (8191.75 * Constants.FROM_ASTERIX_TO_METERS_PER_SECOND);

        if(this.vx < minVal || this.vx > maxVal){
            appendDebugMsg("Invalid item. Vx is not within limits of -32768 and 32767. Vx: " + this.vx);
            return false;
        }
        if(this.vy < minVal || this.vy > maxVal){
            appendDebugMsg("Invalid item. Vy is not within limits of -32768 and 32767. Vx: " + this.vx);
            return false;
        }
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item185 - Calculated Track Velocity";
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    /**
     * Gets the track velocity on x axis in 0.25 m/s
     */
    public int getVx() {
        return vx;
    }

    /**
     * Gets the track velocity on y axis in 0.25 m/s
     */
    public int getVy() {
        return vy;
    }
}
