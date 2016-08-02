/**
 * Created by alexandru on 7/21/16.
 */
package jlg.jade.asterix.cat048;

import java.util.HashMap;

public class AuralCalculator {

/*
    private static AuralCalculator auralCalculatorInstance = null;
*/

    private static String auralCode;
    /*private static List<String> araList = new ArrayList<>();*/

    // TODO: Should we process the bitset in order to have the bit indexes like in the Cat048Item260 specification document?
/*    // MTI / MTE bit index and value
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
    static int ARABit50Value = 0;*/

    /*public static AuralCalculator getInstance() {
        if (auralCalculatorInstance == null) {
            auralCalculatorInstance = new AuralCalculator();
        }

        return auralCalculatorInstance;
    }*/

/*    public static HashMap<String, String> getAuralv604RepresentationToCodeDictionary() {
        return Auralv604RepresentationToCodeDictionary;
    }*/

    /**
     * This method determines the aural code
     *
     * @param input   represents the item260 bits
     * @param version represents the TCAS version
     * @return the aural code
     */
    public static String determineAuralCode(Cat048Item260 input, TCASVersion version) {
        // transform the input into bitset to get the required bits ( ARA41 - ARA50 and MTI )
/*
        BitSet acasInputBits = BitSet.valueOf(input);
*/

        switch (version) {
            case VERSION_604:
/*
                setARABits(acasInputBits);
*/
                auralCode = getVersion604AuralCode(input);
                break;
            case VERSION_70:
                auralCode = getVersion70AuralCode(input);
                break;
        }

        return auralCode;
    }

    /**
     * This method calculates the auralCode code based on the numeric value of the following bits:
     * MTI / MTE + ARA[41-50]
     * Reference document:
     *
     * @param item260 represents the category 48 item 260
     * @return the auralCode code
     */
    private static String getVersion604AuralCode(Cat048Item260 item260) {
        // calculate String representation of the binary value
        // represented by the bits ARA41 - ARA42 - ... - ARA50 of Cat048 Item260
        // and retrieve it from the private dictionary class for version 6.04

        StringBuffer sb = new StringBuffer();
        sb.append(item260.getMultiThreatIndicator()).append(item260.getARABit41())
                .append(item260.getARABit42()).append(item260.getARABit43())
                .append(item260.getARABit44()).append(item260.getARABit45())
                .append(item260.getARABit46())
                .append(item260.getARABit47()).append(item260.getARABit48())
                .append(item260.getARABit49())
                .append(item260.getARABit50());
        String auralBinaryRepresentation = sb.toString();

/*
        auralCode = AuralCalculator.getInstance().getAuralv604RepresentationToCodeDictionary()
                .get(sb.toString());
*/

        auralCode = Aurals604Dictionary.getAuralv604RepresentationToCodeDictionary()
                .get(auralBinaryRepresentation);

        return auralCode;
    }

    private static String getVersion70AuralCode(Cat048Item260 item260) {
        // calculate String representation of the binary value
        // represented by the bits ARA41 - ARA42 - ... - ARA50 of Cat048 Item260
        // and retrieve it from the private dictionary class for version 6.04

        StringBuffer sb = new StringBuffer();
        sb.append(item260.getMultiThreatIndicator()).append(item260.getARABit41())
                .append(item260.getARABit42()).append(item260.getARABit43())
                .append(item260.getARABit44()).append(item260.getARABit45())
                .append(item260.getARABit46())
                .append(item260.getARABit47());
        String auralBinaryRepresentation = sb.toString();

/*
        auralCode = AuralCalculator.getInstance().getAuralv604RepresentationToCodeDictionary()
                .get(sb.toString());
*/

        auralCode = Aurals70Dictionary.getAuralv70RepresentationToCodeDictionary()
                .get(auralBinaryRepresentation);

        return auralCode;
    }

    /**
     * TODO: refactor usage of bitset so they are common for the class, not method
     * TODO: refactor version to switch logic depending on version
     *
     * @return list of ARA messages
     */
    /*public static List<String> getAraList(byte[] input, TCASVersion version) {
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
    }*/

    /*private static void setARABits(BitSet acasInputBits) {
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
    }*/

    static class Aurals604Dictionary {

        public static Aurals604Dictionary instance = null;

