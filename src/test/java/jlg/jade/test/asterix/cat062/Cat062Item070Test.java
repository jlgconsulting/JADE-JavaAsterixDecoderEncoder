/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;


import jlg.jade.asterix.cat062.Cat062Item070;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item070Test {

    @Test
    public void should_have_length_of_3_bytes(){
        //arrange
        Cat062Item070 item = new Cat062Item070();

        //assert
        assertEquals("Item size is not valid", 3, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
        public void the_decode_method_when_remaining_input_data_length_less_than_3_bytes_should_throw(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat062Item070 item = new Cat062Item070();

        //act
        item.decode(input, offset, input.length);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {103, (byte) 172, (byte) 233};
        int offset = 0;
        Cat062Item070 item = new Cat062Item070();

        //act
        item.decode(input, offset, input.length);

        //assert
        assertEquals("Time of track information not decoded correctly", 6794473, item.getTime());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding(){
        //arrange
        byte[] input = {103, (byte) 172, (byte) 233};
        int offset = 0;
        Cat062Item070 item = new Cat062Item070();

        //act
        int result = item.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding the data", offset + item.getSizeInBytes(), result);
    }

    @Test
    public void should_convert_time_to_hh_mm_ss(){
        //arrange
        byte[] input = {103, (byte) 172, (byte) 233};
        int offset = 0;
        Cat062Item070 item = new Cat062Item070();

        //act
        item.decode(input,offset, input.length);

        //assert
        assertEquals(14, item.getHours());
        assertEquals(44, item.getMinutes());
        assertEquals(41, item.getSeconds());
    }
}
