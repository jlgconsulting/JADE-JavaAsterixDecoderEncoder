/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.VariableLengthAsterixData;

import java.util.BitSet;

/**
 * Cat 062 Item 080 - Track Status - Mandatory
 * Variable length data item comprising a first part of one Octet,
 * followed by 1-Octet extents as necessary.
 * @implNote Extents 2 and 3 are not currently implemented. Extent 1 is partially implemented
 */
public class Cat062Item080 extends VariableLengthAsterixData {
    private int cfnValue;
    private int srcValue;
    private int mrhValue;
    private int spiValue;
    private int monValue;
    private int fpcValue;
    private int simValue;
    private int tseValue;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        //parse first octet
        BitSet octetBits = BitSet.valueOf(new byte[]{input[offset]});

        decodeCfnValue(octetBits);
        decodeSrcValue(octetBits);
        decodeMrhValue(octetBits);
        decodeSpiValue(octetBits);
        decodeMonValue(octetBits);

        if (this.sizeInBytes >= 2) {
            //parse first extent
            octetBits = BitSet.valueOf(new byte[]{input[offset + 1]});

            decodeFpcValue(octetBits);
            decodeSimValue(octetBits);
            decodeTseValue(octetBits);
        }

        /**
         * @implNote Extents 2 and 3 are not currently implemented. Extent 1 is partially implemented
         * @implNote Extents 2 and 3 are not currently implemented. Extent 1 is partially implemented
         */
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item080 - Track Status";
    }

    /**
     * Get the confirmed track value
     * @return
     * 0 - confirmed
     * 1 - tentative
     */
    public int getCfnValue() {
        return cfnValue;
    }

    public void setCfnValue(int cfnValue) {
        this.cfnValue = cfnValue;
    }

    /**
     * Get the source of calculated altitude for I062/130
     * @return
     * 0 - no source
     * 1 - GNSS
     * 2 - 3D radar
     * 3 - triangulation
     * 4 - height from coverage
     * 5 - speed look-up table
     * 6 - default height
     * 7 - multilateration
     */
    public int getSrcValue() {
        return srcValue;
    }

    public void setSrcValue(int srcValue) {
        this.srcValue = srcValue;
    }

    /**
     * Get the most reliable height value
     * @return
     * 0 - barometric altitude more reliable
     * 1 - geometric altitude more reliable
     */
    public int getMrhValue() {
        return mrhValue;
    }

    public void setMrhValue(int mrhValue) {
        this.mrhValue = mrhValue;
    }

    /**
     * Get the presence of SPI
     * @return
     * 0 - default value
     * 1 - SPI present in last report
     */
    public int getSpiValue() {
        return spiValue;
    }

    public void setSpiValue(int spiValue) {
        this.spiValue = spiValue;
    }

    /**
     * Get the sensor value
     * @return
     * 0 - multisensor track
     * 1 - monosensor track
     */
    public int getMonValue() {
        return monValue;
    }

    public void setMonValue(int monValue) {
        this.monValue = monValue;
    }

    /**
     * Get the flight plan correlation value
     * @return
     * 0 - not correlated with plan
     * 1 - correlated with plan
     */
    public int getFpcValue() {
        return fpcValue;
    }

    public void setFpcValue(int fpcValue) {
        this.fpcValue = fpcValue;
    }

    /**
     * Get track simulation value
     * @return
     * 0 - actual track
     * 1 - simulated track
     */
    public int getSimValue() {
        return simValue;
    }

    public void setSimValue(int simValue) {
        this.simValue = simValue;
    }

    /**
     * Get track signal end
     * @return
     * 0 - default value
     * 1 - last message transmitted to the user for the track
     */
    public int getTseValue() {
        return tseValue;
    }

    public void setTseValue(int tseValue) {
        this.tseValue = tseValue;
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

    private void decodeFpcValue(BitSet firstExtentBits){
        final int FPC_BIT_INDEX = 4;
        if (firstExtentBits.get(FPC_BIT_INDEX)) {
            this.fpcValue = 1;
        } else {
            this.fpcValue = 0;
        }
        appendItemDebugMsg("FPC (0=Not correlated,1=Correlated with plan)", this.fpcValue);
    }

    private void decodeSimValue(BitSet firstExtentBits){
        final int SIM_BIT_INDEX = 7;
        if (firstExtentBits.get(SIM_BIT_INDEX)) {
            this.simValue = 1;
        } else {
            this.simValue = 0;
        }
        appendItemDebugMsg("SIM (0=Actual track,1=Simulated track)", this.fpcValue);
    }

    private void decodeTseValue(BitSet firstExtentBits) {
        final int TSE_BIT_INDEX = 6;
        if(firstExtentBits.get(TSE_BIT_INDEX)) {
            this.tseValue = 1;
        } else {
            this.tseValue = 0;
        }
        appendItemDebugMsg("TSE (0=Default value, 1=Last message transmitted to the user for the track)", this.tseValue);
    }
}
