/*
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/

package jlg.jade.test.asterix;

import jlg.jade.common.AsterixDecodingException;
import jlg.jade.abstraction.AsterixItem;
import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.cat062.AsterixCat062Item010;
import jlg.jade.common.Constants;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class AsterixCat062Item010DecodingTest {

    private Logger logger;

    @Before
    public void init() {
        logger = LoggerFactory.getLogger(Constants.LOGGER_NAME);
    }

    @Test(expected = AsterixDecodingException.UnexpectedEndOfData.class)
    public void when_remaining_input_data_less_than_2_bytes_should_throw() {
        //arrange
        byte[] data = {1, 2, 3, 4};
        int offset = 3;
        AsterixCat062Item010 asterixItem = new AsterixCat062Item010();

        //act
        asterixItem.decode(data, offset);
    }

    @Test
    public void should_correctly_decode_data() {
        //arrange
        byte[] data = {(byte) 70, (byte) 16};
        int offset = 0;
        AsterixCat062Item010 asterixItem = new AsterixCat062Item010();

        //act
        asterixItem.decode(data, offset);

        //assert
        assertEquals("Sac not decoded correctly", 70, asterixItem.getSac());
        assertEquals("Sic not decoded correctly", 16, asterixItem.getSic());

    }


    @Test
    public void should_increase_offset_after_decoding() {
        //arrange
        byte[] data = {(byte) 70, (byte) 16};
        int offset = 0;
        AsterixCat062Item010 asterixItem = new AsterixCat062Item010();

        //act
        int result = asterixItem.decode(data, offset);

        //assert
        int expectedCurrentIndex = offset + AsterixItemLength.TWO_BYTES.getValue();
        assertEquals("Current index not incremented correctly", expectedCurrentIndex, result);
    }
}
