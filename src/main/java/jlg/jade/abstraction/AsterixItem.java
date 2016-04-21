/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.common.AsterixDecodingException;

/**
 * Generic definition of an Asterix item. All implementation of items will derive from
 * this base class
 */
public abstract class AsterixItem extends DebugMessageSource {
    protected int sizeInBytes;

    protected AsterixItem(){
        this.sizeInBytes = AsterixItemLength.VARIABLE.getValue();
    }

    protected void validate() {
        return;
    }

    /**
     * Reset all Asterix item fields to their default values
     */
    public abstract void reset();

    /**
     * Checks if the remaining length in the input array is greater or equal than the needed length for
     * this item. If not, an UnexpectedEndOfData exception is thrown
     * @param input       the input array pf bytes
     * @param offset      the current index in the input array
     * @param inputLength the length of the input array
     * @throws jlg.jade.common.AsterixDecodingException.UnexpectedEndOfData
     */
    protected void checkLength(byte[] input, int offset, int inputLength) {
        String itemName = this.getClass().getSimpleName();

        appendDebugMsg(itemName + ":");
        appendNewLine();

        if (input.length < offset + sizeInBytes) {
            appendDebugMsg("Unexpected end of data found while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + inputLength);
            appendNewLine();
            throw new AsterixDecodingException.UnexpectedEndOfData("Unexpected end of data found while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + inputLength);
        }

        if (offset + sizeInBytes > inputLength) {
            appendDebugMsg("Unexpected end of data found while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + inputLength);
            appendNewLine();
            throw new AsterixDecodingException.UnexpectedEndOfData("Unexpected end of data found while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + inputLength);
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


    /**
     * Gets the length of the Asterix Item
     * @return An integer, representing the length in bytes or -1 if the length has not been set or is not fixed.
     */
    public int getSizeInBytes() {
        return sizeInBytes;
    }
}
