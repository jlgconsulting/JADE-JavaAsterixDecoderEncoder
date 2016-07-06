/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item130Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item130Subfield2Test extends MandatoryFixedLengthAsterixTests<Cat048Item130Subfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item130Subfield2 setFixedLengthAsterixDataInstance() {
        return new Cat048Item130Subfield2();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {43};
        int offset = 0;
        Cat048Item130Subfield2 item130Subfield2 = new Cat048Item130Subfield2();

        // act
        item130Subfield2.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - SRR", 43, item130Subfield2.getReceivedReplies());
    }
}
