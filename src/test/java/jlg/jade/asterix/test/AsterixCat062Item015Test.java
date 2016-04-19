/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.test;

import jlg.jade.asterix.AsterixDecodingException;
import jlg.jade.asterix.AsterixItem;
import jlg.jade.asterix.cat062.AsterixCat062Item010;
import jlg.jade.asterix.cat062.AsterixCat062Item015;
import jlg.jade.constants.Constants;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class AsterixCat062Item015Test {
    private Logger logger;

    @Before
    public void init() {
        logger = LoggerFactory.getLogger(Constants.LOGGER_NAME);
    }

    @Test(expected = AsterixDecodingException.UnexpectedEndOfData.class)
    public void when_remaining_input_data_length_less_than_1_byte_should_throw(){
        //arrange
        byte inputData[] = {1,2,3,4};
        int currentIndex = 4;
        AsterixItem asterixItem = new AsterixCat062Item015(logger);

        //act
        asterixItem.parseData(inputData,currentIndex,inputData.length);
    }

    @Test
    public void should_populate_item_with_correct_value(){
        //arrange
        byte[] data = {(byte) 200};
        int currentIndex = 0;
        AsterixCat062Item015 asterixItem = new AsterixCat062Item015(logger);

        //act
        asterixItem.parseData(data, currentIndex, data.length);

        //assert
        assertEquals("Service identification not decoded correctly", 200, asterixItem.getServiceIdentification());
    }

    @Test
    public void should_increase_current_index_after_parsing_data(){
        //arrange
        byte[] data = {(byte) 200};
        int currentIndex = 0;
        AsterixCat062Item015 asterixItem = new AsterixCat062Item015(logger);

        //act
        int result = asterixItem.parseData(data, currentIndex, data.length);

        //assert
        assertEquals("Current index not incremented correctly", currentIndex+1, result);
    }
}
