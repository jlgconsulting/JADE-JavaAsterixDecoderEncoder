/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item040;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item040Test extends MandatoryFixedLengthAsterixTests<Cat150Item040> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat150Item040 setFixedLengthAsterixDataInstance() {
        return new Cat150Item040();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Cat150Item040 cat150Item040 = new Cat150Item040();

        //act
        cat150Item040.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 258, cat150Item040.getPlanNumber());
    }
}
