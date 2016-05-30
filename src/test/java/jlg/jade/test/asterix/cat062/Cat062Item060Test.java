/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item060;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item060Test {

    @Test
    public void should_have_length_of_2_bytes(){
        //arrange
        Cat062Item060 item = new Cat062Item060();

        //assert
        assertEquals("Invalid item length", 2, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
    public void the_decoding_method_when_remaining_input_data_less_than_2_should_throw(){
        //arrange
        byte[] input = {1,2};
        int offset = 1;
        Cat062Item060 item = new Cat062Item060();

        //act
        item.decode(input, offset, input.length);
    }

    @Test
    public void the_decoding_method_when_mode_a_did_not_change_should_correctly_decode_data(){
        //arrange
        byte[] input = {11,12};
        int offset = 0;
        Cat062Item060 item = new Cat062Item060();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Change of Mode3A not decoded correctly", false, item.getModeAChange());
        assertEquals("Mode 3A not decoded correctly", 2828, item.getModeADecimal());
        assertTrue(item.isValid());
    }

    @Test
    public void the_decoding_method_when_mode_changed_should_correctly_decode_data(){
        //arrange
        byte[] input = {43,12};
        int offset = 0;
        Cat062Item060 item = new Cat062Item060();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Change of Mode3A not decoded correctly", true, item.getModeAChange());
        assertEquals("Mode 3A not decoded correctly", 2828, item.getModeADecimal());
        assertTrue(item.isValid());
    }

    @Test
    public void the_decode_method_should_increase_offset_after_decoding(){
        //arrange
        byte[] input = {43,12};
        int offset = 0;
        Cat062Item060 item = new Cat062Item060();

        //act
        int result = item.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", offset+item.getSizeInBytes(), result);
    }

    @Test
    public void the_get_modea_octal_method_should_convert_mode3a_to_octal(){
        //arrange
        byte[] input = {11,12};
        int offset = 0;
        Cat062Item060 item = new Cat062Item060();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Octal conversion of Mode 3A not correct", "5414", item.getModeAOctal());
    }

    @Test
    public void the_get_modea_octal_method_when_octal_has_less_than_4_digits_should_prepend_zeros(){
        //arrange
        byte[] input = {0,12};
        int offset = 0;
        Cat062Item060 item = new Cat062Item060();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Octal conversion of Mode 3A not correct", "0014", item.getModeAOctal());
    }
}
