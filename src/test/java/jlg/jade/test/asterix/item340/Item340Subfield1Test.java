/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item340;

import jlg.jade.asterix.cat062.item340.Item340Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item340Subfield1Test extends MandatoryFixedLengthAsterixTests<Item340Subfield1> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item340Subfield1 setFixedLengthAsterixDataInstance() {
        return new Item340Subfield1();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {(byte) 132, 5};
        int offset = 0;
        Item340Subfield1 subfield1 = new Item340Subfield1();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly", 132, subfield1.getSac());
        assertEquals("Subfield not decoded correctly", 5, subfield1.getSic());
    }
}
