/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield27;
import jlg.jade.test.utils.BasicAsterixDataTestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield27Test implements BasicAsterixDataTestSuite {
    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield27 subfield = new Item380Subfield27();

        //assert
        assertEquals("Subfield length is not valid", 2, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {0, 98};
        int offset = 0;
        Item380Subfield27 subfield = new Item380Subfield27();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", offset + 2, result);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {0, 98};
        int offset = 0;
        Item380Subfield27 subfield = new Item380Subfield27();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Mach number not decoded correctly", 98, subfield.getMachNumber());
    }

    @Test
    public void the_get_mach_speed_should_convert_asterix_mach_number_to_real_mach_speed() {
        //arrange
        byte[] input = {0, 98};
        int offset = 0;
        Item380Subfield27 subfield = new Item380Subfield27();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(0.784, subfield.getMachSpeed(), 0.001);
    }

    @Test
    @Parameters({"0,98,true", "16,0,true", "16,1,false"})
    public void the_validate_method_should_correctly_set_valid_flag(int firstOctet, int secondOctet, boolean expected) {
        /**
         * @implNote
         * 0 ≤ Mach Number ≤ 4.096
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield27 subfield = new Item380Subfield27();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(expected, subfield.isValid());
    }
}
