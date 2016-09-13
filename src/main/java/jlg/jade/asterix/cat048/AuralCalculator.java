/**
 * Created by alexandru on 7/21/16.
 */
package jlg.jade.asterix.cat048;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AuralCalculator {

    private String auralBinaryRepresentation;
    private String auralCode;

    /**
     * This method determines the aural code
     *
     * @param input   represents the item260 bits
     * @return the aural code
     */
    public String determineAuralCode(Cat048Item260 input) {

        determineAuralBinaryRepresentation(input);

        switch (input.getDeterminedTCASVersion()) {
            case VERSION_604:
                auralCode = getVersion604AuralCode(input);
                break;
            case VERSION_70:
                auralCode = getVersion70AuralCode(input);
                break;
            case VERSION_71:
                auralCode = getVersion71AuralCode(input);
                break;
        }

        return auralCode;
    }

    private String getVersion71AuralCode(Cat048Item260 item260) {

        String version70AuralCode = getVersion70AuralCode(item260);

        // the only aural which is different in v7.1 is "LOLO" which should replace "AVSA"
        if (version70AuralCode == "AVSA") {
            return "LOLO";
        }

        return version70AuralCode;
    }

    private void determineAuralBinaryRepresentation(Cat048Item260 item260) {
        // calculate String representation of the binary value
        // represented by the bits ARA41 .. ARA47 of Cat048 Item260 for v7.0/v7.1
        // or bits ARA41 .. ARA50 for v6.04

        StringBuffer sb = new StringBuffer();
        sb.append(item260.getMultiThreatIndicator()).append(item260.getARABit41())
                .append(item260.getARABit42()).append(item260.getARABit43())
                .append(item260.getARABit44()).append(item260.getARABit45())
                .append(item260.getARABit46())
                .append(item260.getARABit47());

        // append extra bits ( ARA48, ARA49, ARA50 ) for v6.04

        if (item260.getDeterminedTCASVersion() == TCASVersions.VERSION_604) {
            sb.append(item260.getARABit48()).append(item260.getARABit49())
                    .append(item260.getARABit50());
        }

        auralBinaryRepresentation = sb.toString();
    }

    /**
     * This method calculates the auralCode code based on the numeric value of the following bits:
     * MTI / MTE + ARA[41-50]
     * Reference document:
     *
     * @param item260 represents the category 48 item 260
     * @return the auralCode code
     */
    private String getVersion604AuralCode(Cat048Item260 item260) {

        auralCode = Aurals604Dictionary.getAuralv604RepresentationToCodeDictionary()
                .get(auralBinaryRepresentation);

        return auralCode;
    }

    private String getVersion70AuralCode(Cat048Item260 item260) {

        auralCode = Aurals70Dictionary.getAuralv70RepresentationToCodeDictionary()
                .get(auralBinaryRepresentation);

        return auralCode;
    }

    static class Aurals604Dictionary {
        private static final Map<String, String> AURAL_V604_DICTIONARY = createVersion604Dictionary();

        public static Map<String, String> getAuralv604RepresentationToCodeDictionary() {
            return AURAL_V604_DICTIONARY;
        }

        private static Map<String, String> createVersion604Dictionary() {

            HashMap<String, String> Auralv604RepresentationToCodeDictionary = new HashMap<>();

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

            return Collections.unmodifiableMap(Auralv604RepresentationToCodeDictionary);
        }

    }

    static class Aurals70Dictionary {

        static Map<String, String> AURAL_V70_DICTIONARY = createVersion70Dictionary();

        public static Map<String, String> getAuralv70RepresentationToCodeDictionary() {
            return AURAL_V70_DICTIONARY;
        }

        private static Map<String, String> createVersion70Dictionary() {

            HashMap<String, String> Auralv70RepresentationToCodeDictionary = new HashMap<>();

            Auralv70RepresentationToCodeDictionary.put("00000000", "no RA");
            Auralv70RepresentationToCodeDictionary.put("01000000", "MVS");
            Auralv70RepresentationToCodeDictionary.put("01000001", "MVSM");
            Auralv70RepresentationToCodeDictionary.put("01000011", "MVSXM");
            Auralv70RepresentationToCodeDictionary.put("01010000", "MVS");
            Auralv70RepresentationToCodeDictionary.put("01010001", "MVSM");
            Auralv70RepresentationToCodeDictionary.put("01010011", "MVSXM");
            Auralv70RepresentationToCodeDictionary.put("01100000", "AVSA");
            Auralv70RepresentationToCodeDictionary.put("01100001", "CC");
            Auralv70RepresentationToCodeDictionary.put("01100011", "CXC-CXC");
            Auralv70RepresentationToCodeDictionary.put("01100101", "CCN");
            Auralv70RepresentationToCodeDictionary.put("01100111", "CCN");
            Auralv70RepresentationToCodeDictionary.put("01101001", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("01101011", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("01110000", "AVSA");
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
            Auralv70RepresentationToCodeDictionary.put("11100000", "AVSA");
            Auralv70RepresentationToCodeDictionary.put("11100001", "CC");
            Auralv70RepresentationToCodeDictionary.put("11100011", "CXC-CXC");
            Auralv70RepresentationToCodeDictionary.put("11100101", "CCN");
            Auralv70RepresentationToCodeDictionary.put("11100111", "CCN");
            Auralv70RepresentationToCodeDictionary.put("11101001", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("11101011", "IC-IC");
            Auralv70RepresentationToCodeDictionary.put("11110000", "AVSA");
            Auralv70RepresentationToCodeDictionary.put("11110001", "DD");
            Auralv70RepresentationToCodeDictionary.put("11110011", "DXD-DXD");
            Auralv70RepresentationToCodeDictionary.put("11110101", "DDN-DDN");
            Auralv70RepresentationToCodeDictionary.put("11110111", "DDN-DDN");
            Auralv70RepresentationToCodeDictionary.put("11111001", "ID-ID");
            Auralv70RepresentationToCodeDictionary.put("11111011", "ID-ID");

            return Collections.unmodifiableMap(Auralv70RepresentationToCodeDictionary);
        }

    }
}
