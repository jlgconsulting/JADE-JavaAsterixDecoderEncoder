/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item200;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item200Test extends MandatoryFixedLengthAsterixTests<Cat048Item200> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat048Item200 setFixedLengthAsterixDataInstance() {
        return new Cat048Item200();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {3, (byte) 227, (byte) 223, (byte) 164};
        int offset = 0;
        Cat048Item200 item200 = new Cat048Item200();

        // act
        item200.decode(input, offset, input.length);

        // arrange
        assertEquals("Item not decoded correctly - Calculated ground speed", 995,
                     item200.getCalculatedGroundSpeed());
        assertEquals("Item not decoded correctly - Calculated ground speed", 57252,
                     item200.getCalculatedHeading());
    }
}
