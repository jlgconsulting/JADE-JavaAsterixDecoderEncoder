/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Cat062Item390Subfield5;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item390Subfield5Test extends MandatoryFixedLengthAsterixTests<Cat062Item390Subfield5> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat062Item390Subfield5 setFixedLengthAsterixDataInstance() {
        return new Cat062Item390Subfield5();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {65, 51, 56, 56};
        int offset = 0;
        Cat062Item390Subfield5 cat062Item390Subfield5 = new Cat062Item390Subfield5();

        //act
        cat062Item390Subfield5.decode(input, offset, input.length);

        //assert
        assertEquals("Item390 #5 nod decoded correctly", "A388", cat062Item390Subfield5.getTypeOfAircraft());
    }

    @Test
    public void the_encode_method_should_produce_correct_byte_array(){
        //arrange
        String aircraftType = "A388";
        Cat062Item390Subfield5 cat062Item390Subfield5 = new Cat062Item390Subfield5();
        cat062Item390Subfield5.setTypeOfAircraft(aircraftType);

        //act
        byte[] result = cat062Item390Subfield5.encode();

        //assert
        byte[] expected = {65, 51, 56, 56};
        assertTrue("Cat062Item390Subfield5 not encoded correctly", Arrays.equals(expected, result));
        assertEquals(cat062Item390Subfield5.getSizeInBytes(), result.length);
    }
}
