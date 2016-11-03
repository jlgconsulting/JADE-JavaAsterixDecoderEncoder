/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield10;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item380Subfield10Test {
    @Test
    public void should_havle_length_of_2_bytes(){
        //arrange
        Cat062Item380Subfield10 subfield = new Cat062Item380Subfield10();

        //assert
        assertEquals("Invalid subfield length", 2, subfield.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat062Item380Subfield10 subfield = new Cat062Item380Subfield10();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", 2, result);
    }

    @Test
    public void the_decode_method_should_set_valid_flag_to_true(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat062Item380Subfield10 subfield = new Cat062Item380Subfield10();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());
    }

    @Test
    public void the_decode_method_should_correctly_decode_bds_register_10_bits() {
        // arrange
        byte[] input = {23, (byte) 255};
        int offset = 0;
        Cat062Item380Subfield10 subfield10 = new Cat062Item380Subfield10();

        // act
        subfield10.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - BDS 1,0 bit 16", 1, subfield10.getBDS10Bit16());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 37", 1, subfield10.getBDS10Bit37());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 38", 1, subfield10.getBDS10Bit38());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 39", 1, subfield10.getBDS10Bit39());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 40", 1, subfield10.getBDS10Bit40());
    }
}
