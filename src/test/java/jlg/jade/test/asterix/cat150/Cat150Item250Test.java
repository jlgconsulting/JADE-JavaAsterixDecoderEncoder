/**
 * Created by Dan Geabunea on 7/8/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item250;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item250Test extends MandatoryRepeatableAsterixTests<Cat150Item250> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat150Item250 setRepeatableAsterixDataInstance() {
        return new Cat150Item250();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {2, 0, 1, 1, 2};
        int offset = 0;
        Cat150Item250 cat150Item250 = new Cat150Item250();

        //act
        cat150Item250.decode(input, offset, input.length);

        //assert
        assertEquals("Repetition factor is not correct", 2, cat150Item250.getRepetitionFactor());
        assertEquals("Item 1 not decoded correctly", 1,
                cat150Item250.getDecorrelatedPlans().get(0).intValue());
        assertEquals("Item 2 not decoded correctly", 258,
                cat150Item250.getDecorrelatedPlans().get(1).intValue());
    }
}
