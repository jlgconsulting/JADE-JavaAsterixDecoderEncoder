/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

public class ModeACode {

    /**
     * Converts a Mode A code from decimal to its octal representation, on exactly
     * four digits.
     * @param decimalValue The decimal value to be converted to ocatl (0-7777)
     * @return The octal representaion or null, it the decimal value is outside the allowed range.
     */
    public static String toOctal(int decimalValue) {
        if(decimalValue < 0 || decimalValue > 7777){
            //invalid value => leave null
            return null;
        }

        String octal = Integer.toOctalString(decimalValue);

        /**
         * @implNote
         * If octal representation has less than 4 digits, we
         * have to prepend 0 at the beginning. In aviation, a Mode A
         * code has 4 characters
         */

        if (octal.length() == 3) {
            return "0" + octal;
        }
        if (octal.length() == 2) {
            return "00" + octal;
        }
        if (octal.length() == 1) {
            return "000" + octal;
        }
        return octal;
    }
}
