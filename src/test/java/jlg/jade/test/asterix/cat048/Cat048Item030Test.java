/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item030;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item030Test {

    @Test
    public void should_have_length_correct_length(){
        // arrange
        byte[] input = {(byte) 141, 76};
        int offset = 0;
        Cat048Item030 item030 = new Cat048Item030();

        // act
        item030.decode(input, offset, input.length);

        // assert
        assertEquals("Variable length Asterix data field has invalid size", 2, item030.getSizeInBytes());
    }
}
