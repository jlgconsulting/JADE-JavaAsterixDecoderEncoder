/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield9;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item380Subfield9Test {
    @Test
    public void should_have_repeatable_block_size_of_15_bytes() {
        //arrange
        Cat062Item380Subfield9 subfield = new Cat062Item380Subfield9();

        //assert
        assertEquals(15, subfield.getRepeatableBlockSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset() {
        //rep = 1, followed by one block of 15 octets
        byte[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int offset = 0;
        Cat062Item380Subfield9 subfield = new Cat062Item380Subfield9();

        //act
        int newOffset = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset was not incremented after decoding data", 16, newOffset);
    }


}
