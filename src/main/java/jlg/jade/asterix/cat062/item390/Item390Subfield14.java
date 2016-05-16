/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.util.BitSet;

/**
 * Item 390 subfield 14 - Stand Status
 */
public class Item390Subfield14 extends FixedLengthAsterixData {
    private int standEmptiness;
    private int standAvailability;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});
        this.standEmptiness = decodeFromTwoBits(bs, 6, 7);
        this.standAvailability = decodeFromTwoBits(bs, 4, 5);

        appendItemDebugMsg("EMP (0=Empty,1=Occupied,2=Unk,3=Invalid)", this.standEmptiness);
        appendItemDebugMsg("AVL (0=Available,1=Not available,2=Unk,3=Invalid)", this.standAvailability);
    }

    /**
     * @return The stand emptiness value
     * - 0 means Empty
     * - 1 means Occupied
     * - 2 means Unknown
     * - 3 means Invalid
     */
    public int getStandEmptiness() {
        return standEmptiness;
    }

    /**
     * @return The stand availability value
     * - 0 means Available
     * - 1 means Not available
     * - 2 means Unknown
     * - 3 means Invalid
     */
    public int getStandAvailability() {
        return standAvailability;
    }

    private int decodeFromTwoBits(BitSet bs, int startBitIndex, int endBitIndex) {
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
