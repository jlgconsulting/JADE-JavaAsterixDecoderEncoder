/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.test.asterix.cat048.item130;

import jlg.jade.asterix.cat048.item130.Cat048Item130Subfield5;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat048Item130Subfield5Test extends MandatoryFixedLengthAsterixTests<Cat048Item130Subfield5> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item130Subfield5 setFixedLengthAsterixDataInstance() {
        return new Cat048Item130Subfield5();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        // arrange
        byte[] input = {-23};
        int offset = 0;
        Cat048Item130Subfield5 item130Subfield5 = new Cat048Item130Subfield5();

        // act
        item130Subfield5.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - PAM", -23, item130Subfield5.getAmplitudeOfPrimaryPlot());
    }
}
