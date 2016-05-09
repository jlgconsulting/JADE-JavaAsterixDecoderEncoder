/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

import java.util.BitSet;

class BitWriter {
    public static String getBitsRightToLeft(byte b){
        StringBuilder sb = new StringBuilder();
        BitSet bs = BitSet.valueOf(new byte[]{b});
        for (int j=7;j>=0;j--){
            if(bs.get(j)){
                sb.append(1);
                sb.append(" ");
            }
            else{
                sb.append(0);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
