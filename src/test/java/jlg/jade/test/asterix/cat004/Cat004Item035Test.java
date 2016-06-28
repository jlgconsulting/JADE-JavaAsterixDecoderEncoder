/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item035;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item035Test extends MandatoryFixedLengthAsterixTests<Cat004Item035> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item035 setFixedLengthAsterixDataInstance() {
        return new Cat004Item035();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {29, 65};
        int offset = 0;
        Cat004Item035 item035 = new Cat004Item035();

        //act
        item035.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 7489, item035.getTrackNumber());
    }
}
