/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item075;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat004Item075Test extends MandatoryFixedLengthAsterixTests<Cat004Item075> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat004Item075 setFixedLengthAsterixDataInstance() {
        return new Cat004Item075();
    }

    @Test
    @Parameters({"1,1,2,65794", "255,0,0,-65536"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet,
                                                               int secondOctet,
                                                               int thirdOctet,
                                                               int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet, (byte) thirdOctet};
        int offset = 0;
        Cat004Item075 item075 = new Cat004Item075();

        //act
        item075.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", expected,
                item075.getTransversalDistanceDeviation());
    }
}
