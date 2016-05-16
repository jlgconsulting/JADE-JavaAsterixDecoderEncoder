/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat 062 item 210 - Calculated acceleration - Optional
 * Calculated Acceleration of the target expressed in Cartesian
 * co-ordinates, in two’s complement form.
 * Unit of measure: 0.25 m/sec^2
 */
public class Cat062Item210 extends FixedLengthAsterixData {
    private int accelerationX;
    private int accelerationY;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.accelerationX = input[offset];
        this.accelerationY = input[offset+1];

        appendItemDebugMsg("Acceleration X", this.accelerationX);
        appendItemDebugMsg("Acceleration Y", this.accelerationY);
    }

    @Override
    protected boolean validate() {
        /**
         * No validation needed for decoding, only for encoding in order to make sure we
         * do not instantiate class with values that exceed -128 and 127.
         */

        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    /**
     * Returns the acceleration on X axis expressed in 0.25 m/s^2
     */
    public int getAccelerationY() {
        return accelerationY;
    }

    /**
     * Returns the acceleration on X axis expressed in 0.25 m/s^2
     */
    public int getAccelerationX() {
        return accelerationX;
    }
}
