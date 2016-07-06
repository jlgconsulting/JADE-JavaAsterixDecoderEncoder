/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item171;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Cat150Item171Test extends MandatoryRepeatableAsterixTests<Cat150Item171> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat150Item171 setRepeatableAsterixDataInstance() {
        return new Cat150Item171();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {2, 48, 49, 48, 51, 48, 48};
        int offset = 0;
        Cat150Item171 cat150Item171 = new Cat150Item171();

        //act
        cat150Item171.decode(input, offset, input.length);

        //assert
        assertEquals("Repetition counter not correct", 2, cat150Item171.getRepetitionFactor());
        assertEquals("Route point 1 not decoded correctly", 10,
                cat150Item171.getRoutePoints().get(0).getFlightLevel());
        assertEquals("Route point 1 not decoded correctly", 300,
                cat150Item171.getRoutePoints().get(1).getFlightLevel());
        assertTrue(cat150Item171.isValid());
    }

    @Test
    public void the_decode_method_when_data_not_numeric_should_set_valid_flag_to_false() {
        //arrange
        byte[] input = {2, 0, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat150Item171 cat150Item171 = new Cat150Item171();

        //act
        cat150Item171.decode(input, offset, input.length);

        //assert
        assertFalse("Validation decoding is not correct", cat150Item171.isValid());
    }
}
