/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item060;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item060Test extends MandatoryFixedLengthAsterixTests<Cat150Item060> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item060 setFixedLengthAsterixDataInstance() {
        return new Cat150Item060();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {48, 49, 50, 51};
        int offset = 0;
        Cat150Item060 cat150Item060 = new Cat150Item060();

        //act
        cat150Item060.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", "0123", cat150Item060.getModeAOctal());
    }
}
