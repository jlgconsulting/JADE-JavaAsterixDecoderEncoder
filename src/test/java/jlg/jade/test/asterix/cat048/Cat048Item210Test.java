/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item210;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item210Test extends MandatoryFixedLengthAsterixTests<Cat048Item210> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat048Item210 setFixedLengthAsterixDataInstance() {
        return new Cat048Item210();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {43, 79, (byte) 176, (byte) 231};
        int offset = 0;
        Cat048Item210 item210 = new Cat048Item210();

        // act
        item210.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Sigma (X)", 43, item210.getStdDevHorizontal());
        assertEquals("Item not decoded correctly - Sigma (Y)", 79, item210.getStdDevVertical());
        assertEquals("Item not decoded correctly - Sigma (V)", 176, item210.getStdDevGroundspeed());
        assertEquals("Item not decoded correctly - Sigma (H)", 231, item210.getStdDevHeading());

    }
}
