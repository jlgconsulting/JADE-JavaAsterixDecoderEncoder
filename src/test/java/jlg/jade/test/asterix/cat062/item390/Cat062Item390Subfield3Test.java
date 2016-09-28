/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Cat062Item390Subfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat062Item390Subfield3Test extends MandatoryFixedLengthAsterixTests<Cat062Item390Subfield3> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat062Item390Subfield3 setFixedLengthAsterixDataInstance() {
        return new Cat062Item390Subfield3();
    }
}
