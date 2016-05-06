/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.cat062.item380.Item380Subfield23;
import jlg.jade.test.utils.BasicAsterixDataTestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield23Test implements BasicAsterixDataTestSuite {
    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield23 subfield = new Item380Subfield23();

        //assert
        assertEquals("Invalid subfield length", 2, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Item380Subfield23 subfield = new Item380Subfield23();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding of data", offset + 2, result);
    }

    @Test
    @Parameters({"1, 1, 257", "255, 1, -255"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet, int secondOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield23 subfield = new Item380Subfield23();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Geometric altitude not decoded correctly", expected, subfield.getGeometricAltitude());
    }

    @Test
    public void the_get_geometric_altitude_feet_method_should_convert_geometric_altitude_to_feet() {
        //arrange
        byte[] input = {0, 100};    // 100 * 6.25 = > 625 ft
        int offset = 0;
        Item380Subfield23 subfield = new Item380Subfield23();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(625, subfield.getGeometricAltitudeFeet());
    }

    @Test
    @Parameters({"250, 0, false", "0, 200, true", "127, 255, false"})
    public void the_validate_method_should_correctly_set_valid_flag(int firstOctet, int secondOctet, boolean expected) {
        /**
         * -1500 ft ≤ Altitude ≤ 150000 ft
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield23 subfield = new Item380Subfield23();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(expected, subfield.isValid());
    }
}
