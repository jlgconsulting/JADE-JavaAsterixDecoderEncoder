/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.VariableLengthAsterixData;

import java.util.BitSet;

/**
 * Cat 062 Item 510 - Composed Track Number
 *
 * @implSpec Extendible data item, comprising a first part of three octets (Master
 * Track Number), followed by three-octet extents (Slave Tracks
 * Numbers)
 */
public class Cat062Item510 extends VariableLengthAsterixData {

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected int setSizeInBytes(byte[] input, int offset) {
        int currentLength = 3;  //first part has 3 octets

        //3 octet sequences => FX bit is at each 3rd octet
        BitSet bs = BitSet.valueOf(new byte[]{input[offset + 2]});

        while (bs.get(0)) {
            appendDebugMsg("FX bit is 1. Continue to read data");
            appendNewLine();
            //increase length and read next octet (by 3 octets)
            currentLength += 3;
            bs = BitSet.valueOf(new byte[]{input[offset + currentLength - 1]});
        }
        appendDebugMsg("FX bit is 0. Finished reading data for this item");
        appendNewLine();
        appendDebugMsg("Size of item is " + currentLength + " octets.");
        appendNewLine();
        for (int i = 0; i < currentLength; i++) {
            appendItemDebugMsg("Octet " + i, input[offset + i]);
        }
        return currentLength;
    }
}
