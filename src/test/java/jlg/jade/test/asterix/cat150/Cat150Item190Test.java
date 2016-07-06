/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item190;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item190Test extends MandatoryFixedLengthAsterixTests<Cat150Item190> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat150Item190 setFixedLengthAsterixDataInstance() {
        return new Cat150Item190();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {32, 65};
        int offset = 0;
        Cat150Item190 cat150Item190 = new Cat150Item190();

        //act
        cat150Item190.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", "A", cat150Item190.getControllerId());
    }
}
