/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.common.AsterixDecodingException;

/**
 * Generic definition for an Asterix repeatable item. The first octet represents the repetition
 * factor and it is followd by n repeatable blocks of a known size.
 */
public abstract class RepeatableAsterixData extends AsterixItem implements Decodable {
    private int repetitionFactor;
    private final int repeatableBlockSizeInBytes;

    protected RepeatableAsterixData() {
        this.repeatableBlockSizeInBytes = setRepeatableBlockSizeInBytes();
    }

    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        this.sizeInBytes = setSizeInBytes(input, offset);
        checkLength(input, offset, inputLength);
        /**
         * @implNote
         * We pass offset+1 because we used the first bit to get the repetition factor and
         * we are not interested to reparse it in the decoding process
         */
        decodeFromByteArray(input, offset + 1);
        this.valid = validate();

        return offset + sizeInBytes;
    }

    private int setSizeInBytes(byte[] input, int offset) {
        this.repetitionFactor = Byte.toUnsignedInt(input[offset]);

        int totalSize = (repetitionFactor * repeatableBlockSizeInBytes) + 1;

        return totalSize;
    }

    private void checkLength(byte[] input, int offset, int inputLength) {
        String itemName = this.getClass().getSimpleName();

        appendDebugMsg(itemName + ":");
        appendNewLine();

        /**
         * @implNote No more available length
         */
        if (offset + sizeInBytes > inputLength) {
            appendDebugMsg("Available length was exceeded while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
            appendNewLine();
            throw new AsterixDecodingException.AvailableLengthExceeded("Available length was exceeded while creating " +
                    "" + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
        }

        /**
         * @implNote Input does not have enough data
         */
        if (input.length < offset + sizeInBytes) {
            appendDebugMsg("Unexpected end of data found while creating " + itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
            appendNewLine();
            throw new AsterixDecodingException.UnexpectedEndOfData("Unexpected end of data found while creating " +
                    itemName +
                    " input: " + input.length + ", offset: " + offset + ", length: " + sizeInBytes);
        }

        //add byte information to debug message
        appendDebugMsg(String.format("%-30s", "Received byte information: "));
        if (sizeInBytes != AsterixItemLength.VARIABLE.getValue()) {
            for (int i = offset; i < offset + sizeInBytes; i++) {
                appendDebugMsg(" " + Byte.toUnsignedInt(input[i]));
            }
        }
        appendNewLine();
    }

    protected abstract int setRepeatableBlockSizeInBytes();

    protected abstract void decodeFromByteArray(byte[] input, int offset);

    /**
     * @return The repetition factor for this compunt data item
     */
    public int getRepetitionFactor() {
        return repetitionFactor;
    }

    /**
     * @return The size in bytes for each repeatable data block that makes up this item
     */
    public int getRepeatableBlockSizeInBytes() {
        return repeatableBlockSizeInBytes;
    }
}
