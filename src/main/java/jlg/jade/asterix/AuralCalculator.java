/**
 * Created by alexandru on 7/21/16.
 */
package jlg.jade.asterix;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

public class AuralCalculator {

    private static AuralCalculator auralCalculatorInstance = null;

    private static String auralCode;
    private static List<String> araList = new ArrayList<>();

    static HashMap<String, String> Auralv604RepresentationToCodeDictionary;

    // TODO: Should we process the bitset in order to have the bit indexes like in the Cat048Item260 specification document?
    // MTI / MTE bit index and value
    static final int MTI_BIT_INDEX = 28;
    static int MTIBitValue = 0;

    // ARA bits indexes
    static final int ARA_BIT41_INDEX = 15;
    static final int ARA_BIT42_INDEX = 14;
    static final int ARA_BIT43_INDEX = 13;
    static final int ARA_BIT44_INDEX = 12;
    static final int ARA_BIT45_INDEX = 11;
    static final int ARA_BIT46_INDEX = 10;
    static final int ARA_BIT47_INDEX = 9;
    static final int ARA_BIT48_INDEX = 8;
    static final int ARA_BIT49_INDEX = 23;
    static final int ARA_BIT50_INDEX = 22;

    // initialize ARA bits to 0
    static int ARABit41Value = 0;
    static int ARABit42Value = 0;
    static int ARABit43Value = 0;
    static int ARABit44Value = 0;
    static int ARABit45Value = 0;
    static int ARABit46Value = 0;
    static int ARABit47Value = 0;
    static int ARABit48Value = 0;
    static int ARABit49Value = 0;
    static int ARABit50Value = 0;

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
                setARABits(acasInputBits);
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

    /**
     * TODO: refactor usage of bitset so they are common for the class, not method
     * TODO: refactor version to switch logic depending on version
     * @param input
     * @param version TCAS version to be used
     * @return list of ARA messages
     */
    public static List<String> getAraList(byte[] input, TCASVersion version) {
        BitSet acasInputBits = BitSet.valueOf(input);

        if (acasInputBits.get(ARA_BIT41_INDEX)) {
            araList.add("Climb");
        }

        if (acasInputBits.get(ARA_BIT42_INDEX)) {
            araList.add("Don’t descend");
        }

        if (acasInputBits.get(ARA_BIT43_INDEX)) {
            araList.add("Don’t descend faster than 500 fpm");
        }

        if (acasInputBits.get(ARA_BIT44_INDEX)) {
            araList.add("Don’t descend faster than 1000 fpm");
        }

        if (acasInputBits.get(ARA_BIT45_INDEX)) {
            araList.add("Don’t descend faster than 2000 fpm");
        }

        if (acasInputBits.get(ARA_BIT46_INDEX)) {
            araList.add("Descend");
        }

        if(acasInputBits.get(ARA_BIT47_INDEX)) {
            araList.add("Don’t climb");
        }

        if(acasInputBits.get(ARA_BIT48_INDEX)) {
            araList.add("Don’t climb faster than 500 fpm");
        }

        if(acasInputBits.get(ARA_BIT49_INDEX)) {
            araList.add("Don’t climb faster than 1000 fpm");
        }

        if(acasInputBits.get(ARA_BIT50_INDEX)) {
            araList.add("Don’t climb faster than 2000 fpm");
        }

        return araList;
    }

    private static void setARABits(BitSet acasInputBits) {
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
    }
}
