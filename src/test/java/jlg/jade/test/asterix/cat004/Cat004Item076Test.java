/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.item170_171.Cat004Item076;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat004Item076Test extends MandatoryFixedLengthAsterixTests<Cat004Item076> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item076 setFixedLengthAsterixDataInstance() {
        return new Cat004Item076();
    }

    @Test
    @Parameters({"1,1,257", "255,1,-255"})
    public void the_decode_method_should_correctly_decode_data(
            int firstOctet,
            int secondOctet,
            int expected
    ) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat004Item076 item076 = new Cat004Item076();

        //act
        item076.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", expected, item076.getVerticalDeviation());
    }


}
