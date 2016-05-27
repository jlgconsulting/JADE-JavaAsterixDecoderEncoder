/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield20;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item380Subfield20Test extends MandatoryFixedLengthAsterixTests<Item380Subfield20> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 8;
    }

    @Override
    protected Item380Subfield20 setFixedLengthAsterixDataInstance() {
        return new Item380Subfield20();
    }
}
