/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield6;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Item380Subfield6Test {
    @Test
    public void should_have_length_of_2_bytes() {
        //arrange
        Item380Subfield6 subfield = new Item380Subfield6();

        //assert
        assertEquals("Subfield length is invalid", 2, subfield.getSizeInBytes());
    }

    @Test
    public void the_deocde_method_should_make_item_valid() {
        //arrange
        byte input[] = {1, 2};
        int offset = 0;
        Item380Subfield6 subfield = new Item380Subfield6();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());
    }

    @Test
    public void the_decode_method_should_increment_offset() {
        //arrange
        byte input[] = {1, 2};
        int offset = 0;
        Item380Subfield6 subfield = new Item380Subfield6();

        //act
        int newOffset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", 2, newOffset);
    }

}
