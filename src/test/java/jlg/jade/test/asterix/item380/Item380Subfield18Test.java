/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield18;
import jlg.jade.test.utils.BasicAsterixDataTestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield18Test implements BasicAsterixDataTestSuite {
    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield18 subfield = new Item380Subfield18();

        //assert
        assertEquals("Subfield length is invalid", 2, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Item380Subfield18 subfield = new Item380Subfield18();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", offset + 2, result);
    }

    @Test
    public void the_decode_method_shpuld_succesfully_decode_data() {
        //arrange
        byte[] input = {8, 46};
        int offset = 0;
        Item380Subfield18 subfield = new Item380Subfield18();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Ground speed not decoded correctly", 2094, subfield.getGroundSpeed());
    }

    @Test
    @Parameters({"127, 255, false", "8, 46, true"})
    public void the_validate_function_should_correctly_set_valid_flag(int firstOctet, int secondOctet, boolean
            expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield18 subfield = new Item380Subfield18();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Ground speed validaiton not correct", expected, subfield.isValid());
    }


    @Test
    public void the_get_ground_speed_in_knots_should_correctly_convert_decoded_speed_in_knots() {
        //arrange
        byte[] input = {8, 46};
        int offset = 0;
        Item380Subfield18 subfield = new Item380Subfield18();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(460, (int)subfield.getGroundSpeedKnots(), 0.0001);
    }
}
