/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item340;

import jlg.jade.asterix.cat062.item340.Cat062Item340Subfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat062Item340Subfield6Test extends MandatoryFixedLengthAsterixTests<Cat062Item340Subfield6> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat062Item340Subfield6 setFixedLengthAsterixDataInstance() {
        return new Cat062Item340Subfield6();
    }
}
