/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.cat062.item380.Item380Subfield1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Item380Subfield1Test {

    @Test
    public void should_have_length_of_3_bytes(){
        //arrange
        Item380Subfield1 subfield = new Item380Subfield1();

        //assert
        assertEquals("Subfield length is not valid", 3, subfield.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_correclty_decode_data(){
        //arrange
        byte[] input = {75, (byte) 170, 104};
        int offset = 0;
        Item380Subfield1 subfield = new Item380Subfield1();


        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", "75170104", subfield.getTargetAddress());
        assertTrue(subfield.isValid());
    }

    @Test
    public void the_decode_method_should_increase_offset_after_decoding_data(){
        //arrange
        byte[] input = {75, (byte) 170, 104};
        int offset = 0;
        Item380Subfield1 subfield = new Item380Subfield1();


        //act
        int newOffset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", 3, newOffset);
    }
}
