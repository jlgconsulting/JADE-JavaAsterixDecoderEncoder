/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield11;
import jlg.jade.test.utils.BasicAsterixDataTestSuite;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Item380Subfield11Test implements BasicAsterixDataTestSuite {

    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield11 subfield = new Item380Subfield11();

        //assert
        assertEquals("Invalid item length", 2, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Item380Subfield11 subfield = new Item380Subfield11();

        //act
        int result = subfield.decode(input,offset,input.length);

        //assert
        assertEquals("Offset not incremented after decoding of data", 2, result);
    }

    @Test
    public void the_validate_method_should_correctly_set_valid_flag() {
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Item380Subfield11 subfield = new Item380Subfield11();

        //act
        subfield.decode(input,offset,input.length);

        //assert
        assertTrue(subfield.isValid());
    }
}

