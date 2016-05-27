/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield4;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Item380Subfield4Test {
    @Test
    public void should_have_length_of_2_bytes(){
        //arrange
        Item380Subfield4 subfield = new Item380Subfield4();

        //assert
        assertEquals("Invalid subfield length", 2, subfield.getSizeInBytes());
    }

    @Test
    public void should_always_be_valid(){
        //arrange
        Item380Subfield4 subfield = new Item380Subfield4();

        //assert
        assertTrue(subfield.isValid());
    }

    @Test
    public void the_decode_method_should_increment_offset(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Item380Subfield4 subfield = new Item380Subfield4();

        //act
        int newOffset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", 2, newOffset);
    }
}
