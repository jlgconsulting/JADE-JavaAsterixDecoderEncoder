/*
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/

package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.cat062.Cat062Item010;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Cat062Item010Test {

    @Test
    public void should_have_length_of_2_bytes() {
        //arrange
        Cat062Item010 item = new Cat062Item010();

        //assert
        assertEquals("Item aize is not valid", 2, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
    public void the_decode_method_when_remaining_input_data_less_than_2_bytes_should_throw() {
        //arrange
        byte[] data = {1, 2, 3, 4};
        int offset = 3;
        Cat062Item010 asterixItem = new Cat062Item010();

        //act
        asterixItem.decode(data, offset, data.length);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] data = {(byte) 70, (byte) 16};
        int offset = 0;
        Cat062Item010 asterixItem = new Cat062Item010();

        //act
        asterixItem.decode(data, offset, data.length);

        //assert
        assertEquals("Sac not decoded correctly", 70, asterixItem.getSac());
        assertEquals("Sic not decoded correctly", 16, asterixItem.getSic());

    }

    @Test
    public void the_decode_method_should_increase_offset_after_decoding() {
        //arrange
        byte[] data = {(byte) 70, (byte) 16};
        int offset = 0;
        Cat062Item010 asterixItem = new Cat062Item010();

        //act
        int result = asterixItem.decode(data, offset, data.length);

        //assert
        int expectedCurrentIndex = offset + AsterixItemLength.TWO_BYTES.getValue();
        assertEquals("Current index not incremented correctly", expectedCurrentIndex, result);
    }

    /*
    ENCODE
     */

    @Test
    public void the_encode_method_should_produce_correct_byte_array() {
        //arrange
        int sac = 70;
        int sic = 16;
        Cat062Item010 cat062Item010 = new Cat062Item010();
        cat062Item010.setSac(sac);
        cat062Item010.setSic(sic);

        //act
        byte[] result = cat062Item010.encode();

        //assert
        byte[] expected = {70, 16};
        assertTrue(Arrays.equals(result, expected));
    }
}
