/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.common;

public class IA5Decoder {
    /**
     * Converts a 6 byte input into a 8 character ASCII String
     */
    public static String decodeFromSixBytes(byte[] input, int offset) {
        // create string buffer with all the 6 bytes including leading zeros
        StringBuffer sb = new StringBuffer();
        for (int i = offset; i < offset + 6; i++) {
            String temp = Integer.toBinaryString(input[i]);
            String zeroPadded = ("00000000" + temp).substring(temp.length());
            sb.append(zeroPadded);
        }

        // parse the buffer and retrieve each 6 bits to convert from IA5 to ASCII
        int[] chars = new int[8];
        StringBuffer identificationBuffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            chars[i] = Integer.parseInt(sb.substring(i * 6, i * 6 + 6), 2);
            identificationBuffer.append((char) convertIA5toASCII(chars[i]));
        }
        return identificationBuffer.toString().trim();
    }

    /**
     * @param characterCode represents IA5 character code value
     * @return equivalent character in ASCII
     */
    private static int convertIA5toASCII(int characterCode) {
        // IA5 values are a restricted 6bit set of the ASCII table
        final char IA5_ALPHA = 0x01;
        final char IA5_SPACE = 0x20;
        final char IA5_DIGIT = 0x30;
        final char ASC_DIGIT = '0';
        final char ASC_ALPHA = 'A';
        final char ASC_SPACE = ' ';
        final char ASC_ERROR = '?';

        if (characterCode == IA5_SPACE) {
            characterCode = ASC_SPACE;
            return characterCode;
        }

        if (IA5_DIGIT <= characterCode && characterCode < IA5_DIGIT + 10) {
            // character is a digit
            characterCode = (ASC_DIGIT + (characterCode - IA5_DIGIT));
            return characterCode;
        }

        if (IA5_ALPHA <= characterCode && characterCode < IA5_ALPHA + 26) {
            // character is a letter
            characterCode = (ASC_ALPHA + (characterCode - IA5_ALPHA));
            return characterCode;
        }

        characterCode = ASC_ERROR;

        return characterCode;

    }
}
