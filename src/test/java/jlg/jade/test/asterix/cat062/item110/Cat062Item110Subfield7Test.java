/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item110;

import jlg.jade.asterix.cat062.item110.Cat062Item110Subfield7;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat062Item110Subfield7Test extends MandatoryFixedLengthAsterixTests<Cat062Item110Subfield7> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat062Item110Subfield7 setFixedLengthAsterixDataInstance() {
        return new Cat062Item110Subfield7();
    }
}
