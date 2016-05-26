/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield17;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item390Subfield17Test extends MandatoryFixedLengthAsterixTests<Item390Subfield17> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item390Subfield17 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield17();
    }
}
