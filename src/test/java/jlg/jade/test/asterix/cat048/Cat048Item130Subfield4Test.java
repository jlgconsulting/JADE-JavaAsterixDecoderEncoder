/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item130Subfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item130Subfield4Test extends MandatoryFixedLengthAsterixTests<Cat048Item130Subfield4> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item130Subfield4 setFixedLengthAsterixDataInstance() {
        return new Cat048Item130Subfield4();
    }

    @Test
    @Parameters({"255, 11.21", "23, 1.012", "0, 0"})
    public void the_decode_method_should_correctly_decode_data(int inputByte, double expected){
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item130Subfield4 item130Subfield4 = new Cat048Item130Subfield4();

        // act
        item130Subfield4.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - PRL", expected, item130Subfield4.getPlotRunlengthDegrees(), 0.01);
    }
}
