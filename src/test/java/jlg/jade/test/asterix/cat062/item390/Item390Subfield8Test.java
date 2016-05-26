/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield8;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item390Subfield8Test extends MandatoryFixedLengthAsterixTests<Item390Subfield8> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Item390Subfield8 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield8();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {87, 77, 75, 75};
        int offset = 0;
        Item390Subfield8 subfield8 = new Item390Subfield8();

        //act
        subfield8.decode(input, offset, input.length);

        //assert
        assertEquals("Item390 #8 not decoded correctly", "WMKK", subfield8.getDestinationAirport());
    }
}
