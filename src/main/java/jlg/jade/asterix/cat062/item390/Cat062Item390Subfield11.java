/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Item 390 Subfield 11 - Current control position
 *
 * @implSpec The centre and the control position identification codes have to be
 * defined between communication partners.
 */
public class Cat062Item390Subfield11 extends FixedLengthAsterixData {
    private int controlPosition;
    private int controlCenter;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.controlCenter = Byte.toUnsignedInt(input[offset]);
        this.controlPosition = Byte.toUnsignedInt(input[offset+1]);

        appendItemDebugMsg("Control center", this.controlCenter);
        appendItemDebugMsg("Control position", this.controlPosition);
    }

    /**
     * @return The control position ID
     */
    public int getControlPosition() {
        return controlPosition;
    }

    /**
     * @return The control center ID
     */
    public int getControlCenter() {
        return controlCenter;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item390Subfield11 - Current Control Position";
    }
}
