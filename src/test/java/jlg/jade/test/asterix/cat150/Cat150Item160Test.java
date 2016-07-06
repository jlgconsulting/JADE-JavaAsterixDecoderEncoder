/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item160;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Cat150Item160Test extends MandatoryRepeatableAsterixTests<Cat150Item160> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item160 setRepeatableAsterixDataInstance() {
        return new Cat150Item160();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {2, 48, 48, 49, 52, 50, 51, 48, 57};
        int offset = 0;
        Cat150Item160 cat150Item160 = new Cat150Item160();

        //act
        cat150Item160.decode(input, offset, input.length);

        //assert
        assertEquals("Repetition factor is not correct", 2, cat150Item160.getRepetitionFactor());
        assertEquals("Route point 1 not decoded correctly", "00",
                cat150Item160.getRoutePoints().get(0).getHoursString());
        assertEquals("Route point 1 not decoded correctly", "14",
                cat150Item160.getRoutePoints().get(0).getMinutesString());
        assertEquals("Route point 2 not decoded correctly", "23",
                cat150Item160.getRoutePoints().get(1).getHoursString());
        assertEquals("Route point 2 not decoded correctly", "09",
                cat150Item160.getRoutePoints().get(1).getMinutesString());
        assertEquals("Validity not correct", true, cat150Item160.isValid());
    }

    @Test
    public void the_validate_method_if_time_is_outside_range_should_set_valid_flag_to_false() {
        //arrange
        byte[] input = {2, 66, 0, 0, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat150Item160 cat150Item160 = new Cat150Item160();

        //act
        cat150Item160.decode(input, offset, input.length);

        //assert
        assertFalse("Valid flag not set correctly", cat150Item160.isValid());
    }
}
