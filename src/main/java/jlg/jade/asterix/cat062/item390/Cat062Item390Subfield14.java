/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.BitValueDecoder;

import java.util.BitSet;

/**
 * Item 390 subfield 14 - Stand Status
 */
public class Cat062Item390Subfield14 extends FixedLengthAsterixData {
    private int standEmptiness;
    private int standAvailability;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});
        this.standEmptiness = BitValueDecoder.decodeFromTwoBits(bs, 6, 7);
        this.standAvailability = BitValueDecoder.decodeFromTwoBits(bs, 4, 5);

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
     * Set the stand emptiness value
     * - 0 means Empty
     * - 1 means Occupied
     * - 2 means Unknown
     * - 3 means Invalid
     * @param standEmptiness
     */
    public void setStandEmptiness(int standEmptiness) {
        this.standEmptiness = standEmptiness;
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

    /**
     * Set the stand availability value
     * - 0 means Available
     * - 1 means Not available
     * - 2 means Unknown
     * - 3 means Invalid
     * @param standAvailability
     */
    public void setStandAvailability(int standAvailability) {
        this.standAvailability = standAvailability;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item390Subfield14 - Stand Status";
    }
}
