/*Created by dan-geabunea on 5/9/2016.
*This code is the property of JLG Consulting.Please
*check the license terms for this product to see under what
*conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item200;

public enum ModeOfMovementVerticalRate {
    Level(0),
    Climb(1),
    Descent(2),
    Undetermined(3);

    private int value;

    ModeOfMovementVerticalRate(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
