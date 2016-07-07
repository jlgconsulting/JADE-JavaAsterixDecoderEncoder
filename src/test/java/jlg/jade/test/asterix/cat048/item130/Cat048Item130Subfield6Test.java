/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048.item130;

import jlg.jade.asterix.cat048.item130.Cat048Item130Subfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item130Subfield6Test extends MandatoryFixedLengthAsterixTests<Cat048Item130Subfield6> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item130Subfield6 setFixedLengthAsterixDataInstance() {
        return new Cat048Item130Subfield6();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {-12};
        int offset = 0;
        Cat048Item130Subfield6 item130Subfield6 = new Cat048Item130Subfield6();

        // act
        item130Subfield6.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - RPD", -12, item130Subfield6.getRangeDifference());
    }
}
