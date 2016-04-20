/*
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/

package jlg.jade.common;

public enum AsterixCategory {
    CAT_004(4),
    CAT_034(34),
    CAT_048(48),
    CAT_062(62),
    CAT_065(65),
    CAT_150(150);

    private int value;

    private AsterixCategory(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
