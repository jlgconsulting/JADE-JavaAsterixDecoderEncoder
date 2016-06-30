/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item030;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034Item030Test extends MandatoryFixedLengthAsterixTests<Cat034Item030> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat034Item030 setFixedLengthAsterixDataInstance() {
        return new Cat034Item030();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {0, (byte) 149, (byte) 237};
        int offset = 0;
        Cat034Item030 cat034Item030 = new Cat034Item030();

        // act
        cat034Item030.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 38381, cat034Item030.getTime());
    }
}
