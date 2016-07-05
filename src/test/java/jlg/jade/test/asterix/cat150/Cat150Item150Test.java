/**
 * Created by Dan Geabunea on 7/5/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item150;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item150Test extends MandatoryRepeatableAsterixTests<Cat150Item150> {

    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item150 setRepeatableAsterixDataInstance() {
        return new Cat150Item150();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {2, 1, 1, 2, 2, 0, 0, 0, 1};
        int offset = 0;
        Cat150Item150 cat150Item150 = new Cat150Item150();

        //act
        cat150Item150.decode(input, offset, input.length);

        //assert
        assertEquals("Repetition factor is not correct", 2, cat150Item150.getRepetitionFactor());
        assertEquals("Rpute point 1 not decoded correctly",
                257, cat150Item150.getRoutePoints().get(0).getX());
        assertEquals("Rpute point 1 not decoded correctly",
                514, cat150Item150.getRoutePoints().get(0).getY());

        assertEquals("Rpute point 2 not decoded correctly",
                0, cat150Item150.getRoutePoints().get(1).getX());
        assertEquals("Rpute point 2 not decoded correctly",
                1, cat150Item150.getRoutePoints().get(1).getY());
    }
}
