/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.cat062.item380.Item380Subfield25;
import jlg.jade.test.utils.BasicRepeatableAsterixDataTestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item380Subfield25Test implements BasicRepeatableAsterixDataTestSuite {

    @Override
    @Test
    public void repeatable_block_size_should_be_correct() {
        //arrange
        Item380Subfield25 subfield = new Item380Subfield25();

        //assert
        assertEquals("Subfield has invalid rep block size", 8, subfield.getRepeatableBlockSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_calculate_correct_size() {
        //arrange
        byte[] inputWithTwoRepBlocks = {2, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8};
        int offset = 0;
        Item380Subfield25 subfield = new Item380Subfield25();

        //act
        subfield.decode(inputWithTwoRepBlocks, offset, inputWithTwoRepBlocks.length);

        //assert
        assertEquals("Repeatable subfield has invalid length", 17, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] inputWithTwoRepBlocks = {2, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8};
        int offset = 0;
        Item380Subfield25 subfield = new Item380Subfield25();

        //act
        int result = subfield.decode(inputWithTwoRepBlocks, offset, inputWithTwoRepBlocks.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 17, result);
    }
}
