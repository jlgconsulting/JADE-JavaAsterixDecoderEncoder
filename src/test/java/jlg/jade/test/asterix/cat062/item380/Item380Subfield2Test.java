/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Item380Subfield2Test {
    @Test
    public void should_have_length_of_6_bytes() {
        //arrange
        Item380Subfield2 subfield = new Item380Subfield2();

        //assert
        assertEquals("Subfield length is not valid", 6, subfield.getSizeInBytes());
    }


    @Test
    public void the_decode_method_should_increment_offset() {
        //arrange
        Item380Subfield2 subfield = new Item380Subfield2();
        byte[] input = {80, (byte) 134, 120, 57, 88, 32};
        int offset = 0;

        //act
        int newOffsset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", 6, newOffsset);
    }

    @Test
    public void the_decode_method_should_produce_valid_result() {
        //arrange
        Item380Subfield2 subfield = new Item380Subfield2();
        byte[] input = {80, (byte) 134, 120, 57, 88, 32};
        int offset = 0;

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());
    }
}
