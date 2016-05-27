/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Item390Subfield1Test extends MandatoryFixedLengthAsterixTests<Item390Subfield1> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item390Subfield1 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield1();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {99, (byte) 129};
        int offset = 0;
        Item390Subfield1 subfield1 = new Item390Subfield1();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("I062/390 #1 not decoded correctly", 99, subfield1.getSac());
        assertEquals("I062/390 #1 not decoded correctly", 129, subfield1.getSic());
    }
}
