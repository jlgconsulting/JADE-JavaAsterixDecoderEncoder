/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item040;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item040Test extends MandatoryFixedLengthAsterixTests<Cat048Item040> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat048Item040 setFixedLengthAsterixDataInstance() {
        return new Cat048Item040();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {(byte) 131, 82, (byte) 189, 96};
        int offset = 0;
        Cat048Item040 item040 = new Cat048Item040();

        // act
        item040.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - RHO", 33618, item040.getRhoValue());
        assertEquals("Item not decoded correctly - THETA", 48480, item040.getThetaValue());
    }
}
