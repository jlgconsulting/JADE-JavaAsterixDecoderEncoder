/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;


import jlg.jade.cat062.AsterixCat062Item070;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsterixCat062Item070Test {

    @Test(expected = AsterixDecodingException.UnexpectedEndOfData.class)
    public void when_remaining_input_data_length_less_than_3_bytes_should_throw(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        AsterixCat062Item070 item = new AsterixCat062Item070();

        //act
        item.decode(input, offset);
    }

    @Test
    public void should_populate_item_with_correct_values(){
        //arrange
        byte[] input = {103, (byte) 172, (byte) 233};
        int offset = 0;
        AsterixCat062Item070 item = new AsterixCat062Item070();

        //act
        item.decode(input,offset);

        //assert
        assertEquals("Time of track information not decoded correctly", 6794473, item.getTimeOfTrack());
    }

    @Test
    public void should_increment_offset_after_parsing_the_data(){
        //arrange
        byte[] input = {103, (byte) 172, (byte) 233};
        int offset = 0;
        AsterixCat062Item070 item = new AsterixCat062Item070();

        //act
        int result = item.decode(input,offset);

        //assert
        assertEquals("Offset not incremented after parsing the data", offset + item.getSizeInBytes(), result);
    }

    @Test
    public void should_convert_time_to_hh_mm_ss(){
        //arrange
        byte[] input = {103, (byte) 172, (byte) 233};
        int offset = 0;
        AsterixCat062Item070 item = new AsterixCat062Item070();

        //act
        item.decode(input,offset);

        //assert
        assertEquals(14, item.getHours());
        assertEquals(44, item.getMinutes());
        assertEquals(41, item.getSeconds());
    }
}
