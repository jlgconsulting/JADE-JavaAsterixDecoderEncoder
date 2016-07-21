/**
 * Created by alexandru on 7/14/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item260;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Cat048Item260Test extends MandatoryFixedLengthAsterixTests<Cat048Item260> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Cat048Item260 setFixedLengthAsterixDataInstance() {
        return new Cat048Item260();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TTI", 0, item260.getThreatTypeIndicator());
    }
}
