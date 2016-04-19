/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

public class AsterixDecodingException {

    public static class UnexpectedEndOfData extends RuntimeException{
        public UnexpectedEndOfData(String msg) {
            super(msg);
        }
    }

    public static class UndeterminedFspecEnd extends RuntimeException {
    }
}
