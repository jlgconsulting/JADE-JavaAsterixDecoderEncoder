/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item161;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Cat048Item161Test extends MandatoryFixedLengthAsterixTests<Cat048Item161> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item161 setFixedLengthAsterixDataInstance() {
        return new Cat048Item161();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {3, 16};
        int offset = 0;
        Cat048Item161 item161 = new Cat048Item161();

        // act
        item161.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Track number", 784, item161.getTrackNumber());
    }

    @Test
    public void the_valid_flag_should_be_set_to_false_for_invalid_data() {
        // arrange
        byte[] input = {16, (byte) 255};
        int offset = 0;
        Cat048Item161 item161 = new Cat048Item161();

        // act
        item161.decode(input, offset, input.length);

        // assert
        assertFalse("Item should be invalid for provided input.", item161.isValid());
    }
}