        static HashMap<String, String> Auralv604RepresentationToCodeDictionary = new HashMap<String, String>();

        public static HashMap<String, String> getAuralv604RepresentationToCodeDictionary() {
            if (instance == null) {
                instance = new Aurals604Dictionary();
            }
            return Auralv604RepresentationToCodeDictionary;
        }

        private Aurals604Dictionary() {
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

    }

    static class Aurals70Dictionary {

        public static Aurals70Dictionary instance = null;

        static HashMap<String, String> Auralv70RepresentationToCodeDictionary = new HashMap<String, String>();

        public static HashMap<String, String> getAuralv70RepresentationToCodeDictionary() {
            if (instance == null) {
                instance = new Aurals70Dictionary();
            }
            return Auralv70RepresentationToCodeDictionary;
        }

        private Aurals70Dictionary() {
            Auralv70RepresentationToCodeDictionary.put("00000000", "no RA");
            Auralv70RepresentationToCodeDictionary.put("01000000", "MVS");
            Auralv70RepresentationToCodeDictionary.put("01000001", "MVSM");
            Auralv70RepresentationToCodeDictionary.put("01000011", "MVSXM");
            Auralv70RepresentationToCodeDictionary.put("01010000", "MVS");
            Auralv70RepresentationToCodeDictionary.put("01010001", "MVSM");
            Auralv70RepresentationToCodeDictionary.put("01010011", "MVSXM");
            Auralv70RepresentationToCodeDictionary.put("01100000", "AVSA(v7.0)/LOLO(v7.1)");
            Auralv70RepresentationToCodeDictionary.put("01100001", "CC");
            Auralv70RepresentationToCodeDictionary.put("01100011", "CXC-CXC");
            Auralv70RepresentationToCodeDictionary.put("01100101", "CCN");
            Auralv70RepresentationToCodeDictionary.put("01100111", "CCN");
            Auralv70RepresentationToCodeDictionary.put("01101001", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("01101011", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("01110000", "AVSA(v7.0)/LOLO(v7.1)");
            Auralv70RepresentationToCodeDictionary.put("01110001", "DD");
            Auralv70RepresentationToCodeDictionary.put("01110011", "DXD-DXD");
            Auralv70RepresentationToCodeDictionary.put("01110101", "DDN-DDN");
            Auralv70RepresentationToCodeDictionary.put("01110111", "DDN-DDN");
            Auralv70RepresentationToCodeDictionary.put("01111001", "ID-ID");
            Auralv70RepresentationToCodeDictionary.put("01111011", "ID-ID");

            // aurals for MTI value = 1 are the same as for MTI = 0;

            Auralv70RepresentationToCodeDictionary.put("11000000", "MVS");
            Auralv70RepresentationToCodeDictionary.put("11000001", "MVSM");
            Auralv70RepresentationToCodeDictionary.put("11000011", "MVSXM");
            Auralv70RepresentationToCodeDictionary.put("11010000", "MVS");
            Auralv70RepresentationToCodeDictionary.put("11010001", "MVSM");
            Auralv70RepresentationToCodeDictionary.put("11010011", "MVSXM");
            Auralv70RepresentationToCodeDictionary.put("11100000", "AVSA(v7.0)/LOLO(v7.1)");
            Auralv70RepresentationToCodeDictionary.put("11100001", "CC");
            Auralv70RepresentationToCodeDictionary.put("11100011", "CXC-CXC");
            Auralv70RepresentationToCodeDictionary.put("11100101", "CCN");
            Auralv70RepresentationToCodeDictionary.put("11100111", "CCN");
            Auralv70RepresentationToCodeDictionary.put("11101001", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("11101011", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("11110000", "AVSA(v7.0)/LOLO(v7.1)");
            Auralv70RepresentationToCodeDictionary.put("11110001", "DD");
            Auralv70RepresentationToCodeDictionary.put("11110011", "DXD-DXD");
            Auralv70RepresentationToCodeDictionary.put("11110101", "DDN-DDN");
            Auralv70RepresentationToCodeDictionary.put("11110111", "DDN-DDN");
            Auralv70RepresentationToCodeDictionary.put("11111001", "ID-ID");
            Auralv70RepresentationToCodeDictionary.put("11111011", "ID-ID");
        }

    }
}
