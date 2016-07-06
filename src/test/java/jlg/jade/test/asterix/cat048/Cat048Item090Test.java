/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item090;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item090Test extends MandatoryFixedLengthAsterixTests<Cat048Item090> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item090 setFixedLengthAsterixDataInstance() {
        return new Cat048Item090();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {2, 107};
        int offset = 0;
        Cat048Item090 item090 = new Cat048Item090();

        // act
        item090.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Flight level validated", true,
                     item090.getFlightLevelValidated());
        assertEquals("Item not decoded correctly - Flight level garbled", false,
                     item090.getFlightLevelGarbled());
        assertEquals("Item not decoded correctly - Flight level (feet)", 15475,
                     item090.getFlightLevelFeet());
    }
}
