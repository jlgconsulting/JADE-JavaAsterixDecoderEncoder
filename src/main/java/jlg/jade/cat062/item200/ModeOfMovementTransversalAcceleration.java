/*
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item200;

public enum ModeOfMovementTransversalAcceleration {
    ConstantCourse(0),
    RightTurn(1),
    LeftTurn(2),
    Undetermined(3);

    private final int value;

    ModeOfMovementTransversalAcceleration(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
