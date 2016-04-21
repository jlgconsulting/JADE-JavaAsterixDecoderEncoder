package jlg.jade.asterix;/*
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/

public enum AsterixItemLength {
    VARIABLE(-1),
    ONE_BYTE(1),
    TWO_BYTES(2),
    THREE_BYTES(3),
    FOUR_BYTES(4),
    FIVE_BYTES(5),
    SIX_BYTES(6),
    SEVEN_BYTES(7),
    EIGHT_BYTES(8);

    private int value;

    private AsterixItemLength(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
