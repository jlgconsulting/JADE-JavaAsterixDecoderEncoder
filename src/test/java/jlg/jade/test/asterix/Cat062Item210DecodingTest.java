/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.cat062.Cat062Item210;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item210DecodingTest {

    @Test
    public void should_have_length_of_two_bytes(){
        //arrange
        Cat062Item210 item = new Cat062Item210();

        //assert
        assertEquals("Size is not correct", 2, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
    public void the_decode_method_when_remaining_input_less_than_two_bytes_should_throw(){
        //arrange
        byte[] input = {1,2};
        int offset = 1;
        Cat062Item210 item = new Cat062Item210();

        //act
        item.decode(input, offset, input.length);
    }

    @Test
    public void the_decode_method_with_negative_values_should_correctly_decode_data(){
        //arrange
        byte input[] = {-127,-126};
        int offset = 0;
        Cat062Item210 item = new Cat062Item210();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Acceleration X axis not decoded correctly", -127, item.getAccelerationX());
        assertEquals("Acceleration Y axis not decoded correctly", -126, item.getAccelerationY());
        assertTrue("Item should be valid", item.isValid());

    }

    @Test
    public void the_decode_method_with_positive_values_should_correctly_decode_data(){
        //arrange
        byte input[] = {127,126};
        int offset = 0;
        Cat062Item210 item = new Cat062Item210();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Acceleration X axis not decoded correctly", 127, item.getAccelerationX());
        assertEquals("Acceleration Y axis not decoded correctly", 126, item.getAccelerationY());
        assertTrue("Item should be valid", item.isValid());
    }
}
