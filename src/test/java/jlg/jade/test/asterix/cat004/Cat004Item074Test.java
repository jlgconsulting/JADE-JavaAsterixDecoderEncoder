/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item074;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat004Item074Test extends MandatoryFixedLengthAsterixTests<Cat004Item074> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item074 setFixedLengthAsterixDataInstance() {
        return new Cat004Item074();
    }

    @Test
    @Parameters({"1,1,257", "255,1,-255"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet,
                                                               int secondOctet,
                                                               int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat004Item074 item074 = new Cat004Item074();

        //act
        item074.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", expected, item074.getLongitudinalDeviation());
    }
}
