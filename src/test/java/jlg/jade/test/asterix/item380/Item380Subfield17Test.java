/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.cat062.item380.Item380Subfield17;
import jlg.jade.test.utils.BasicAsterixDataTestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Item380Subfield17Test implements BasicAsterixDataTestSuite {
    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield17 subfield = new Item380Subfield17();

        //assert
        assertEquals("Subfield length is not valid", 2, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Item380Subfield17 subfield = new Item380Subfield17();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", offset + 2, result);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {65, (byte) 224};
        int offset = 0;
        Item380Subfield17 subfield = new Item380Subfield17();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Track angle not decoded correctly", 16864, subfield.getTrackAngle());
    }
}
