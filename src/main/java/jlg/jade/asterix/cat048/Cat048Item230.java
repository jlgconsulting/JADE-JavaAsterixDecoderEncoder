/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.util.BitSet;

/**
 * Cat048Item230 - Communications/ACAS Capability and Flight Status
 * Communications capability of the transponder, capability of the onboard
 * ACAS equipment and flight status.
 */
public class Cat048Item230 extends FixedLengthAsterixData {
    private int communicationsCapability;           // COM
    private int flightStatus;                       // STAT
    private int transponderCapability;              // SI
    private int modeSSpecificServiceCapability;     // MSSC
    private int altitudeReportingCapability;        // ARC
    private int aircraftIdentificationCapability;   // AIC
    private int BDS10Bit16;
    private int BDS10Bit37;
    private int BDS10Bit38;
    private int BDS10Bit39;
    private int BDS10Bit40;
    private TCASVersions determinedTCASVersion;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet firstByteBits = BitSet.valueOf(new byte[]{input[offset]});

        // COM
        decodeCOM(firstByteBits);

        // STAT
        decodeSTAT(firstByteBits);

        // SI
        final int SI_BIT_INDEX = 1;
        if (firstByteBits.get(SI_BIT_INDEX)) {
            this.transponderCapability = 1;
        } else {
            this.transponderCapability = 0;
        }

        appendItemDebugMsg("SI (SI/II Transponder Capability)", this.transponderCapability);

        // decode second byte information
        BitSet secondByteBits = BitSet.valueOf(new byte[]{input[offset + 1]});

        // MSSC
        final int MSSC_BIT_INDEX = 7;
        if (secondByteBits.get(MSSC_BIT_INDEX)) {
            this.modeSSpecificServiceCapability = 1;
        } else {
            this.modeSSpecificServiceCapability = 0;
        }

        appendItemDebugMsg("MSSC (Mode-S Specific Service Capability)",
                           this.modeSSpecificServiceCapability);

        // ARC
        final int ARC_BIT_INDEX = 6;
        if (secondByteBits.get(ARC_BIT_INDEX)) {
            this.altitudeReportingCapability = 1;
        } else {
            this.altitudeReportingCapability = 0;
        }

        appendItemDebugMsg("ARC (Altitude reporting capability)", this.altitudeReportingCapability);

        // AIC
        final int AIC_BIT_INDEX = 5;
        if (secondByteBits.get(AIC_BIT_INDEX)) {
            this.aircraftIdentificationCapability = 1;
        } else {
            this.aircraftIdentificationCapability = 0;
        }

        appendItemDebugMsg("AIC (Aircraft identification capability)",
                           this.aircraftIdentificationCapability);

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

        // determine TCAS version
        // according to the old implementation of DAQ the TCAS version is given by
        // the BDS Register 1,0 bits 71 and 70 ( equivalent to Asterix Cat048Item230
        // BDS Register 1,0 Bit 37 and BDS Register 1,0 Bit38
        int TCASVersionBitValue = this.BDS10Bit37 * 2 + this.BDS10Bit38;
        switch(TCASVersionBitValue) {
            case 0:
                this.determinedTCASVersion = TCASVersions.VERSION_604;
                break;
            case 1:
                this.determinedTCASVersion = TCASVersions.VERSION_70;
                break;
            case 2:
                this.determinedTCASVersion = TCASVersions.VERSION_71;
                break;
            default:
                this.determinedTCASVersion = TCASVersions.FUTURE_VERSION;
                break;
            }

    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item230 - Communications/ACAS Capability and Flight Status";
    }

    /**
     * @return Communications capability of the transponder
     * 0 = No communications capability (surveillance only)
     * 1 = Comm. A and Comm. B capability
     * 2 = Comm. A, Comm. B and Uplink ELM
     * 3 = Comm. A, Comm. B, Uplink ELM and Downlink ELM
     * 4 = Level 5 Transponder capability
     * 5 to 7 Not assigned
     */
    public int getCommunicationsCapability() {
        return communicationsCapability;
    }

    /**
     * @return Flight Status
     * 0 = No alert, no SPI, aircraft airborne
     * 1 = No alert, no SPI, aircraft on ground
     * 2 = Alert, no SPI, aircraft airborne
     * 3 = Alert, no SPI, aircraft on ground
     * 4 = Alert, SPI, aircraft airborne or on ground
     * 5 = No alert, SPI, aircraft airborne or on ground
     * 6 - 7 Not assigned
     */
    public int getFlightStatus() {
        return flightStatus;
    }

    /**
     * @return SI/II Transponder Capability
     * 0 = SI-Code Capable
     * 1 = II-Code Capable
     */
    public int getTransponderCapability() {
        return transponderCapability;
    }

    /**
     * @return Mode-S Specific Service Capability
     * 0 = No
     * 1 = Yes
     */
    public int getModeSSpecificServiceCapability() {
        return modeSSpecificServiceCapability;
    }

    /**
     * @return Altitude reporting capability
     * 0 = 100 ft resolution
     * 1 = 25 ft resolution
     */
    public int getAltitudeReportingCapability() {
        return altitudeReportingCapability;
    }

    /**
     * @return Aircraft identification capability
     * 0 = No
     * 1 = Yes
     */
    public int getAircraftIdentificationCapability() {
        return aircraftIdentificationCapability;
    }

    private void decodeCOM(BitSet firstByteBits) {
        final int COM_BIT0_INDEX = 5;
        final int COM_BIT1_INDEX = 6;
        final int COM_BIT2_INDEX = 7;

        int ComBit0Value = 0;
        int ComBit1Value = 0;
        int ComBit2Value = 0;

        if (firstByteBits.get(COM_BIT0_INDEX)) {
            ComBit0Value = 1;
        }

        if (firstByteBits.get(COM_BIT1_INDEX)) {
            ComBit1Value = 1;
        }

        if (firstByteBits.get(COM_BIT2_INDEX)) {
            ComBit2Value = 1;
        }

        this.communicationsCapability = ComBit2Value * 4 + ComBit1Value * 2 + ComBit0Value;
        appendItemDebugMsg("COM (Communications capability of the transponder)",
                           this.communicationsCapability);
    }

    private void decodeSTAT(BitSet firstByteBits) {
        final int STAT_BIT0_INDEX = 2;
        final int STAT_BIT1_INDEX = 3;
        final int STAT_BIT2_INDEX = 4;

        int StatBit0Value = 0;
        int StatBit1Value = 0;
        int StatBit2Value = 0;

        if (firstByteBits.get(STAT_BIT0_INDEX)) {
            StatBit0Value = 1;
        }

        if (firstByteBits.get(STAT_BIT1_INDEX)) {
            StatBit1Value = 1;
        }

        if (firstByteBits.get(STAT_BIT2_INDEX)) {
            StatBit2Value = 1;
        }

        this.flightStatus = StatBit2Value * 4 + StatBit1Value * 2 + StatBit0Value;

        appendItemDebugMsg("STAT (Flight Status)", this.flightStatus);

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

    public TCASVersions getDeterminedTCASVersion() {
        return determinedTCASVersion;
    }
}
