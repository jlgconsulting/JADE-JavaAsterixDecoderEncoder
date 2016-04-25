/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.common.AsterixDecodingException;
import jlg.jade.cat062.Cat062Item015;
import jlg.jade.common.Constants;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Cat062Item015DecodingTest {
    private Logger logger;

    @Before
    public void init() {
        logger = LoggerFactory.getLogger(Constants.LOGGER_NAME);
    }

    @Test(expected = AsterixDecodingException.UnexpectedEndOfData.class)
    public void when_remaining_input_data_length_less_than_1_byte_should_throw(){
        //arrange
        byte inputData[] = {1,2,3,4};
        int offset = 4;
        Cat062Item015 asterixItem = new Cat062Item015();

        //act
        asterixItem.decode(inputData,offset);
    }

    @Test
    public void should_correctly_decode_data(){
        //arrange
        byte[] data = {(byte) 200};
        int offset = 0;
        Cat062Item015 asterixItem = new Cat062Item015();

        //act
        asterixItem.decode(data, offset);

        //assert
        assertEquals("Service identification not decoded correctly", 200, asterixItem.getServiceIdentification());
    }


    @Test
    public void should_increase_offset_after_decoding(){
        //arrange
        byte[] data = {(byte) 200};
        int offset = 0;
        Cat062Item015 asterixItem = new Cat062Item015();

        //act
        int result = asterixItem.decode(data, offset);

        //assert
        assertEquals("Current index not incremented correctly", offset+1, result);
    }
}
