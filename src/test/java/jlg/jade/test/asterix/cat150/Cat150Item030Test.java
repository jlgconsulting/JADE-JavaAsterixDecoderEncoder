/**
 * Created by Dan Geabunea on 6/30/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item030;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat150Item030Test extends MandatoryFixedLengthAsterixTests<Cat150Item030> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat150Item030 setFixedLengthAsterixDataInstance() {
        return new Cat150Item030();
    }

    @Test
    @Parameters({
            "100,-1", "1,1", "2,2", "3,3", "4,4",
            "5,5", "6,6", "251,251", "252,252",
            "253,253", "254,254", "255,255"})
    public void the_decode_method_should_correctly_decode_data(int inputOctet, int expected) {
        //arrange
        byte[] input = {(byte) inputOctet};
        int offset = 0;
        Cat150Item030 cat150Item030 = new Cat150Item030();

        //act
        cat150Item030.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", expected,
                cat150Item030.getMessageType().getNumericValue());

    }

}
