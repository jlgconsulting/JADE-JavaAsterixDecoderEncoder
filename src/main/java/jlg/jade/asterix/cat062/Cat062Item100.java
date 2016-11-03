/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.nio.ByteBuffer;

/**
 * Cat 062 Item 100 - Calculated Track Position (Cartesian) - Optional
 * Calculated position in Cartesian co-ordinates with a resolution of
 * 0.5m, in two’s complement form
 */
public class Cat062Item100 extends FixedLengthAsterixData {
    private int x;
    private int y;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        //MSB must be interpreted as signed, so we do not covert it to unsigned value

        this.x =
                input[offset] * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 1]) * 256 +
                        Byte.toUnsignedInt(input[offset + 2]);
        this.y =
                input[offset + 3] * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 4]) * 256 +
                        Byte.toUnsignedInt(input[offset + 5]);

        appendItemDebugMsg("X", this.x);
        appendItemDebugMsg("Y", this.y);
    }

    @Override
    public byte[] encode() {
        byte[] xAsByteArray = ByteBuffer.allocate(4).putInt(this.x).array();
        byte[] yAsByteArray = ByteBuffer.allocate(4).putInt(this.y).array();

        int xOffset = 0;
        int yOffset = 3;
        int sizeOfCartesianComponentByteArray = 3;
        byte[] itemAsByteArray = new byte[this.sizeInBytes];

        /*
        When we copy the array, we need to skip the first bit in the x and y components. This must
        be done because the components are represented on 3 bytes, not on 4 (as normal int values)
         */
        int sourceOffset = 1;

        System.arraycopy(xAsByteArray, sourceOffset, itemAsByteArray, xOffset, sizeOfCartesianComponentByteArray);
        System.arraycopy(yAsByteArray, sourceOffset, itemAsByteArray, yOffset, sizeOfCartesianComponentByteArray);

        return itemAsByteArray;
    }

    @Override
    protected boolean validate() {
        //no validation rules in ICD
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item100 - Calculated Track Position - Cartesian";
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
     * Set the x component of the cartesian position.
     * Unit of measure is 0.5 meters
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * The Y cartesian position expressed in 0.5 meters
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y component of the cartesian position.
     * Unit of measure is 0.5 meters
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
