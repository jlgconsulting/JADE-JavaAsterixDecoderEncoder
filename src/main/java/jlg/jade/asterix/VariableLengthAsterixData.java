/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.common.Decodable;

import java.util.BitSet;

/**
 * Represents an Asterix data item with a variable length, where the size is calculated based
 * on the FX bit. If the FX bit is 0, then another octet of data is availbale, else the data
 * ends. Will be implemented by all Asterix items with variable length.
 * Note: This subclass must be extended only if the total size of the item can be deduced from the
 * FX bits. If the field has 2 parts (spec and data), then use the FspecAsterixData abstract class.
 */
public abstract class VariableLengthAsterixData extends AsterixItem implements Decodable {

    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        this.sizeInBytes = setSizeInBytes(input, offset);
        decodeFromByteArray(input,offset);
        this.valid = validate();

        return offset + sizeInBytes;
    }

    protected abstract void decodeFromByteArray(byte[] input, int offset);

    protected int setSizeInBytes(byte[] input, int offset) {
        int currentLength = 1;
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        String itemName = this.getClass().getSimpleName();

        appendDebugMsg(itemName + ":");
        appendNewLine();

        while (bs.get(0)){
            appendDebugMsg("  -- FX bit is 1. Continue to read data");
            appendNewLine();
            //increase length and read next octet
            currentLength++;
            bs = BitSet.valueOf(new byte[]{input[offset+currentLength-1]});
        }
        appendDebugMsg("  -- FX bit is 0. Finished reading data for this item");
        appendNewLine();
        appendDebugMsg("  -- Size of item is " + currentLength + " octets.");
        appendNewLine();
        for (int i=0; i<currentLength;i++){
            appendItemDebugMsg("Octet " + i, input[offset+i]);
        }
        return currentLength;
    }
}
