/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield25;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Item380Subfield25Test extends MandatoryRepeatableAsterixTests<Item380Subfield25> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 8;
    }

    @Override
    protected Item380Subfield25 setRepeatableAsterixDataInstance() {
        return new Item380Subfield25();
    }
}
