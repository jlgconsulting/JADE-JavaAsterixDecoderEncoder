/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield8;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Item380Subfield8Test {
    @Test
    public void the_decode_method_should_always_set_valid_flag_to_true(){
        //arrange
        byte[] input = {2}; //0000 0010
        int offset = 0;
        Item380Subfield8 subfield = new Item380Subfield8();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());
    }

    @Test
    public void the_decode_method_should_increment_offset(){
            //arrange
            byte[] input = {2}; //0000 0010 (FX is 0 -> length is 1 octet)
            int offset = 0;
            Item380Subfield8 subfield = new Item380Subfield8();

            //act
            int newOffset = subfield.decode(input, offset, input.length);

            //assert
            assertEquals("Offset not incremented after decoding data", 1, newOffset);
    }
}
