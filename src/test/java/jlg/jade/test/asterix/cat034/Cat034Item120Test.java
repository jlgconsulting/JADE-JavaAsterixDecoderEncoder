/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item120;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnitParamsRunner.class)
public class Cat034Item120Test extends MandatoryFixedLengthAsterixTests<Cat034Item120> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 8;
    }

    @Override
    protected Cat034Item120 setFixedLengthAsterixDataInstance() {
        return new Cat034Item120();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {2, 127, 1, 1, 1, 1, 1, 0};
        int offset = 0;
        Cat034Item120 item120 = new Cat034Item120();

        // act
        item120.decode(input, offset, input.length);

        // assert
        assertEquals("Height information not decoded correctly", 639, item120.getHeightWgs84());
        assertEquals("Latitude information not decoded correctly", 65793, item120.getLatitudeWgs84());
        assertEquals("Longitude information not decoded correctly", 65792, item120.getLongitudeWgs84());
        assertTrue(item120.isValid());
    }

    /**
     * The parameter values represent items outside the valid range (-90, 90) for latitude:
     * -65, 1, 1 should decode to -91
     * 65, 1, 1 should decode to 91
     */
    @Test
    @Parameters({"-65, 1, 1", "65, 1, 1"})
    public void when_latitude_outside_valid_range_is_valid_flag_should_be_set_to_false(int firstOctet, int secondOctet, int thirdOctet){
        // arrange
        byte[] input = {0, 1, (byte) firstOctet, (byte) secondOctet, (byte) thirdOctet, 1, 1, 0};
        int offset = 0;
        Cat034Item120 item120 = new Cat034Item120();

        // act
        item120.decode(input, offset, input.length);

        // assert
        assertFalse(item120.isValid());
    }
}
