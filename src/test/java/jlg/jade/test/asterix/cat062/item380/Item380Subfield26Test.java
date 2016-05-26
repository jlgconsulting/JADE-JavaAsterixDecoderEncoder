/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield26;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield26Test extends MandatoryFixedLengthAsterixTests<Item380Subfield26> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item380Subfield26 setFixedLengthAsterixDataInstance() {
        return new Item380Subfield26();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {1, 8};
        int offset = 0;
        Item380Subfield26 subfield = new Item380Subfield26();

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
        Item380Subfield26 subfield = new Item380Subfield26();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals(expected, subfield.isValid());
    }
}
