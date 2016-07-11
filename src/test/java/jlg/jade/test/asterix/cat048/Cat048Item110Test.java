/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item110;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item110Test extends MandatoryFixedLengthAsterixTests<Cat048Item110> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item110 setFixedLengthAsterixDataInstance() {
        return new Cat048Item110();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {43, (byte) 244};
        int offset = 0;
        Cat048Item110 item110 = new Cat048Item110();

        // act
        item110.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - 3DRadarMeasuredHeight", 11252,
                     item110.getMeasuredHeight3DRadar());
    }
}
