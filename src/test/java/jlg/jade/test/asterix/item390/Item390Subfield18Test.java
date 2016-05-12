/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.cat062.item390.Item390Subfield18;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item390Subfield18Test extends MandatoryFixedLengthAsterixTests<Item390Subfield18> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Item390Subfield18 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield18();
    }
}
