/**
 * Created by Dan Geabunea on 7/5/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item140;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item140Test extends MandatoryRepeatableAsterixTests<Cat150Item140> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 12;
    }

    @Override
    protected Cat150Item140 setRepeatableAsterixDataInstance() {
        return new Cat150Item140();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {2, 1, 49, 50, 51, 52, 53, 32, 32, 32, 32, 32, 32, 14, 65, 66, 67, 68, 69,
                70, 32, 32, 32, 32, 32};
        int offset = 0;
        Cat150Item140 cat150Item140 = new Cat150Item140();

        //act
        cat150Item140.decode(input, offset, input.length);

        //assert
        assertEquals("Repetition factor is not correct", 2, cat150Item140.getRepetitionFactor());

        assertEquals("RoutePoint1 type is not correct", 1,
                cat150Item140.getRoutePoints().get(0).getType());
        assertEquals("RoutePoint1 description is not correct", "12345",
                cat150Item140.getRoutePoints().get(0).getDescription());

        assertEquals("RoutePoint2 type is not correct", 14,
                cat150Item140.getRoutePoints().get(1).getType());
        assertEquals("RoutePoint2 description is not correct", "ABCDEF",
                cat150Item140.getRoutePoints().get(1).getDescription());
    }
}
