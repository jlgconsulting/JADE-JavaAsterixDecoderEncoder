/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item042;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item042Test extends MandatoryFixedLengthAsterixTests<Cat048Item042> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat048Item042 setFixedLengthAsterixDataInstance() {
        return new Cat048Item042();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {-47, 23, 51, 96};
        int offset = 0;
        Cat048Item042 item042 = new Cat048Item042();

        // act
        item042.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - X", -12009, item042.getX());
        assertEquals("Item not decoded correctly - Y", 13152, item042.getY());
    }
}
