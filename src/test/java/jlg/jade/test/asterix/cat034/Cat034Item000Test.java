/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item000;
import jlg.jade.asterix.cat034.Cat034Item000MessageType;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034Item000Test extends MandatoryFixedLengthAsterixTests<Cat034Item000> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat034Item000 setFixedLengthAsterixDataInstance() {
        return new Cat034Item000();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {2};
        int offset = 0;
        Cat034Item000 cat034Item000 = new Cat034Item000();

        // act
        cat034Item000.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", Cat034Item000MessageType.SECTOR_CROSSING_MESSAGE,
                     cat034Item000.getMessageType());
    }
}
