/**
 * Created by alexandru on 7/21/16.
 */
package jlg.jade.asterix;

import java.util.BitSet;
import java.util.HashMap;

public class AuralCalculator {

    private static AuralCalculator auralCalculatorInstance = null;

    private static String auralCode;

    static HashMap<String, String> Auralv604RepresentationToCodeDictionary;

    /**
     * TODO: Move the implementation of the 2 sets of aurals ( for 6.04 and 7.0 / 7.1 ) to different classes
     */
    protected AuralCalculator() {

        Auralv604RepresentationToCodeDictionary = new HashMap<String, String>();

        // preventive aural is always 'MVS-MVS' in v604
        // adding corrective aural values
        Auralv604RepresentationToCodeDictionary.put("00000000000", "No RA");

        Auralv604RepresentationToCodeDictionary.put("00000000001", "RC-RC");
        Auralv604RepresentationToCodeDictionary.put("00000000010", "RC-RC");
        Auralv604RepresentationToCodeDictionary.put("00000000100", "RC-RC");
        Auralv604RepresentationToCodeDictionary.put("00000001000", "RC-RC");
        Auralv604RepresentationToCodeDictionary
                .put("00000010000", "DDD, or DXD-DXD, or ID-ID, or DDN-DDN");
        Auralv604RepresentationToCodeDictionary.put("00000100000", "RD-RD");
        Auralv604RepresentationToCodeDictionary.put("00001000000", "RD-RD");
        Auralv604RepresentationToCodeDictionary.put("00010000000", "RD-RD");
        Auralv604RepresentationToCodeDictionary.put("00100000000", "RD-RD");
        Auralv604RepresentationToCodeDictionary
                .put("01000000000", "CCC, or CXC-CXC, or IC-IC, or CCN-CCN");

        // TODO: we could ignore the MTI ( leading bit ) because the aurals are the same as when MTI = 0
        Auralv604RepresentationToCodeDictionary.put("10000000001", "RC-RC");
        Auralv604RepresentationToCodeDictionary.put("10000000010", "RC-RC");
        Auralv604RepresentationToCodeDictionary.put("10000000100", "RC-RC");
        Auralv604RepresentationToCodeDictionary.put("10000001000", "RC-RC");
        Auralv604RepresentationToCodeDictionary
                .put("10000010000", "DDD, or DXD-DXD, or ID-ID, or DDN-DDN");
        Auralv604RepresentationToCodeDictionary.put("10000100000", "RD-RD");
        Auralv604RepresentationToCodeDictionary.put("10001000000", "RD-RD");
        Auralv604RepresentationToCodeDictionary.put("10010000000", "RD-RD");
        Auralv604RepresentationToCodeDictionary.put("10100000000", "RD-RD");
        Auralv604RepresentationToCodeDictionary
                .put("11000000000", "CCC, or CXC-CXC, or IC-IC, or CCN-CCN");
    }

    public static AuralCalculator getInstance() {
        if (auralCalculatorInstance == null) {
            auralCalculatorInstance = new AuralCalculator();
        }

        return auralCalculatorInstance;
    }

    public static HashMap<String, String> getAuralv604RepresentationToCodeDictionary() {
        return Auralv604RepresentationToCodeDictionary;
    }

    /**
     * This method determines the aural code
     *
     * @param input   represents the item260 bits
     * @param version represents the TCAS version
     * @return the aural code
     */
    public static String getAuralCode(byte[] input, TCASVersion version) {
        // transform the input into bitset to get the required bits ( ARA41 - ARA50 and MTI )
        BitSet acasInputBits = BitSet.valueOf(input);

        switch (version) {
            case VERSION_604:
                auralCode = getVersion604AuralCode(acasInputBits);
                break;
        }

        return auralCode;
    }

    /**
     * This method calculates the auralCode code based on the numeric value of the following bits:
     * MTI / MTE + ARA[41-50]
     * Reference document:
     *
     * @param acasInputBits represents the input bits for category 48 item 260, which by default parses
     *                      each octet LEFT to RIGHT and each bit in it RIGHT to LEFT;
     * @return the auralCode code
     */
    private static String getVersion604AuralCode(BitSet acasInputBits) {
        // TODO: Should we process the bitset in order to have the bit indexes like in the Cat048Item260 specification document?
        // MTI / MTE bit index and value
        final int MTI_BIT_INDEX = 28;
        int MTIBitValue = 0;

        // ARA bits indexes
        final int ARA_BIT41_INDEX = 15;
        final int ARA_BIT42_INDEX = 14;
        final int ARA_BIT43_INDEX = 13;
        final int ARA_BIT44_INDEX = 12;
        final int ARA_BIT45_INDEX = 11;
        final int ARA_BIT46_INDEX = 10;
        final int ARA_BIT47_INDEX = 9;
        final int ARA_BIT48_INDEX = 8;
        final int ARA_BIT49_INDEX = 23;
        final int ARA_BIT50_INDEX = 22;

        // initialize ARA bits to 0
        int ARABit41Value = 0;
        int ARABit42Value = 0;
        int ARABit43Value = 0;
        int ARABit44Value = 0;
        int ARABit45Value = 0;
        int ARABit46Value = 0;
        int ARABit47Value = 0;
        int ARABit48Value = 0;
        int ARABit49Value = 0;
        int ARABit50Value = 0;

        // TODO: find a better solution to check these bits
        // determine the value of each bit
        if (acasInputBits.get(MTI_BIT_INDEX)) {
            MTIBitValue = 1;
        }

        if (acasInputBits.get(ARA_BIT41_INDEX)) {
            ARABit41Value = 1;
        }

        if (acasInputBits.get(ARA_BIT42_INDEX)) {
            ARABit42Value = 1;
        }

        if (acasInputBits.get(ARA_BIT43_INDEX)) {
            ARABit43Value = 1;
        }

        if (acasInputBits.get(ARA_BIT44_INDEX)) {
            ARABit44Value = 1;
        }

        if (acasInputBits.get(ARA_BIT45_INDEX)) {
            ARABit45Value = 1;
        }

        if (acasInputBits.get(ARA_BIT46_INDEX)) {
            ARABit46Value = 1;
        }

        if (acasInputBits.get(ARA_BIT47_INDEX)) {
            ARABit47Value = 1;
        }

        if (acasInputBits.get(ARA_BIT48_INDEX)) {
            ARABit48Value = 1;
        }

        if (acasInputBits.get(ARA_BIT49_INDEX)) {
            ARABit49Value = 1;
        }

        if (acasInputBits.get(ARA_BIT50_INDEX)) {
            ARABit50Value = 1;
        }

        // calculate String representation of the binary value
        // represented by the bits MTI - ARA41 - ARA42 - ... - ARA50
        // and retrieve the code from the specific structure

        StringBuffer sb = new StringBuffer();
        sb.append(MTIBitValue).append(ARABit41Value).append(ARABit42Value).append(ARABit43Value)
                .append(ARABit44Value).append(ARABit45Value).append(ARABit46Value)
                .append(ARABit47Value).append(ARABit48Value).append(ARABit49Value)
                .append(ARABit50Value);
        String auralBinaryRepresentation = sb.toString();

        auralCode = AuralCalculator.getInstance().getAuralv604RepresentationToCodeDictionary()
                .get(sb.toString());

        return auralCode;
    }
}
