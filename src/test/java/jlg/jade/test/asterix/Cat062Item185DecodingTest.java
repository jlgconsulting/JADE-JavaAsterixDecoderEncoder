/* 
* Created by dan-geabunea on 4/25/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.cat062.Cat062Item185;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item185DecodingTest {

    @Test
    public void should_have_length_of_4_bytes() {
        //arrange
        Cat062Item185 item = new Cat062Item185();

        //assert
        assertEquals(4, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
    public void the_decode_method_when_remaining_input_data_is_less_than_4_bytes_should_throw() {
        //arrange
        byte[] input = {1, 2, 3};
        int offset = 0;
        Cat062Item185 item = new Cat062Item185();

        //act
        item.decode(input, offset, input.length);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {(byte) 253, 121, 2, 108};
        int offset = 0;
        Cat062Item185 item = new Cat062Item185();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Vx not successfully decoded", -647, item.getVx());
        assertEquals("Vy not successfully decoded", 620, item.getVy());
        assertTrue(item.isValid());
    }

    @Test
    public void the_decode_method_should_increase_offset_after_parsing_the_data() {
        //arrange

        byte[] input = {(byte) 253, 121, 2, 108};
        int offset = 0;
        Cat062Item185 item = new Cat062Item185();

        //act
        int result = item.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after parsing the data", offset + 4, result);
    }
}
