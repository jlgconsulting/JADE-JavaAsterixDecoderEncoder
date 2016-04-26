/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.VariableLengthAsterixItem;

import java.util.BitSet;

/**
 * Cat 062 Item 080 - Track Status - Mandatory
 * Variable length data item comprising a first part of one Octet,
 * followed by 1-Octet extents as necessary.
 */
public class Cat062Item080 extends VariableLengthAsterixItem {
    private int cfnValue;
    private int srcValue;
    private int mrhValue;
    private int spiValue;
    private int monValue;

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {
        //parse first octet
        BitSet octetBits = BitSet.valueOf(new byte[]{input[offset]});

        decodeCfnValue(octetBits);
        decodeSrcValue(octetBits);
        decodeMrhValue(octetBits);
        decodeSpiValue(octetBits);
        decodeMonValue(octetBits);

        if (this.sizeInBytes >= 2) {
            octetBits = BitSet.valueOf(new byte[]{input[offset + 1]});
            //parse first extent
        }

        if (this.sizeInBytes >= 3) {
            octetBits = BitSet.valueOf(new byte[]{input[offset + 2]});
            //parse second extent
        }

        if (this.sizeInBytes >= 3) {
            octetBits = BitSet.valueOf(new byte[]{input[offset + 3]});
            //parse third extent
        }

        return offset + this.sizeInBytes;
    }

    private void decodeCfnValue(BitSet fixedPartBits) {
        final int CFN_BIT_INDEX = 1;
        if (fixedPartBits.get(CFN_BIT_INDEX)) {
            this.cfnValue = 1;
        } else {
            this.cfnValue = 0;
        }
        appendItemDebugMsg("CFN (0=Confirmed,1=Tentative)", this.cfnValue);
    }

    @Override
    protected boolean validate() {
        return false;
    }

    public int getCfnValue() {
        return cfnValue;
    }

    public int getSrcValue() {
        return srcValue;
    }

    public int getMrhValue() {
        return mrhValue;
    }

    public int getSpiValue() {
        return spiValue;
    }

    public int getMonValue() {
        return monValue;
    }

    private void decodeSrcValue(BitSet fixedPartBits) {
        final int SRC_BIT0_INDEX = 2;
        final int SRC_BIT1_INDEX = 3;
        final int SRC_BIT2_INDEX = 4;
        int srcBit0Value = 0;
        int srcBit1Value = 0;
        int srcBit2Value = 0;
        if (fixedPartBits.get(SRC_BIT0_INDEX)) {
            srcBit0Value = 1;
        }
        if (fixedPartBits.get(SRC_BIT1_INDEX)) {
            srcBit1Value = 1;
        }
        if (fixedPartBits.get(SRC_BIT2_INDEX)) {
            srcBit2Value = 1;
        }
        this.srcValue = srcBit2Value * 4 + srcBit1Value * 2 + srcBit0Value;
        appendItemDebugMsg("SRC (bits)", srcBit2Value + "" + srcBit1Value + "" + srcBit0Value);
        appendItemDebugMsg("SRC (decimal)", this.srcValue);
    }

    private void decodeMrhValue(BitSet fixedPartBits) {
        final int MRH_BIT_INDEX = 5;
        if (fixedPartBits.get(MRH_BIT_INDEX)) {
            this.mrhValue = 1;
        } else {
            this.mrhValue = 0;
        }
        appendItemDebugMsg("MRH (0=Barometric alt reliable,1=Geometric alt reliable)", this.mrhValue);
    }

    private void decodeSpiValue(BitSet fixedPartBits) {
        final int SPI_BIT_INDEX = 6;
        if (fixedPartBits.get(SPI_BIT_INDEX)) {
            this.spiValue = 1;
        } else {
            this.spiValue = 0;
        }
        appendItemDebugMsg("SPI (0=Default,1=SPI present in last rep)", this.spiValue);
    }

    private void decodeMonValue(BitSet fixedPartBits) {
        final int MON_BIT_INDEX = 7;
        if (fixedPartBits.get(MON_BIT_INDEX)) {
            this.monValue = 1;
        } else {
            this.monValue = 0;
        }
        appendItemDebugMsg("MON (0=Multisensor,1=Monosensor)", this.monValue);
    }
}
