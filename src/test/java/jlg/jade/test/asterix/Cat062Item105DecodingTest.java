/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.cat062.Cat062Item105;
import jlg.jade.common.AsterixDecodingException;
import jlg.jade.common.Constants;
import jlg.jade.test.utils.TestHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class Cat062Item105DecodingTest {

    @Test(expected = AsterixDecodingException.UnexpectedEndOfData.class)
    public void when_remaining_input_data_less_than_8_bytes_should_throw() {
        //arrange
        byte[] input = {1, 2, 3, 4, 5, 6, 7};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        item.decode(input, offset);
    }

    @Test
    public void should_correctly_decode_data() {
        //arrange
        byte[] input = {0, (byte) 146, 96, (byte) 221, 0, 45, (byte) 149, 81};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertEquals("Latitude information not decoded correctly", 9593053, item.getLatitudeWsg84());
        assertEquals("Longitude information not decoded correctly", 2987345, item.getLongitudeWsg84());
        assertTrue(item.isValid());
    }

    @Test
    public void should_increase_offset_after_decoding() {
        //arrange
        byte[] input = {0, (byte) 146, 96, (byte) 221, 0, 45, (byte) 149, 81};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        int newOffset = item.decode(input, offset);

        //assert
        assertEquals("Offset not incremented after decoding the data", offset + item.getSizeInBytes(), newOffset);
    }

    @Test
    public void should_calculate_decimal_wsg84_coordinates_correctly() {
        //arrange
        byte[] input = {0, (byte) 146, 96, (byte) 221, 0, 45, (byte) 149, 81};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertEquals(51.457136292, item.getLatitudeDecimalWsg84(), 0.01);
        assertEquals(16.02411858, item.getLongitudeDecimalWsg84(), 0.01);
    }

    @Test
    public void when_latitude_above_90_should_set_valid_flag_to_false() {
        //arrange
        int latitudeOutsideRange = (int) (91 / Constants.LAT_LONG_WGS_PRECISION_CAT062);
        byte[] invalidLatArray = TestHelper.fromIntToByteArray(latitudeOutsideRange);
        byte[] input = {invalidLatArray[0], invalidLatArray[1], invalidLatArray[2], invalidLatArray[3], 0, 45, (byte) 149, 81};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertFalse(item.isValid());
    }

    @Test
    public void when_latitude_below_minus_90_should_set_valid_flag_to_false() {
        //arrange
        int latitudeOutsideRange = (int) (-91 / Constants.LAT_LONG_WGS_PRECISION_CAT062);
        byte[] invalidLatArray = TestHelper.fromIntToByteArray(latitudeOutsideRange);
        byte[] input = {invalidLatArray[0], invalidLatArray[1], invalidLatArray[2], invalidLatArray[3], 0, 45, (byte) 149, 81};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertFalse(item.isValid());
    }

    @Test
    public void when_longitude_above_180_should_set_valid_flag_to_false() {
        //arrange
        int lonOutsideRange = (int) (181 / Constants.LAT_LONG_WGS_PRECISION_CAT062);
        byte[] invalidLonArray = TestHelper.fromIntToByteArray(lonOutsideRange);
        byte[] input = {0, (byte) 146, 96, (byte) 221, invalidLonArray[0],invalidLonArray[1],invalidLonArray[2],invalidLonArray[3]};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertFalse(item.isValid());
    }

    @Test
    public void when_longitude_below_minus_180_should_set_valid_flag_to_false() {
        //arrange
        int lonOutsideRange = (int) (-181 / Constants.LAT_LONG_WGS_PRECISION_CAT062);
        byte[] invalidLonArray = TestHelper.fromIntToByteArray(lonOutsideRange);
        byte[] input = {0, (byte) 146, 96, (byte) 221, invalidLonArray[0],invalidLonArray[1],invalidLonArray[2],invalidLonArray[3]};
        int offset = 0;
        Cat062Item105 item = new Cat062Item105();

        //act
        item.decode(input, offset);

        //assert
        assertFalse(item.isValid());
    }

}
