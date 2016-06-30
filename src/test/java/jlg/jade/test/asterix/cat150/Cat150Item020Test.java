/**
 * Created by Dan Geabunea on 6/30/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item020;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item020Test extends MandatoryFixedLengthAsterixTests<Cat150Item020> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat150Item020 setFixedLengthAsterixDataInstance() {
        return new Cat150Item020();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat150Item020 item020 = new Cat150Item020();

        //act
        item020.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 1, item020.getCentreId());
        assertEquals("Item not decoded correctly", 2, item020.getWorkstationId());
    }
}
