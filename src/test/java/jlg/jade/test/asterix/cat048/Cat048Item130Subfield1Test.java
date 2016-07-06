/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item130Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item130Subfield1Test extends MandatoryFixedLengthAsterixTests<Cat048Item130Subfield1> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item130Subfield1 setFixedLengthAsterixDataInstance() {
        return new Cat048Item130Subfield1();
    }

    @Test
    @Parameters({"255, 11.21", "23, 1.012", "0, 0"})
    public void the_decode_method_should_correctly_decode_data(int inputByte, double expected){
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item130Subfield1 item130Subfield1 = new Cat048Item130Subfield1();

        // act
        item130Subfield1.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - SSR Plot Runlength (dg)", expected, item130Subfield1.getSSRPlotRunlength(), 0.01);
    }
}
