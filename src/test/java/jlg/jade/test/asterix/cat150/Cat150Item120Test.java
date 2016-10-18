/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item120;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Cat150Item120Test extends MandatoryFixedLengthAsterixTests<Cat150Item120> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Cat150Item120 setFixedLengthAsterixDataInstance() {
        return new Cat150Item120();
    }

    @Test
    public void the_decode_Method_should_correctly_decode_data() {
        //arrange
        byte[] input = {54, 53, 67, 68, 69, 70, 65};
        int offset = 0;
        Cat150Item120 cat150Item120 = new Cat150Item120();

        //act
        cat150Item120.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly - nb aircraft", 65,
                cat150Item120.getNumberOfAircraft());
        assertEquals("Item not decoded correctly - aircraft type", "CDEF",
                cat150Item120.getTypeOfAircraft());
        assertEquals("Item not decoded correctly", "A", cat150Item120.getWakeTurbulence());
    }

    @Test
    public void when_wake_turbulence_is_zero_the_decode_method_should() {
        //arrange
        byte[] input = {48, 48, 65, 51, 56, 56, 0};
        int offset = 0;
        Cat150Item120 cat150Item120 = new Cat150Item120();

        //act
        cat150Item120.decode(input, offset, input.length);

        //assert
        assertNull("Item not decoded correctly", cat150Item120.getWakeTurbulence());
    }

    /**
     * We need to override this test because the input data needs to be very specific. We need a
     * numeric string on the first 2 characters and the generic test method does not provide this.
     */
    @Override
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {54, 53, 67, 68, 69, 70, 65};
        int offset = 0;
        Cat150Item120 cat150Item120 = new Cat150Item120();

        //act
        int result = cat150Item120.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", input.length, result);
    }
}
