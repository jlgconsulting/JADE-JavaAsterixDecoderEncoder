/**
 * Created by Dan Geabunea on 6/29/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item010;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item010Test extends MandatoryFixedLengthAsterixTests<Cat150Item010> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat150Item010 setFixedLengthAsterixDataInstance() {
        return new Cat150Item010();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {1, 2};
        int offset = 0;
        Cat150Item010 item010 = new Cat150Item010();

        //act
        item010.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 1, item010.getCentreId());
        assertEquals("Item not decoded correctly", 2, item010.getWorkstationId());
    }
}
