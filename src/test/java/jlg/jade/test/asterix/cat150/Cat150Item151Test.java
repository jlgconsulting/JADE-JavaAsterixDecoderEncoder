/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item151;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item151Test extends MandatoryRepeatableAsterixTests<Cat150Item151> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 6;
    }

    @Override
    protected Cat150Item151 setRepeatableAsterixDataInstance() {
        return new Cat150Item151();
    }

    @Test
    public void decode_method_should_correclty_decode_data() {
        //arrange
        byte[] input = {2, 0, 1, 2, 1, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 1};
        int offset = 0;
        Cat150Item151 cat150Item151 = new Cat150Item151();

        //act
        cat150Item151.decode(input, offset, input.length);

        //assert
        assertEquals("Repetition factor not decoded correctly", 2,
                cat150Item151.getRepetitionFactor());

        assertEquals("Route point 1 not decoded correctly", 258,
                cat150Item151.getRoutePoints().get(0).getLatitude());
        assertEquals("Route point 1 not decoded correctly", 256 * 256,
                cat150Item151.getRoutePoints().get(0).getLongitude());

        assertEquals("Route point 2 not decoded correctly", -256 * 256,
                cat150Item151.getRoutePoints().get(1).getLatitude());
        assertEquals("Route point 2 not decoded correctly", -256 * 256 + 1,
                cat150Item151.getRoutePoints().get(1).getLongitude());
    }
}
