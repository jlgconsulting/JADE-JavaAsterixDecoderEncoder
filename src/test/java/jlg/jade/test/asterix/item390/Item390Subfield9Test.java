/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield9;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item390Subfield9Test extends MandatoryFixedLengthAsterixTests<Item390Subfield9> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Item390Subfield9 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield9();
    }

    @Test
    public void the_decode_methos_should_correctly_decode_data(){
        //arrange
        byte[] input = {48, 56, 76};
        int offset = 0;
        Item390Subfield9 subfield9 = new Item390Subfield9();

        //act
        subfield9.decode(input, offset, input.length);

        //assert
        assertEquals("Item 390 #9 not decoded correctly", "08L", subfield9.getRunwayDesignator());
    }
}
