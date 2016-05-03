/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

public class TwoComplementDecoder {

    public static int decodeFromTwoBytes(byte[] input, int offset){
        int result = input[offset]*256 + Byte.toUnsignedInt(input[offset+1]);

        return result;
    }
}
