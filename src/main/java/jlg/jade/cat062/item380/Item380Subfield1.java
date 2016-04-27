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
 * Item 380 #1 - Traget Address
 */
public class Item380Subfield1 extends AsterixSubfield {
    private String targetAddress;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {
        this.targetAddress =
                String.format("%d%d%d",
                        Byte.toUnsignedInt(input[offset]),
                        Byte.toUnsignedInt(input[offset + 1]),
                        Byte.toUnsignedInt(input[offset + 2]));

        return offset + this.sizeInBytes;
    }

    @Override
    protected boolean validate() {
        return true;
    }

    public String getTargetAddress() {
        return targetAddress;
    }
}
