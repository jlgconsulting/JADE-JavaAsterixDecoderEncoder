/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item090;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item090Test extends MandatoryFixedLengthAsterixTests<Cat150Item090> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item090 setFixedLengthAsterixDataInstance() {
        return new Cat150Item090();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {65, 66, 67, 32};
        int offset = 0;
        Cat150Item090 cat150Item090 = new Cat150Item090();

        //act
        cat150Item090.decode(input, offset, input.length);

        //assert
        assertEquals("Item not implemented correctly", "ABC",
                cat150Item090.getDestinationAerodrome());
    }
}
