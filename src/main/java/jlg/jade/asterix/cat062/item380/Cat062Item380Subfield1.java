/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Item 380 #1 - Traget Address
 */
public class Cat062Item380Subfield1 extends FixedLengthAsterixData {
    private String targetAddress;
    private String targetAddressHex;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.targetAddress = String.format("%d %d %d",
                        Byte.toUnsignedInt(input[offset]),
                        Byte.toUnsignedInt(input[offset + 1]),
                        Byte.toUnsignedInt(input[offset + 2]));

        this.targetAddressHex = String.format("%s%s%s",
                        Integer.toHexString(Byte.toUnsignedInt(input[offset])),
                        Integer.toHexString(Byte.toUnsignedInt(input[offset+1])),
                        Integer.toHexString(Byte.toUnsignedInt(input[offset+2])));

        appendItemDebugMsg("Subfield #1 - Target Address (dec)", targetAddress);
        appendItemDebugMsg("Subfield #2 - Target Address (hex)", targetAddressHex);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item380Subfield1 - Target Address";
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    /**
     * @return The target address in hex format (Mode S code). This format is used in operational
     * HMI apps.
     */
    public String getTargetAddressHex() {
        return targetAddressHex;
    }
}
