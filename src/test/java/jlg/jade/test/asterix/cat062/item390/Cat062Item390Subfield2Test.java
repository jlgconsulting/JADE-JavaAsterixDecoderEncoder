/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Cat062Item390Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item390Subfield2Test extends MandatoryFixedLengthAsterixTests<Cat062Item390Subfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Cat062Item390Subfield2 setFixedLengthAsterixDataInstance() {
        return new Cat062Item390Subfield2();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {77, 65, 83, 49, 32, 32, 32};    // "MAS1   "
        int offset = 0;
        Cat062Item390Subfield2 subfield2 = new Cat062Item390Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("I062/390 #2 not decoded correctly", "MAS1", subfield2.getCallsign());
    }
}
