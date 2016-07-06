/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item240;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item240Test extends MandatoryRepeatableAsterixTests<Cat150Item240> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item240 setRepeatableAsterixDataInstance() {
        return new Cat150Item240();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {2, 1, 1, 1, 1, 0, 1, 0, 1};
        int offset = 0;
        Cat150Item240 cat150Item240 = new Cat150Item240();

        //act
        cat150Item240.decode(input, offset, input.length);

        //assert
        assertEquals("Rpeetition factor not correct", 2, cat150Item240.getRepetitionFactor());

        assertEquals("Item not decoded correctly", 257,
                cat150Item240.getCorrelations().get(0).getPlanNumber());
        assertEquals("Item not decoded correctly", 257,
                cat150Item240.getCorrelations().get(0).getTrackNumber());
        assertEquals("Item not decoded correctly", 1,
                cat150Item240.getCorrelations().get(1).getPlanNumber());
        assertEquals("Item not decoded correctly", 1,
                cat150Item240.getCorrelations().get(1).getTrackNumber());
    }
}
