/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.test.asterix.cat004.item120;

import jlg.jade.asterix.cat004.item120.Cat004Item120Subfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Cat004Item120Subfield3Test extends
        MandatoryFixedLengthAsterixTests<Cat004Item120Subfield3> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat004Item120Subfield3 setFixedLengthAsterixDataInstance() {
        return new Cat004Item120Subfield3();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {50};
        int offset = 0;
        Cat004Item120Subfield3 subfield3 = new Cat004Item120Subfield3();

        //act
        subfield3.decode(input, offset, input.length);

        //assert
        assertEquals("Conflict probability is not decoded correctly", 50, subfield3
                .getProbability());
        assertEquals("Conflict probability percent is not decoded correctly", 25, subfield3
                .getProbabilityPercent());
        assertTrue(subfield3.isValid());
    }

    @Test
    public void the_decode_method_should_set_valid_flag_to_false_if_percentage_greater_than_100() {
        //arrange
        byte[] input = {(byte) 201};
        int offset = 0;
        Cat004Item120Subfield3 subfield3 = new Cat004Item120Subfield3();

        //act
        subfield3.decode(input, offset, input.length);

        //assert
        assertFalse("PErcentage can not be higher than 100", subfield3.isValid());
    }
}
