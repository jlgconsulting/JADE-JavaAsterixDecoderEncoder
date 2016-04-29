/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.cat062.item380.Item380Subfield12;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Item380Subfield12Test implements BasicAsterixDataTestSuite {
    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield12 subfield = new Item380Subfield12();

        //act
        assertEquals("Subfield length is invalid", 7, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {0, 1, 2, 3, 4, 5, 6};
        int offset = 0;
        Item380Subfield12 subfield = new Item380Subfield12();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 7, result);
    }

    @Test
    public void the_validate_method_should_correctly_set_valid_flag() {
        //arrange
        byte[] input = {0, 1, 2, 3, 4, 5, 6};
        int offset = 0;
        Item380Subfield12 subfield = new Item380Subfield12();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());
    }
}
