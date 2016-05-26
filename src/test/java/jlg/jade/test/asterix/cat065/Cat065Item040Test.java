/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat065;

import jlg.jade.asterix.cat065.Cat065Item040;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat065Item040Test extends MandatoryFixedLengthAsterixTests<Cat065Item040> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat065Item040 setFixedLengthAsterixDataInstance() {
        return new Cat065Item040();
    }
}
