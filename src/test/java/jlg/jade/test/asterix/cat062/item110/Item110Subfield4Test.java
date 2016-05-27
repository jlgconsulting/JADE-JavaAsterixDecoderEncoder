/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item110;

import jlg.jade.asterix.cat062.item110.Item110Subfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item110Subfield4Test extends MandatoryFixedLengthAsterixTests<Item110Subfield4> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item110Subfield4 setFixedLengthAsterixDataInstance() {
        return new Item110Subfield4();
    }
}
