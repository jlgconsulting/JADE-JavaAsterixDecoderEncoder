/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item110;

import jlg.jade.asterix.cat062.item110.Cat062Item110Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat062Item110Subfield2Test extends MandatoryFixedLengthAsterixTests<Cat062Item110Subfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat062Item110Subfield2 setFixedLengthAsterixDataInstance() {
        return new Cat062Item110Subfield2();
    }
}
