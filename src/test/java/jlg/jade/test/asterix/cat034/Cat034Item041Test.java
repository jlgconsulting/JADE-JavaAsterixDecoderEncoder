/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item041;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034Item041Test extends MandatoryFixedLengthAsterixTests<Cat034Item041> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat034Item041 setFixedLengthAsterixDataInstance() {
        return new Cat034Item041();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {1, 2};
        int offset = 0;
        Cat034Item041 cat034Item041 = new Cat034Item041();

        // act
        cat034Item041.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 258, cat034Item041.getAntennaRotationSpeed());
    }
}
