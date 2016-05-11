/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.cat062.item390.Item390Subfield12;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Item390Subfield12Test extends MandatoryRepeatableAsterixTests<Item390Subfield12> {

    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 4;
    }

    @Override
    protected Item390Subfield12 setRepeatableAsterixDataInstance() {
        return new Item390Subfield12();
    }
}
