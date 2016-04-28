/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.cat062.item380.Item380Subfield7;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield7Test {
    @Test
    public void should_have_length_of_2_bytes() {
        //arrange
        Item380Subfield7 subfield = new Item380Subfield7();

        //assert
        assertEquals("Invalid sibfield length", 2, subfield.getSizeInBytes());
    }

    @Test
    @Parameters({"128,true", "1,false"})
    public void the_decode_method_should_correctly_decocde_mv_data(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("MV data not decoded correctly", expected, subfield.isManageVerticalModeActive());
    }

    @Test
    @Parameters({"64,true", "1,false"})
    public void the_decode_method_should_correctly_decocde_ah_data(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("AH data not decoded correctly", expected, subfield.isAltitudeHoldActive());
    }

    @Test
    @Parameters({"32,true", "1,false"})
    public void the_decode_method_should_correctly_decocde_am_data(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("AM data not decoded correctly", expected, subfield.isApproachModeActive());
    }

    @Test
    @Parameters({"224,100,100", "5,80,1360"})
    public void the_decode_method_should_correctly_decocde_altitude_data(int firstOctet, int secondOctet, int
            expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Altitude data not decoded correctly", expected, subfield.getSelectedAltitude());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        int newOffset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 2, newOffset);
    }

    @Test
    public void the_decode_method_when_altitude_in_ft_gt_100000_should_valid_flag_to_false() {
        //arrange
        byte[] input = {15, (byte) 161};   // corresponds to 4001 in decimal => altitude > 4000 * 25 ft
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Valid flag not set to false when altitude greater than 100000ft", false, subfield.isValid());
    }

    @Test
    public void the_decode_method_when_altitude_in_ft_less_than_100000_should_valid_flag_to_false() {
        //arrange
        byte[] input = {15, (byte) 159};   // less than 100000 ft
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Valid flag not set to true when altitude less than 100000ft", true, subfield.isValid());
    }

    @Test
    public void the_get_selected_altitude_in_ft_should_convert_selected_altitude_to_ft() {
        //arrange
        byte[] input = {0, 1};
        int offset = 0;
        Item380Subfield7 subfield = new Item380Subfield7();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        int expected = 1 * 25;
        assertEquals(expected, subfield.getSelectedAltitudeInFeet());
    }

}
