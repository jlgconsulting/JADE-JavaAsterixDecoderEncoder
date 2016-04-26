/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.common.AsterixDecodingException;

/**
 * Generic definition of an Asterix Item with a fixed length. All fixed length items will derive from this
 * base class;
 */
public abstract class FixedLengthAsterixItem extends AsterixItem implements DecodableFixedLength {
    protected FixedLengthAsterixItem(){
        this.sizeInBytes = setSizeInBytes();
    }

    @Override
    public int decode(byte[] input, int offset) {
        checkLength(input,offset);
        int newOffset = decodeFromByteArray(input,offset);
        this.valid = validate();

        return newOffset;
    }

    protected abstract int setSizeInBytes();

    protected abstract int decodeFromByteArray(byte[] input, int offset);

    protected void checkLength(byte[] input, int offset) {
        String itemName = this.getClass().getSimpleName();

        appendDebugMsg(itemName + ":");
        appendNewLine();

        if (input.length < offset + sizeInBytes) {
            appendDebugMsg("Unexpected end of data found while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
            appendNewLine();
            throw new AsterixDecodingException.UnexpectedEndOfData("Unexpected end of data found while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
        }

        //add byte information to debug message
        appendDebugMsg(String.format("%-30s", "Received byte information: "));
        if(sizeInBytes != AsterixItemLength.VARIABLE.getValue()) {
            for (int i = offset; i < offset+sizeInBytes;i++){
                appendDebugMsg(" " + Byte.toUnsignedInt(input[i]));
            }
        }
        appendNewLine();
    }
}
