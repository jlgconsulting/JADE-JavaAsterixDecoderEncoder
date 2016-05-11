/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.cat062.item390.Item390Subfield10;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item390Subfield10Test extends MandatoryFixedLengthAsterixTests<Item390Subfield10> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item390Subfield10 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield10();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {5, (byte) 200};
        int offset = 0;
        Item390Subfield10 subfield10 = new Item390Subfield10();

        //act
        subfield10.decode(input, offset, input.length);

        //assert
        assertEquals("Item 390 #10 not decoded correctly", 1480, subfield10.getCfl());
    }

    @Test
    public void the_get_cfl_flight_level_should_correctly_convert_cfl_to_fligh_level_units(){
        //arrange
        byte[] input = {5, (byte) 200};
        int offset = 0;
        Item390Subfield10 subfield10 = new Item390Subfield10();

        //act
        subfield10.decode(input, offset, input.length);

        //assert
        assertEquals(370, subfield10.getCflInFlightLevel());
    }
}
