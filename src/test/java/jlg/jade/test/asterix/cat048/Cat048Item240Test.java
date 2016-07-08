/**
 * Created by alexandru on 7/7/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item240;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item240Test extends MandatoryFixedLengthAsterixTests<Cat048Item240> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 6;
    }

    @Override
    protected Cat048Item240 setFixedLengthAsterixDataInstance() {
        return new Cat048Item240();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {57, 5, 52, (byte) 203, 8, 32};
        int offset = 0;
        Cat048Item240 item240 = new Cat048Item240();

        // act
        item240.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Aircraft Identification", "NPT420",
                     item240.getAircraftIdentification());
    }
}
