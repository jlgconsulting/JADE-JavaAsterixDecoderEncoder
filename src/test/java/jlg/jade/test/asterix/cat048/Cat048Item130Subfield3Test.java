/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item130Subfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item130Subfield3Test extends MandatoryFixedLengthAsterixTests<Cat048Item130Subfield3> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item130Subfield3 setFixedLengthAsterixDataInstance() {
        return new Cat048Item130Subfield3();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {-34};
        int offset = 0;
        Cat048Item130Subfield3 item130Subfield3 = new Cat048Item130Subfield3();

        // act
        item130Subfield3.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly - SAM", -34, item130Subfield3.getAmplitudeOfReply());
    }
}
