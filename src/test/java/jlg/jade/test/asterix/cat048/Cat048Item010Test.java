/**
 * Created by alexandru on 7/5/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item010;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item010Test extends MandatoryFixedLengthAsterixTests<Cat048Item010> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item010 setFixedLengthAsterixDataInstance() {
        return new Cat048Item010();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {52, 66};
        int offset = 0;
        Cat048Item010 item010 = new Cat048Item010();

        // act
        item010.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 52, item010.getSac());
        assertEquals("Item not decoded correctly", 66, item010.getSic());

    }
}
