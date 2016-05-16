/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield16;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item390Subfield16Test extends MandatoryFixedLengthAsterixTests<Item390Subfield16> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Item390Subfield16 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield16();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {65,66,67,68,69,70,32};
        int offset = 0;
        Item390Subfield16 subfield16 = new Item390Subfield16();

        //act
        subfield16.decode(input, offset, input.length);

        //assert
        assertEquals("Item390 #16 not decoded correctly", "ABCDEF", subfield16.getStandardInstrumentArrival());
    }
}
