/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item090;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034Item090Test extends MandatoryFixedLengthAsterixTests<Cat034Item090> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat034Item090 setFixedLengthAsterixDataInstance() {
        return new Cat034Item090();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {23, 1};
        int offset = 0;
        Cat034Item090 item090 = new Cat034Item090();

        // act
        item090.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 1, item090.getRangeError());
        assertEquals("Item not decoded correctly", 23, item090.getAzimuthError());
    }
}
