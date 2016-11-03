/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield18;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item380Subfield18Test extends MandatoryFixedLengthAsterixTests<Cat062Item380Subfield18> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item380Subfield18 setFixedLengthAsterixDataInstance() {
        return new Cat062Item380Subfield18();
    }

    @Test
    public void the_decode_method_shpuld_succesfully_decode_data() {
        //arrange
        byte[] input = {8, 46};
        int offset = 0;
        Cat062Item380Subfield18 subfield = new Cat062Item380Subfield18();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Ground speed not decoded correctly", 2094, subfield.getGroundSpeed());
    }

    @Test
    @Parameters({"127, 255, false", "8, 46, true"})
    public void the_validate_function_should_correctly_set_valid_flag(
            int firstOctet, int secondOctet, boolean
            expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item380Subfield18 subfield = new Cat062Item380Subfield18();

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
        Cat062Item380Subfield18 subfield = new Cat062Item380Subfield18();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(460, (int) subfield.getGroundSpeedKnots(), 0.0001);
    }

    /*
    Encoding Test
     */

    @Test
    public void the_encode_method_should_produce_correct_byte_array() {
        //arrange
        int groundSpeed = 2094;
        Cat062Item380Subfield18 cat062Item380Subfield18 = new Cat062Item380Subfield18();
        cat062Item380Subfield18.setGroundSpeed(groundSpeed);

        //act
        byte[] result = cat062Item380Subfield18.encode();

        //assert
        byte[] expected = {8, 46};
        assertTrue("Item 380 - ground speed not encoded correctly", Arrays.equals(expected, result));
        assertEquals(cat062Item380Subfield18.getSizeInBytes(), result.length);
    }
}
