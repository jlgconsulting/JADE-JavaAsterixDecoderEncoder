/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Item380Subfield3Test {
    @Test
    public void should_have_length_of_2_bytes(){
        //arrange
        Item380Subfield3 subfield = new Item380Subfield3();

        //assert
        assertEquals("Subfield length invalid", 2, subfield.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {(byte) 216, 64};
        int offset = 0;
        Item380Subfield3 subfield = new Item380Subfield3();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly", 55360, subfield.getMagneticHeading());
        assertTrue(subfield.isValid());
    }

    @Test
    public void the_decode_method_should_increment_offset(){
        //arrange
        byte[] input = {(byte) 216, 64};
        int offset = 0;
        Item380Subfield3 subfield = new Item380Subfield3();

        //act
        int newOffset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset was not incremented after decoding data", 2, newOffset);
    }

    @Test
    public void the_get_heading_degrees_method_should_return_magnetic_heading_in_degrees(){
        //arrange
        byte[] input = {(byte) 216, 64};
        int offset = 0;
        Item380Subfield3 subfield = new Item380Subfield3();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Magnetic heading degrees is not correct", 304, subfield.getMagneticHeadingDegrees());
    }

}
