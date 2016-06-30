package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item010;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034Item010Test extends MandatoryFixedLengthAsterixTests<Cat034Item010> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat034Item010 setFixedLengthAsterixDataInstance() {
        return new Cat034Item010();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {52, (byte) 156};
        int offset = 0;
        Cat034Item010 cat034Item010 = new Cat034Item010();

        // act
        cat034Item010.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 52, cat034Item010.getSac());
        assertEquals("Item not decoded correctly", 156, cat034Item010.getSic());
    }
}
