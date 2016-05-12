/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.cat062.Cat062Item120;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat062Item120Test extends MandatoryFixedLengthAsterixTests<Cat062Item120> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item120 setFixedLengthAsterixDataInstance() {
        return new Cat062Item120();
    }
}
