/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield7;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item390Subfield7Test extends MandatoryFixedLengthAsterixTests<Item390Subfield7> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Item390Subfield7 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield7();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {69, 71, 76, 76};
        int offset = 0;
        Item390Subfield7 subfield7 = new Item390Subfield7();

        //act
        subfield7.decode(input, offset, input.length);

        //assert
        assertEquals("Item 390 #7 not decoded correctly", "EGLL", subfield7.getDepartureAirport());
    }
}
