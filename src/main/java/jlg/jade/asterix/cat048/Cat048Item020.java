/**
 * Created by alexandru on 7/5/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.VariableLengthAsterixData;

import java.util.BitSet;

/**
 * Cat048Item020 - Target Report Descriptor
 * Type and properties of the target report.
 */
public class Cat048Item020 extends VariableLengthAsterixData {
    private int rabValue;
    private int specialPosIdentificationValue;
    private int reportFromRDPValue;
    private int simulatedTargetReportValue;
    private int typValue;
    private int foeFriValue;
    private int militaryIdentificationValue;
    private int militaryEmergencyValue;
    private int xPulsePresentValue;
    private int testTargetValue;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        // parse first octet
        BitSet octetBits = BitSet.valueOf(new byte[]{input[offset]});

        decodeRabValue(octetBits);
        decodeSpiValue(octetBits);
        decodeRdpValue(octetBits);
        decodeSimValue(octetBits);
        decodeTypValue(octetBits);

        // parse extent if present
        if (this.getSizeInBytes() > 1) {

            BitSet extentBits = BitSet.valueOf(new byte[]{input[offset + 1]});

            decodeFoeFriValue(extentBits);
            decodeMiValue(extentBits);
            decodeMeValue(extentBits);
            decodeXppValue(extentBits);
            decodeTstValue(extentBits);
        }
    }

    private void decodeFoeFriValue(BitSet extentBits) {
        final int FOE_FRI_BIT0_INDEX = 1;
        final int FOE_FRI_BIT1_INDEX = 2;
        int foeFriBit0Value = 0;
        int foeFriBit1Value = 0;
        if (extentBits.get(FOE_FRI_BIT0_INDEX)) {
            foeFriBit0Value = 1;
        }
        if (extentBits.get(FOE_FRI_BIT1_INDEX)) {
            foeFriBit1Value = 1;
        }
        this.foeFriValue = foeFriBit1Value * 2 + foeFriBit0Value;
        appendItemDebugMsg("FOE/FRI (bits)", foeFriBit1Value + "" + foeFriBit0Value);
        appendItemDebugMsg(
                "FOE/FRI (decimal) (0=No Mode 4 interrogation,1=Friendly target,2=Unknown target, 3= No reply)",
                this.foeFriValue);
    }

    private void decodeMiValue(BitSet extentBits) {
        final int MI_BIT_VALUE = 3;
        if (extentBits.get(MI_BIT_VALUE)) {
            this.militaryIdentificationValue = 1;
        } else {
            this.militaryIdentificationValue = 0;
        }
        appendItemDebugMsg(
                "MI (0=No military identification,1=Military identification)",
                this.militaryIdentificationValue);
    }

    private void decodeMeValue(BitSet extentBits) {
        final int ME_BIT_VALUE = 4;
        if (extentBits.get(ME_BIT_VALUE)) {
            this.militaryEmergencyValue = 1;
        } else {
            this.militaryEmergencyValue = 0;
        }
        appendItemDebugMsg(
                "ME (0=No military emergency,1=Military emergency)",
                this.militaryEmergencyValue);
    }

    private void decodeXppValue(BitSet extentBits) {
        final int XPP_BIT_VALUE = 5;
        if (extentBits.get(XPP_BIT_VALUE)) {
            this.xPulsePresentValue = 1;
        } else {
            this.xPulsePresentValue = 0;
        }
        appendItemDebugMsg(
                "MI (0=No X-Pulse present,1=X-Pulse present)",
                this.xPulsePresentValue);
    }

    private void decodeTstValue(BitSet extentBits) {
        final int TST_BIT_VALUE = 7;
        if (extentBits.get(TST_BIT_VALUE)) {
            this.testTargetValue = 1;
        } else {
            this.testTargetValue = 0;
        }
        appendItemDebugMsg(
                "TST (0=Real target report,1=Test target report)",
                this.testTargetValue);
    }

    private void decodeRabValue(BitSet fixedPartBits) {
        final int RAB_BIT_VALUE = 1;
        if (fixedPartBits.get(RAB_BIT_VALUE)) {
            this.rabValue = 1;
        } else {
            this.rabValue = 0;
        }
        appendItemDebugMsg(
                "RAB (0=Report from aircraft transponder,1=Report from field monitor (fixed transponder))",
                this.rabValue);
    }

    private void decodeSpiValue(BitSet fixedPartBits) {
        final int SPI_BIT_VALUE = 2;
        if (fixedPartBits.get(SPI_BIT_VALUE)) {
            this.specialPosIdentificationValue = 1;
        } else {
            this.specialPosIdentificationValue = 0;
        }
        appendItemDebugMsg(
                "RAB (0=Absence of SPI,1=Special Position Identification",
                this.specialPosIdentificationValue);
    }

    private void decodeRdpValue(BitSet fixedPartBits) {
        final int RDP_BIT_INDEX = 3;
        if (fixedPartBits.get(RDP_BIT_INDEX)) {
            this.reportFromRDPValue = 1;
        } else {
            this.reportFromRDPValue = 0;
        }
        appendItemDebugMsg("RDP (0=Report from RDP Chain 1,1=Report from RDP Chain 2)",
                           this.reportFromRDPValue);
    }

    private void decodeSimValue(BitSet fixedPartBits) {
        final int SIM_BIT_INDEX = 4;
        if (fixedPartBits.get(SIM_BIT_INDEX)) {
            this.simulatedTargetReportValue = 1;
        } else {
            this.simulatedTargetReportValue = 0;
        }
        appendItemDebugMsg("SIM (0=Actual target report,1=Simulated target report)",
                           this.simulatedTargetReportValue);
    }

    private void decodeTypValue(BitSet fixedPartBits) {
        final int TYP_BIT0_INDEX = 5;
        final int TYP_BIT1_INDEX = 6;
        final int SRC_BIT2_INDEX = 7;
        int typBit0Value = 0;
        int typBit1Value = 0;
        int typBit2Value = 0;
        if (fixedPartBits.get(TYP_BIT0_INDEX)) {
            typBit0Value = 1;
        }
        if (fixedPartBits.get(TYP_BIT1_INDEX)) {
            typBit1Value = 1;
        }
        if (fixedPartBits.get(SRC_BIT2_INDEX)) {
            typBit2Value = 1;
        }
        this.typValue = typBit2Value * 4 + typBit1Value * 2 + typBit0Value;
        appendItemDebugMsg("TYP (bits)", typBit2Value + "" + typBit1Value + "" + typBit0Value);
        appendItemDebugMsg("TYP (decimal)", this.typValue);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item020 - Target Report Descriptor";
    }

    /**
     * @return = 000 No detection
     * = 001 Single PSR detection
     * = 010 Single SSR detection
     * = 011 SSR + PSR detection
     * = 100 Single ModeS All-Call
     * = 101 Single ModeS Roll-Call
     * = 110 ModeS All-Call + PSR
     * = 111 ModeS Roll-Call +PSR
     */
    public int getTypValue() {
        return typValue;
    }

    /**
     * @return = 0 Report from RDP Chain 1
     * = 1 Report from RDP Chain 2
     */
    public int getReportFromRDPValue() {
        return reportFromRDPValue;
    }

    /**
     * @return = 0 Actual target report
     * = 1 Simulated target report
     */
    public int getSimulatedTargetReportValue() {
        return simulatedTargetReportValue;
    }

    /**
     * @return = 0 Absence of SPI
     * = 1 Special Position Identification
     */
    public int getSpecialPosIdentificationValue() {
        return specialPosIdentificationValue;
    }

    /**
     * @return = 0 Report from aircraft transponder
     * = 1 Report from field monitor (fixed transponder)
     */
    public int getRabValue() {
        return rabValue;
    }

    /**
     * @return = 00 No Mode 4 interrogation
     * = 01 Friendly target
     * = 10 Unknown target
     * = 11 No reply
     */
    public int getFoeFriValue() {
        return foeFriValue;
    }

    /**
     * @return = 0 No military identification
     * = 1 Military identification
     */
    public int getMilitaryIdentificationValue() {
        return militaryIdentificationValue;
    }

    /**
     * @return = 0 No military emergency
     * = 1 Military emergency
     */
    public int getMilitaryEmergencyValue() {
        return militaryEmergencyValue;
    }

    /**
     * @return = 0 No X-Pulse present
     * = 1 X-Pulse present
     */
    public int getxPulsePresentValue() {
        return xPulsePresentValue;
    }

    /**
     * @return = 0 Real target report
     * = 1 Test target report
     */
    public int getTestTargetValue() {
        return testTargetValue;
    }
}
