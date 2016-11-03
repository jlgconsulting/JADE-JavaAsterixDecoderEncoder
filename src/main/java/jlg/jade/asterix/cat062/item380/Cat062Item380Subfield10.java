/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.util.BitSet;

/**
 * Item 380 Subfield 10 - Communications/ACAS capability and flight status
 * reported by Mode S
 */
public class Cat062Item380Subfield10 extends FixedLengthAsterixData {
    private int BDS10Bit16;
    private int BDS10Bit37;
    private int BDS10Bit38;
    private int BDS10Bit39;
    private int BDS10Bit40;
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        // decode second byte information
        BitSet secondByteBits = BitSet.valueOf(new byte[]{input[offset + 1]});

        // BDS Register 1,0 bits 16 / 37-40
        final int BDS10_BIT16_INDEX = 4;
        final int BDS10_BIT37_INDEX = 3;
        final int BDS10_BIT38_INDEX = 2;
        final int BDS10_BIT39_INDEX = 1;
        final int BDS10_BIT40_INDEX = 0;

        if (secondByteBits.get(BDS10_BIT16_INDEX)) {
            this.BDS10Bit16 = 1;
        }

        appendItemDebugMsg("BDS 1,0 bit 16", this.BDS10Bit16);

        if (secondByteBits.get(BDS10_BIT37_INDEX)) {
            this.BDS10Bit37 = 1;
        }

        appendItemDebugMsg("BDS 1,0 bit 37", this.BDS10Bit37);

        if (secondByteBits.get(BDS10_BIT38_INDEX)) {
            this.BDS10Bit38 = 1;
        }

        appendItemDebugMsg("BDS 1,0 bit 38", this.BDS10Bit38);

        if (secondByteBits.get(BDS10_BIT39_INDEX)) {
            this.BDS10Bit39 = 1;
        }

        appendItemDebugMsg("BDS 1,0 bit 39", this.BDS10Bit39);

        if (secondByteBits.get(BDS10_BIT40_INDEX)) {
            this.BDS10Bit40 = 1;
        }

        appendItemDebugMsg("BDS 1,0 bit 40", this.BDS10Bit40);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item380Subfield10 - Communications/ACAS capability";
    }

    public int getBDS10Bit16() {
        return BDS10Bit16;
    }

    public int getBDS10Bit37() {
        return BDS10Bit37;
    }

    public int getBDS10Bit38() {
        return BDS10Bit38;
    }

    public int getBDS10Bit39() {
        return BDS10Bit39;
    }

    public int getBDS10Bit40() {
        return BDS10Bit40;
    }
}
