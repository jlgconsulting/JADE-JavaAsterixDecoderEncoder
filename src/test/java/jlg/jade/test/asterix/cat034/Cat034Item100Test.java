/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item100;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034Item100Test extends MandatoryFixedLengthAsterixTests<Cat034Item100>{
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 8;
    }

    @Override
    protected Cat034Item100 setFixedLengthAsterixDataInstance() {
        return new Cat034Item100();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {1, 23, 34, 12, 1, 43, 12, 7};
        int offset = 0;
        Cat034Item100 item100 = new Cat034Item100();

        // act
        item100.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 3079, item100.getRhoStart());
        assertEquals("Item not decoded correctly", 299, item100.getRhoEnd());
        assertEquals("Item not decoded correctly", 8716, item100.getThetaStart());
        assertEquals("Item not decoded correctly", 279, item100.getThetaEnd());
    }

}
