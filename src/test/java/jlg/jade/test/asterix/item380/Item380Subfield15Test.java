/* 
* Created by dan-geabunea on 4/29/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.cat062.item380.Item380Subfield15;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield15Test implements BasicAsterixDataTestSuite {
    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield15 subfield = new Item380Subfield15();

        //assert
        assertEquals("Subfield has invalid length", 2, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Item380Subfield15 subfield = new Item380Subfield15();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding of data", 2, result);
    }

    @Test
    @Parameters({"0,1,1", "255,255,-1"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet, int secondOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield15 subfield = new Item380Subfield15();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Roll angle not decoded correctly", expected, subfield.getRollAngle());
    }

    @Test
    public void the_get_roll_angle_degrees_method_should_convert_roll_angle_to_degrees() {
        //arrange
        byte[] input = {0, 100};
        int offset = 0;
        Item380Subfield15 subfield = new Item380Subfield15();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(1, subfield.getRollAngleDegrees());
    }

    @Test
    @Parameters({"100,0,false", "100,100,false", "0,180,true"})
    public void the_validate_method_should_correctly_set_valid_flag(int firstOctet, int secondOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield15 subfield = new Item380Subfield15();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(expected, subfield.isValid());

    }
}
