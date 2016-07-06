/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item070;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item070Test extends MandatoryFixedLengthAsterixTests<Cat048Item070> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item070 setFixedLengthAsterixDataInstance() {
        return new Cat048Item070();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {43, 1};
        int offset = 0;
        Cat048Item070 item070 = new Cat048Item070();

        // act
        item070.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Mode3A Validated", true,
                     item070.getMode3AValidated());
        assertEquals("Item not decoded correctly - Mode3A Garbled", false,
                     item070.getMode3AGarbled());
        assertEquals("Item not decoded correctly - Mode3A Deduction", 1,
                     item070.getMode3ADeduction());
        assertEquals("Item not decoded correctly - Mode3A Reply", 2817, item070.getMode3AReply());
    }

    @Test
    @Parameters({"43, 1, 2817, 5401", "160, 208, 208, 0320", "0, 42, 42, 0052", "64, 1, 1, 0001"})
    public void the_decode_method_should_correctly_decode_mode3a_reply_field(int firstByte,
                                                                             int secondByte,
                                                                             int expectedDecimal,
                                                                             String expectedOctal) {
        // arrange
        byte[] input = {(byte) firstByte, (byte) secondByte};
        int offset = 0;
        Cat048Item070 item070 = new Cat048Item070();

        // act
        item070.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Mode3A reply (decimal)", expectedDecimal,
                     item070.getMode3AReply());
        assertEquals("Item not decoded correctly - Mode3A reply (octal)", expectedOctal,
                     item070.getMode3AReplyOctal());

    }
}
