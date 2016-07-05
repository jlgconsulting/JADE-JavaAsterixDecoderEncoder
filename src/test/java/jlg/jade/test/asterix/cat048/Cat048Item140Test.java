/**
 * Created by alexandru on 7/5/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item140;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item140Test extends MandatoryFixedLengthAsterixTests<Cat048Item140>{
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat048Item140 setFixedLengthAsterixDataInstance() {
        return new Cat048Item140();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {0, (byte) 213, 117};
        int offset = 0;
        Cat048Item140 item140 = new Cat048Item140();

        // act
        item140.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly", 54645, item140.getTime());
    }
}
