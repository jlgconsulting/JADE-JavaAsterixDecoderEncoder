/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item110;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat150Item110Test extends MandatoryFixedLengthAsterixTests<Cat150Item110> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat150Item110 setFixedLengthAsterixDataInstance() {
        return new Cat150Item110();
    }

    @Test
    @Parameters({"64,true,-1", "32,false,1", "16,false,2", "8,false,3"})
    public void the_decode_method_should_correctly_decode_data(int octetValue,
                                                               boolean expectedHoldFlag,
                                                               int expectedRvsm) {
        //arrange
        byte[] input = {(byte) octetValue};
        int offset = 0;
        Cat150Item110 cat150Item110 = new Cat150Item110();

        //act
        cat150Item110.decode(input, offset, input.length);

        //assert
        assertEquals("Hold flag not decoded correctly", expectedHoldFlag,
                cat150Item110.getHoldFlag());
        assertEquals("Rvsm not decoded correctly", expectedRvsm,
                cat150Item110.getRvsmStatus().getNumericValue());
    }
}
