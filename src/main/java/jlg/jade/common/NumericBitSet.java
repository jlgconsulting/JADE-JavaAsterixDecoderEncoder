/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.common;

import java.util.BitSet;

public class NumericBitSet {

    /**
     * Transforms a byte into an array of bits with integer values (0 and 1). The bit order is
     * from left to right: 7 6 5 4 3 2 1 0
     */
    public static int[] transform(byte b) {
        int[] bits = new int[8];
        BitSet bs = BitSet.valueOf(new byte[]{b});

        for(int i=0;i<8;i++){
            if(bs.get(i)){
                bits[i] = 1;
            }
            else{
                bits[i] = 0;
            }
        }

        return bits;
    }
}
