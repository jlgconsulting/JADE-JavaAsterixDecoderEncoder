/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 100 - Calculated Track Position (Cartesian) - Optional
 * Calculated position in Cartesian co-ordinates with a resolution of
 * 0.5m, in two’s complement form
 */
public class Cat062Item100 extends FixedLengthAsterixData {
    private int x;
    private int y;

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {
        //MSB must be interpreted as signed, so we do not covert it to unsigned value

        this.x =
                input[offset] * 256 * 256 +
                Byte.toUnsignedInt(input[offset + 1]) * 256 +
                Byte.toUnsignedInt(input[offset + 2]);
        this.y =
                input[offset + 3] * 256 * 256 +
                Byte.toUnsignedInt(input[offset + 4]) * 256 +
                Byte.toUnsignedInt(input[offset + 5]);

        appendItemDebugMsg("X",this.x);
        appendItemDebugMsg("Y", this.y);

        return offset + sizeInBytes;
    }

    @Override
    protected boolean validate() {
        //no validation rules in ICD
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SIX_BYTES.getValue();
    }

    /**
     * The X cartesian position expressed in 0.5 meters
     */
    public int getX() {
        return x;
    }

    /**
     * The Y cartesian position expressed in 0.5 meters
     */
    public int getY() {
        return y;
    }
}
