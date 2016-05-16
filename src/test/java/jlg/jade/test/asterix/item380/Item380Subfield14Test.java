/* 
* Created by dan-geabunea on 4/29/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield14;
import jlg.jade.test.utils.BasicAsterixDataTestSuite;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield14Test implements BasicAsterixDataTestSuite {
    @Override
    @Test
    public void should_have_length_correct_length() {
        //arrange
        Item380Subfield14 subfield = new Item380Subfield14();

        //assert
        assertEquals("Subfield length is invalid", 2, subfield.getSizeInBytes());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Item380Subfield14 subfield = new Item380Subfield14();

        //act
        int result = subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding data", 2, result);
    }

    @Test
    @Parameters({"0,10,10","255,255,-1"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet, int secondOctet, int expected){
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield14 subfield = new Item380Subfield14();

        //act
        subfield.decode(input, offset, input.length);
        assertEquals("Geometrical vertical rate not decoded correctly", expected, subfield.getGeometricVerticalRate());
    }

    @Test
    public void the_validate_method_should_always_set_valid_flag_to_true(){
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Item380Subfield14 subfield = new Item380Subfield14();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());


    }
}
