/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Cat062Item390Subfield12;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat062Item390Subfield12Test extends MandatoryRepeatableAsterixTests<Cat062Item390Subfield12> {

    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat062Item390Subfield12 setRepeatableAsterixDataInstance() {
        return new Cat062Item390Subfield12();
    }
}
