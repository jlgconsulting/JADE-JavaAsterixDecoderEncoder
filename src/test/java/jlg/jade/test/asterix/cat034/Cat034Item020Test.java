/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item020;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034Item020Test extends MandatoryFixedLengthAsterixTests<Cat034Item020> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat034Item020 setFixedLengthAsterixDataInstance() {
        return new Cat034Item020();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {(byte) 168};
        int offset = 0;
        Cat034Item020 cat034Item020 = new Cat034Item020();
        // act
        cat034Item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 168, cat034Item020.getSectorNumber());
    }
}
