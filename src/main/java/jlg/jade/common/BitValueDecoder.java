/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

import java.util.BitSet;

public class BitValueDecoder {
    /**
     * Decode integer information from two bits, based on their arrangement.
     * Possible values are 0,1,2 and 3
     *
     * @param bs            The bitset on which the method operates
     * @param startBitIndex The start bit index (first bit)
     * @param endBitIndex   The end bit index (secomd bit)
     * @return The integer value of the two bits
     */
    public static int decodeFromTwoBits(BitSet bs, int startBitIndex, int endBitIndex) {
        final boolean startBit = bs.get(startBitIndex);
        final boolean endBit = bs.get(endBitIndex);
        if (!endBit && !startBit) {
            return 0;
        }
        if (!endBit && startBit) {
            return 1;
        }
        if (endBit && !startBit) {
            return 2;
        }
        return 3;
    }
}
