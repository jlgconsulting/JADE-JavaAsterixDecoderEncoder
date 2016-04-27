/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.cat062.Cat062Item100;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item100DecodingTest {

    @Test
    public void should_have_length_of_6_bytes() {
        //arrange
        Cat062Item100 item = new Cat062Item100();

        //assert
        assertEquals(6, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
    public void the_decode_method_when_remaining_input_data_less_than_6_bytes_should_throw() {
        //arrange
        byte[] input = {1, 2, 3, 4, 5};
        int offset = 0;
        Cat062Item100 item = new Cat062Item100();

        //assert
        item.decode(input, offset, input.length);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data_for_negative_values() {
        //arrange
        byte[] input = {(byte) 239, 91, 63, (byte) 243, (byte) 158, (byte) 167};
        int offset = 0;
        Cat062Item100 item = new Cat062Item100();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("X not decoded correctly", -1090753, item.getX());
        assertEquals("Y not decoded correctly", -811353, item.getY());
        assertTrue(item.isValid());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data_for_positive_values() {
        //arrange
        byte[] input = {13, (byte) 204, 99, 13, (byte) 204, 99};
        int offset = 0;
        Cat062Item100 item = new Cat062Item100();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("X not decoded correctly", 904291, item.getX());
        assertEquals("Y not decoded correctly", 904291, item.getY());
        assertTrue(item.isValid());
    }

    @Test
    public void the_decode_method_should_increase_offset_after_decoding() {
        //arrange
        byte[] input = {13, (byte) 204, 99, 13, (byte) 204, 99};
        int offset = 0;
        Cat062Item100 item = new Cat062Item100();

        //act
        int result = item.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not updated after data decoding", offset+6,result);
    }

}
