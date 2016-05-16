/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield22;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item380Subfield22Test extends MandatoryFixedLengthAsterixTests<Item380Subfield22> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 6;
    }

    @Override
    protected Item380Subfield22 setFixedLengthAsterixDataInstance() {
        return new Item380Subfield22();
    }
}
