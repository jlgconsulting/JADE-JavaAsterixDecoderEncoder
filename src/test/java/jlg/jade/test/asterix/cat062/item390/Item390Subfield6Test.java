/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item390Subfield6Test extends MandatoryFixedLengthAsterixTests<Item390Subfield6> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item390Subfield6 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield6();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {76};
        int offset = 0;
        Item390Subfield6 subfield6 = new Item390Subfield6();

        //act
        subfield6.decode(input, offset, input.length);

        //assert
        assertEquals("Item390 #6 not decoded correctly", "L", subfield6.getWakeTurbulenceCategory());
    }
}
