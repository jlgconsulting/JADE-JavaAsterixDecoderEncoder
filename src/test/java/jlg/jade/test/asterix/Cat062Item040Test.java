/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.cat062.Cat062Item040;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item040Test {

    @Test
    public void should_have_length_of_2_bytes(){
        //arrange
        Cat062Item040 item = new Cat062Item040();

        //assert
        assertEquals("Item length is invalid", 2, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
    public void the_decode_method_when_remaining_input_data_less_than_2_bytes_should_throw(){
        //arrange
        byte[] input = {5, (byte) 193};
        int offset = 1;
        Cat062Item040 item = new Cat062Item040();

        //act
        item.decode(input, offset, input.length);
    }

    @Test
    public void the_decode_method_should_decode_data_correctly(){
        //arrange
        byte[] input = {5, (byte) 193};
        int offset = 0;
        Cat062Item040 item = new Cat062Item040();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Track number not decoded correctly", 1473, item.getTrackNb());
        assertTrue(item .isValid());
    }

    @Test
    public void the_decode_method_should_increase_offset_after_decoding_the_data(){
        //arrange
        byte[] input = {5, (byte) 193};
        int offset = 0;
        Cat062Item040 item = new Cat062Item040();

        //act
        int result = item.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", offset+item.getSizeInBytes(), result);
    }
}
