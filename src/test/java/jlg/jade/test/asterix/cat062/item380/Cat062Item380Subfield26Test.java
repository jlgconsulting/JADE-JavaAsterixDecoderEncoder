/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield26;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item380Subfield26Test extends MandatoryFixedLengthAsterixTests<Cat062Item380Subfield26> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item380Subfield26 setFixedLengthAsterixDataInstance() {
        return new Cat062Item380Subfield26();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {1, 8};
        int offset = 0;
        Cat062Item380Subfield26 subfield = new Cat062Item380Subfield26();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Indicated air speed not decoded correctly", 264, subfield.getIndicatedAirSpeed());
    }

    @Test
    @Parameters({"0,0,true", "4,76,true", "4,77,false"})
    public void the_validate_method_should_correctly_set_valid_flag(int firstOctet, int secondOctet, boolean expected) {
        /**
         * @implNote
         * Validation: 0 Kt ≤ Indicated Airspeed ≤ 1100 Kt
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item380Subfield26 subfield = new Cat062Item380Subfield26();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(expected, subfield.isValid());
    }

    /*
    Encoding test
     */

    @Test
    public void the_encode_method_should_produce_correct_byte_array() {
        //arrange
        int speed = 264;
        Cat062Item380Subfield26 cat062Item380Subfield26 = new Cat062Item380Subfield26();
        cat062Item380Subfield26.setIndicatedAirSpeed(speed);

        //act
        byte[] result = cat062Item380Subfield26.encode();

        //assert
        byte[] expected = {1, 8};
        assertTrue("Item380 - IAS not decoded correctly", Arrays.equals(expected, result));
        assertEquals(cat062Item380Subfield26.getSizeInBytes(), result.length);
    }
}
