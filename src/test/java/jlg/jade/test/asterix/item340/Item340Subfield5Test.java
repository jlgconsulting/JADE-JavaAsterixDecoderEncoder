/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item340;

import jlg.jade.cat062.item340.Item340Subfield5;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item340Subfield5Test extends MandatoryFixedLengthAsterixTests<Item340Subfield5> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item340Subfield5 setFixedLengthAsterixDataInstance() {
        return new Item340Subfield5();
    }

    @Test
    @Parameters({"128,true", "127,false"})
    public void the_decode_method_should_correctly_decode_mode_a_validation(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item340Subfield5 subfield5 = new Item340Subfield5();

        //act
        subfield5.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly (mode a validation)", expected, subfield5.getCodeValidation());
    }

    @Test
    @Parameters({"64,true", "63,false"})
    public void the_decode_method_should_correctly_decode_mode_a_garbled(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item340Subfield5 subfield5 = new Item340Subfield5();

        //act
        subfield5.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly (mode a garbled)", expected, subfield5.getCodeGarbled());
    }

    @Test
    @Parameters({"32,true", "31,false"})
    public void the_decode_method_should_correctly_decode_mode_a_smoothed(int firstOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, 0};
        int offset = 0;
        Item340Subfield5 subfield5 = new Item340Subfield5();

        //act
        subfield5.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly (mode a smoothed)", expected, subfield5.isSmoothed());
    }

    @Test
    public void the_decode_method_should_correctly_decode_last_measured_mode_a(){
        //arrange
        byte[] input = {9, (byte) 221};
        int offset = 0;
        Item340Subfield5 subfield5 = new Item340Subfield5();

        //act
        subfield5.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly (mode a)", 2525, subfield5.getLastMeasuredModeACode());
    }
}
