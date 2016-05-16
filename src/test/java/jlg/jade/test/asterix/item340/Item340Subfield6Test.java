/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item340;

import jlg.jade.asterix.cat062.item340.Item340Subfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Item340Subfield6Test extends MandatoryFixedLengthAsterixTests<Item340Subfield6> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item340Subfield6 setFixedLengthAsterixDataInstance() {
        return new Item340Subfield6();
    }
}
