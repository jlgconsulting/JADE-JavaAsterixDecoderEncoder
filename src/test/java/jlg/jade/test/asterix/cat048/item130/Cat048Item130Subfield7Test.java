/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048.item130;

import jlg.jade.asterix.cat048.item130.Cat048Item130Subfield7;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item130Subfield7Test extends MandatoryFixedLengthAsterixTests<Cat048Item130Subfield7> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item130Subfield7 setFixedLengthAsterixDataInstance() {
        return new Cat048Item130Subfield7();
    }

    @Test
    @Parameters({"123, 5.412", "23, 1.012", "0, 0", "-94, -4.136"})
    public void the_decode_method_should_correctly_decode_data(int inputByte, double expected){
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item130Subfield7 item130Subfield7 = new Cat048Item130Subfield7();

        // act
        item130Subfield7.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - APD (dg)", expected, item130Subfield7.getAzimuthDifferenceDegrees(), 0.001);
    }
}