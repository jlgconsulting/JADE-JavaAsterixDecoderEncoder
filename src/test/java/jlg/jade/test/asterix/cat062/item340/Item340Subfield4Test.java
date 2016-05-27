/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item340;

import jlg.jade.asterix.cat062.item340.Item340Subfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item340Subfield4Test extends MandatoryFixedLengthAsterixTests<Item340Subfield4> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item340Subfield4 setFixedLengthAsterixDataInstance() {
        return new Item340Subfield4();
    }

    @Test
    @Parameters({"128, true", "127,false"})
    public void the_decode_method_should_correctly_decode_the_validation_info(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item340Subfield4 subfield4 = new Item340Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        ///assert
        assertEquals("Subfield not decoded correctly (code validation)", expected, subfield4.getCodeValidation());
    }

    @Test
    @Parameters({"64, true", "63,false"})
    public void the_decode_method_should_correctly_decode_the_grabled_info(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item340Subfield4 subfield4 = new Item340Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        ///assert
        assertEquals("Subfield not decoded correctly (garbled validation)", expected, subfield4.isCodeGarbled());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {5, (byte) 200};
        int offset = 0;
        Item340Subfield4 subfield4 = new Item340Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("Subfiled not decoded correctly (last mode c)", 1480, subfield4.getLastMeasuredModeC());
    }

    @Test
    @Parameters({"32,208,true", "32,207,false", "19,216,true", "19,217,false"})
    public void the_validate_method_should_correctly_set_valid_flag(int firstOctet, int secondOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item340Subfield4 subfield4 = new Item340Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield validation not correct", expected, subfield4.isValid());
    }
}
