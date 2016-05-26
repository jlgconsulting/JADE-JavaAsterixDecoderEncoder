/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item015;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item015DecodingTest {

    @Test
    public void should_have_length_of_2_bytes(){
        //arrange
        Cat062Item015 item = new Cat062Item015();

        //assert
        assertEquals("Item size is not valid", 1, item.getSizeInBytes());
    }

    @Test(expected = AsterixDecodingException.AvailableLengthExceeded.class)
    public void the_decode_method_when_remaining_input_data_length_less_than_1_byte_should_throw(){
        //arrange
        byte inputData[] = {1,2,3,4};
        int offset = 4;
        Cat062Item015 asterixItem = new Cat062Item015();

        //act
        asterixItem.decode(inputData,offset, inputData.length);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] data = {(byte) 200};
        int offset = 0;
        Cat062Item015 asterixItem = new Cat062Item015();

        //act
        asterixItem.decode(data, offset, data.length);

        //assert
        assertEquals("Service identification not decoded correctly", 200, asterixItem.getServiceIdentification());
    }


    @Test
    public void the_decode_method_should_increase_offset_after_decoding(){
        //arrange
        byte[] data = {(byte) 200};
        int offset = 0;
        Cat062Item015 asterixItem = new Cat062Item015();

        //act
        int result = asterixItem.decode(data, offset, data.length);

        //assert
        assertEquals("Current index not incremented correctly", offset+1, result);
    }
}
