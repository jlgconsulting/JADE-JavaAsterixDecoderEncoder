/* 
* Created by dan-geabunea on 5/17/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

public class DefaultReservedFieldFactory implements ReservedFieldFactory{

    @Override
    public ReservedAsterixField createSpField() {
        return new ReservedAsterixField();
    }

    @Override
    public ReservedAsterixField createReField() {
        return new ReservedAsterixField();
    }
}
