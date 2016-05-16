/*
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item200;

public enum ModeOfMovementLongAcceleration {
    ConstantGroundSpeed(0),
    IncreasingGroundSpeed(1),
    DecreasingGroundSpeed(2),
    Undetermined(3);


    private final int value;

    ModeOfMovementLongAcceleration(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
