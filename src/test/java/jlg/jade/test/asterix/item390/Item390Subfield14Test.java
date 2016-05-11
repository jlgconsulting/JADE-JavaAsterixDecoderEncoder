/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.cat062.item390.Item390Subfield14;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item390Subfield14Test extends MandatoryFixedLengthAsterixTests<Item390Subfield14> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item390Subfield14 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield14();
    }

    @Test
    @Parameters({"0,0", "64,1", "128,2", "192,3"})
    public void the_decode_method_should_correctly_decode_stand_emptiness(int octet, int expected) {
        //arrange
        byte[] input = {(byte) octet};
        int offset = 0;
        Item390Subfield14 subfield14 = new Item390Subfield14();

        //act
        subfield14.decode(input, offset, input.length);

        //assert
        assertEquals("Item 390 #14 - EMP Not decoded correctly", expected, subfield14.getStandEmptiness());
    }

    @Test
    @Parameters({"0,0", "16,1", "32,2", "48,3"})
    public void the_decode_method_should_correctly_decode_stand_availability(int octet, int expected) {
        //arrange
        byte[] input = {(byte) octet};
        int offset = 0;
        Item390Subfield14 subfield14 = new Item390Subfield14();

        //act
        subfield14.decode(input, offset, input.length);

        //assert
        assertEquals("Item 390 #14 - AVL Not decoded correctly", expected, subfield14.getStandAvailability());
    }
}
