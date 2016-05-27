/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield13;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item390Subfield13Test extends MandatoryFixedLengthAsterixTests<Item390Subfield13> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 6;
    }

    @Override
    protected Item390Subfield13 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield13();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {77, 68, 56, 50, 32, 32};
        int offset = 0;
        Item390Subfield13 subfield13 = new Item390Subfield13();

        //act
        subfield13.decode(input, offset, input.length);

        //assert
        assertEquals("Item 390 #13 not decoded correctly", "MD82", subfield13.getAircraftStand());
    }
}
