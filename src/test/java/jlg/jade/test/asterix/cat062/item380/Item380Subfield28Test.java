/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield28;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item380Subfield28Test extends MandatoryFixedLengthAsterixTests<Item380Subfield28> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item380Subfield28 setFixedLengthAsterixDataInstance() {
        return new Item380Subfield28();
    }
}
