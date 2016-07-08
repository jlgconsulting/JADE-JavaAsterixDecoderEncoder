/**
 * Created by alexandru on 7/7/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item220;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item220Test extends MandatoryFixedLengthAsterixTests<Cat048Item220> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat048Item220 setFixedLengthAsterixDataInstance() {
        return new Cat048Item220();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {64, 7, 77};
        int offset = 0;
        Cat048Item220 item220 = new Cat048Item220();

        // act
        item220.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Aircraft Address", 4196173, item220.getAircraftAddress());
    }
}
