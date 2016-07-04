/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item130;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item130Test extends MandatoryFixedLengthAsterixTests<Cat150Item130> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat150Item130 setFixedLengthAsterixDataInstance() {
        return new Cat150Item130();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {48, 49, 50};
        int offset = 0;
        Cat150Item130 cat150Item130 = new Cat150Item130();

        //act
        cat150Item130.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 12, cat150Item130.getClearedFLightLevel());
    }
}
