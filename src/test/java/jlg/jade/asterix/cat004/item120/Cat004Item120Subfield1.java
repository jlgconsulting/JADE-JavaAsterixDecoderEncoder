/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.asterix.cat004.item120;

import jlg.jade.asterix.VariableLengthAsterixData;

import java.util.BitSet;

/**
 * Cat004 - Item120 - Subfield 1 - Conflict nature
 * Nature of the conflict expressed by a set of properties
 */
public class Cat004Item120Subfield1 extends VariableLengthAsterixData {
    private int MAS;
    private int CAS;
    private int FLD;
    private int FVD;
    private int typeOfInfringement;
    private int crossingTest;
    private int divergenceTest;
    private int RRC;
    private int RTC;
    private int MRVA;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        //we start from first byte
        BitSet currentByte = BitSet.valueOf(new byte[]{input[offset]});
        decodeFirstOctet(currentByte);

        //if FX bit is 1, we move to second extent
        if (currentByte.get(0)) {
            currentByte = BitSet.valueOf(new byte[]{input[offset + 1]});
        }
        decodeSecondOctet(currentByte);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item120Subfield1 - Conflict Nature";
    }

    /**
     * Conflict location in military airspace
     *
     * @return 0 if conflict not predicted to occur in military airspace, 1 if  conflict
     * predicted to occur in military airspace
     */
    public int getMAS() {
        return MAS;
    }

    /**
     * Conflict location in civil airspace
     *
     * @return 0 if conflict not predicted to occur in civil airspace, 1 if conflict predicted to
     * occur in civil airspace
     */
    public int getCAS() {
        return CAS;
    }

    /**
     * Fast lateral divergence
     *
     * @return 0 if aircraft are not fast diverging laterally at current
     * time, 1 if aircraft are fast diverging laterally at current time
     */
    public int getFLD() {
        return FLD;
    }

    /**
     * Fast vertical divergence
     *
     * @return 0 if aircraft are not fast diverging vertically at current
     * time, 1 if aircraft are fast diverging vertically at current time
     */
    public int getFVD() {
        return FVD;
    }

    /**
     * @return 0 if minor separation infringement, 1 if major separation infringement
     */
    public int getTypeOfInfringement() {
        return typeOfInfringement;
    }

    /**
     * @return 0 if aircraft have not crossed at starting time of
     * conflict, 1 if aircraft have crossed at starting time of conflict
     */
    public int getCrossingTest() {
        return crossingTest;
    }

    /**
     * @return 0 if aircraft are not diverging at starting time of
     * conflict, 1 if aircraft are diverging at starting time of conflict
     */
    public int getDivergenceTest() {
        return divergenceTest;
    }

    /**
     * Runway/Runway crossing in RIMCAS
     *
     * @return 0 is Default, 1 is Runway/Runway Crossing
     */
    public int getRRC() {
        return RRC;
    }

    /**
     * Runway/Taxiway Crossing in RIMCAS
     *
     * @return 0 is Default, 1 is Runway/Taxiway Crossing
     */
    public int getRTC() {
        return RTC;
    }

    /**
     * @return 0 is Default, 1 Msg Type 4 (MSAW) indicates MRVA
     */
    public int getMRVA() {
        return MRVA;
    }


    private void decodeSecondOctet(BitSet currentByte) {
        if (currentByte.get(7)) {
            this.RRC = 1;
        }
        appendItemDebugMsg("RRC", this.RRC);

        if (currentByte.get(6)) {
            this.RTC = 1;
        }
        appendItemDebugMsg("RTC", this.RTC);

        if (currentByte.get(5)) {
            this.MRVA = 1;
        }
        appendItemDebugMsg("MRVA", this.MRVA);
    }

    private void decodeFirstOctet(BitSet currentByte) {
        if (currentByte.get(7)) {
            this.MAS = 1;
        }
        appendItemDebugMsg("MAS", this.MAS);

        if (currentByte.get(6)) {
            this.CAS = 1;
        }
        appendItemDebugMsg("CAS", this.CAS);

        if (currentByte.get(5)) {
            this.FLD = 1;
        }
        appendItemDebugMsg("FLD", this.FLD);

        if (currentByte.get(4)) {
            this.FVD = 1;
        }
        appendItemDebugMsg("FVD", this.FVD);

        if (currentByte.get(3)) {
            this.typeOfInfringement = 1;
        }
        appendItemDebugMsg("Type", this.typeOfInfringement);

        if (currentByte.get(2)) {
            this.crossingTest = 1;
        }
        appendItemDebugMsg("Cross", this.crossingTest);

        if (currentByte.get(1)) {
            this.divergenceTest = 1;
        }
        appendItemDebugMsg("Div", this.divergenceTest);
    }
}
