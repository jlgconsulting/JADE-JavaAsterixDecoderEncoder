/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item220;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item220Test extends MandatoryFixedLengthAsterixTests<Cat150Item220> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat150Item220 setFixedLengthAsterixDataInstance() {
        return new Cat150Item220();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        //arrange
        byte[] input = {(byte) 130, 2};
        int offset = 0;
        Cat150Item220 cat150Item220 = new Cat150Item220();

        //act
        cat150Item220.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 33282, cat150Item220.getMaxPlanCount());
    }
}
