/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.test.asterix.cat004.item120;

import jlg.jade.asterix.cat004.item120.Cat004Item120Subfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item120Subfield4Test extends
        MandatoryFixedLengthAsterixTests<Cat004Item120Subfield4> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat004Item120Subfield4 setFixedLengthAsterixDataInstance() {
        return new Cat004Item120Subfield4();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {0, 1, 2};
        int offset = 0;
        Cat004Item120Subfield4 subfield4 = new Cat004Item120Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("Duration of conflict not decoded correctly", 258, subfield4.getTime());
    }

}
