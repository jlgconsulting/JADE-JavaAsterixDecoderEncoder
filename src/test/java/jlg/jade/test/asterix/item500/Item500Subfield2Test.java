/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item500;

import jlg.jade.cat062.item500.Item500Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item500Subfield2Test extends MandatoryFixedLengthAsterixTests<Item500Subfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item500Subfield2 setFixedLengthAsterixDataInstance() {
        return new Item500Subfield2();
    }
}
