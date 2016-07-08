/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.VariableLengthAsterixData;

import java.util.BitSet;

/**
 * Cat048Item170 - Track Status
 * Status of monoradar track (PSR and/or SSR updated).
 */
public class Cat048Item170 extends VariableLengthAsterixData {
    private int sensorMaintainingTrackType;                 // RAD
    private int confirmedTrack;                             // CNF
    private int trackConfidenceLevel;                       // DOU
    private int manoeuvreDetectionInHorizontalSense;        // MAH
    private int climbingDescendingMode;                     // CDM
    private int signalEndOfTrack;                           // TRE
    private int ghostVsTrueTarget;                          // GHO
    private int maintainedWithNeighbourSupport;             // SUP
    private int coordinatePlotType;                         // TCC

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        // decode first part
        BitSet firstPartBits = BitSet.valueOf(new byte[]{input[offset]});

        // decode CNF - bit position 7
        final int CNF_BIT_INDEX = 7;
        if (firstPartBits.get(CNF_BIT_INDEX)) {
            this.confirmedTrack = 1;
        } else {
            this.confirmedTrack = 0;
        }

        appendItemDebugMsg("CNF", this.confirmedTrack);

        // decode RAD - bits 6-5
        decodeRAD(firstPartBits);

        // decode DOU - bit 4
        final int DOU_BIT_INDEX = 4;
        if (firstPartBits.get(DOU_BIT_INDEX)) {
            this.trackConfidenceLevel = 1;
        } else {
            this.trackConfidenceLevel = 0;
        }

        appendItemDebugMsg("DOU", this.trackConfidenceLevel);

        // decode MAH - bit 3
        final int MAH_BIT_INDEX = 3;
        if (firstPartBits.get(MAH_BIT_INDEX)) {
            this.manoeuvreDetectionInHorizontalSense = 1;
        } else {
            this.manoeuvreDetectionInHorizontalSense = 0;
        }

        appendItemDebugMsg("MAH", this.manoeuvreDetectionInHorizontalSense);

        // decode CMD - bits 2-1
        decodeCDM(firstPartBits);

        // decode first extent if present
        if (this.getSizeInBytes() > 1) {
            BitSet firstExtentBits = BitSet.valueOf(new byte[]{input[offset+1]});

            // decode TRE - bit position 7
            final int TRE_BIT_INDEX = 7;
            if(firstExtentBits.get(TRE_BIT_INDEX)){
                this.signalEndOfTrack = 1;
            } else {
                this.signalEndOfTrack = 0;
            }

            appendItemDebugMsg("TRE", this.signalEndOfTrack);

            // decode GHO
            final int GHO_BIT_INDEX = 6;
            if(firstExtentBits.get(GHO_BIT_INDEX)){
                this.ghostVsTrueTarget = 1;
            } else {
                this.ghostVsTrueTarget = 0;
            }

            appendItemDebugMsg("GHO", this.ghostVsTrueTarget);

            // decode SUP
            final int SUP_BIT_INDEX = 5;
            if(firstExtentBits.get(SUP_BIT_INDEX)){
                this.maintainedWithNeighbourSupport = 1;
            } else {
                this.maintainedWithNeighbourSupport = 0;
            }

            appendItemDebugMsg("SUP", this.maintainedWithNeighbourSupport);

            // decode TCC
            final int TCC_BIT_INDEX = 4;
            if(firstExtentBits.get(TCC_BIT_INDEX)){
                this.coordinatePlotType = 1;
            } else {
                this.coordinatePlotType = 0;
            }

            appendItemDebugMsg("TCC", this.coordinatePlotType);
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item170 - Track Status";
    }

    /**
     * @return type of Sensor(s) maintaining Track - RAD
     */
    public int getSensorMaintainingTrackType() {
        return sensorMaintainingTrackType;
    }

    public int getConfirmedTrack() {
        return confirmedTrack;
    }

    public int getTrackConfidenceLevel() {
        return trackConfidenceLevel;
    }

    public int getManoeuvreDetectionInHorizontalSense() {
        return manoeuvreDetectionInHorizontalSense;
    }

    public int getClimbingDescendingMode() {
        return climbingDescendingMode;
    }

    public int getSignalEndOfTrack() {
        return signalEndOfTrack;
    }

    public int getGhostVsTrueTarget() {
        return ghostVsTrueTarget;
    }

    public int getMaintainedWithNeighbourSupport() {
        return maintainedWithNeighbourSupport;
    }

    public int getCoordinatePlotType() {
        return coordinatePlotType;
    }

    private void decodeRAD(BitSet firstPartBits) {
        final int RAD_BIT0_INDEX = 5;
        final int RAD_BIT1_INDEX = 6;
        int RADBit0Value = 0;
        int RADBit1Value = 0;

        if (firstPartBits.get(RAD_BIT0_INDEX)) {
            RADBit0Value = 1;
        }

        if (firstPartBits.get(RAD_BIT1_INDEX)) {
            RADBit1Value = 1;
        }

        this.sensorMaintainingTrackType = RADBit1Value * 2 + RADBit0Value;

        appendItemDebugMsg("RAD", this.sensorMaintainingTrackType);

    }

    private void decodeCDM(BitSet firstPartBits) {
        final int CDM_BIT0_INDEX = 1;
        final int CMD_BIT1_INDEX = 2;
        int CDMBit0Value = 0;
        int CDMBit1Value = 0;

        if (firstPartBits.get(CDM_BIT0_INDEX)) {
            CDMBit0Value = 1;
        }

        if (firstPartBits.get(CMD_BIT1_INDEX)) {
            CDMBit1Value = 1;
        }

        this.climbingDescendingMode = CDMBit1Value * 2 + CDMBit0Value;

        appendItemDebugMsg("CDM", this.climbingDescendingMode);

    }
}
