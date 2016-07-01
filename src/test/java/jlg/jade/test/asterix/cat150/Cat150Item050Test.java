/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item050;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item050Test extends MandatoryFixedLengthAsterixTests<Cat150Item050> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Cat150Item050 setFixedLengthAsterixDataInstance() {
        return new Cat150Item050();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {65, 66, 67, 68, 69, 70, 32};
        int offset = 0;
        Cat150Item050 cat150Item050 = new Cat150Item050();

        //act
        cat150Item050.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", "ABCDEF", cat150Item050.getCallsign());
    }

}
