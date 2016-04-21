/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.cat062.AsterixCat062Item105;
import jlg.jade.common.AsterixDecodingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AsterixCat062Item105DecodingTest {

    @Test(expected = AsterixDecodingException.UnexpectedEndOfData.class)
    public void when_remaining_input_data_less_than_8_bytes_should_throw(){
        //arrange
        byte[] input = {1,2,3,4,5,6,7};
        int offset = 0;
        AsterixCat062Item105 item = new AsterixCat062Item105();

        //act
        item.decode(input, offset);
    }

    @Test
    public void should_correctly_decode_data(){
        //arrange
        byte[] input = {0, (byte) 146,96, (byte) 221,0,45, (byte) 149,81};
        int offset = 0;
        AsterixCat062Item105 item = new AsterixCat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertEquals("Latitude information not decoded correctly", 9593053, item.getLatitudeWsg84());
        assertEquals("Longitude information not decoded correctly", 2987345, item.getLongitudeWsg84());
        assertTrue(item.isValid());
    }

    @Test
    public void should_increase_offset_after_decoding(){
        //arrange
        byte[] input = {0, (byte) 146,96, (byte) 221,0,45, (byte) 149,81};
        int offset = 0;
        AsterixCat062Item105 item = new AsterixCat062Item105();

        //act
        int newOffset = item.decode(input, offset);

        //assert
        assertEquals("Offset not incremented after decoding the data", offset+item.getSizeInBytes(), newOffset);
    }

    @Test
    public void should_calculate_decimal_wsg84_coordinates_correctly(){
        //arrange
        byte[] input = {0, (byte) 146,96, (byte) 221,0,45, (byte) 149,81};
        int offset = 0;
        AsterixCat062Item105 item = new AsterixCat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertEquals(51.457136292, item.getLatitudeDecimalWsg84(),0.01);
        assertEquals(16.02411858, item.getLongitudeDecimalWsg84(),0.01);
    }

    @Test
    public void when_latitude_outside_range_should_set_valid_flag_to_false(){
        //TODO: To be continued
    }

}
