/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item100;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat150Item100Test extends MandatoryFixedLengthAsterixTests<Cat150Item100> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat150Item100 setFixedLengthAsterixDataInstance() {
        return new Cat150Item100();
    }

    @Test
    @Parameters({"128,true,false,false,false",
            "64,false,true,false,false",
            "4,false,false,true,false",
            "2,false,false,false,true"})
    public void the_decode_method_should_correctly_decode_data(int inputValue,
                                                               boolean expectedGat,
                                                               boolean expectedOat,
                                                               boolean expectedCpl,
                                                               boolean expectedSpn) {
        //arrange
        byte[] input = {(byte) inputValue};
        int offset = 0;
        Cat150Item100 cat150Item100 = new Cat150Item100();

        //act
        cat150Item100.decode(input, offset, input.length);

        //assert
        assertEquals("GAT item not decoded correctly", expectedGat, cat150Item100.getGatFlag());
        assertEquals("OAT item not decoded correctly", expectedOat, cat150Item100.getOatFlag());
        assertEquals("CPL item not decoded correctly", expectedCpl, cat150Item100.getCplFlag());
        assertEquals("SPN item not decoded correctly", expectedSpn, cat150Item100.getSpnFlag());
    }
}
