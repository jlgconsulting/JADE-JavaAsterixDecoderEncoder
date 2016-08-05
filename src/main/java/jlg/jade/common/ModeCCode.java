/**
 * Created by alexandru on 8/5/16.
 */
package jlg.jade.common;

public class ModeCCode {
    public static int grayCodeToFeet(int fiveHundredIncrementsGrayCode,
                                     int oneHundredIncrementsGrayCode) {
        // convert the Gillham Gray Code values to binary
        fiveHundredIncrementsGrayCode = GrayCodeToBinary(fiveHundredIncrementsGrayCode);
        oneHundredIncrementsGrayCode = GrayCodeToBinary(oneHundredIncrementsGrayCode);

        // check for invalid codes in the 100ft increments
        if (oneHundredIncrementsGrayCode == 5 || oneHundredIncrementsGrayCode == 6 || oneHundredIncrementsGrayCode == 0) {
            return -1;
        }

        // replace the 7s in 100ft increments with 5s
        if (oneHundredIncrementsGrayCode == 7) {
            oneHundredIncrementsGrayCode = 5;
        }

        // if the parity of the 500ft increments is even "reverse" the 100ft increments
        Boolean is500FeetIncrementEven = (fiveHundredIncrementsGrayCode % 2) != 0;
        if (is500FeetIncrementEven) {
            oneHundredIncrementsGrayCode = 6 - oneHundredIncrementsGrayCode;
        }

        // convert to feet and apply offset
        return fiveHundredIncrementsGrayCode * 500 + oneHundredIncrementsGrayCode * 100 - 1300;
    }

    private static int GrayCodeToBinary(int number) {
        int temp;

        temp = number ^ (number >> 8);
        temp ^= (temp >> 4);
        temp ^= (temp >> 2);
        temp ^= (temp >> 1);

        return temp;
    }
}
