/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.asterix.cat004.item100;

import jlg.jade.asterix.cat004.item100.Cat004Item100Subfield1;
import jlg.jade.common.IA5Decoder;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item100Subfield1Test extends MandatoryFixedLengthAsterixTests<Cat004Item100Subfield1> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 6;
    }

    @Override
    protected Cat004Item100Subfield1 setFixedLengthAsterixDataInstance() {
        return new Cat004Item100Subfield1();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {57, 5, 52, (byte) 203, (byte) 1, (byte) 202};
        int offset = 0;
        Cat004Item100Subfield1 item100Subfield1 = new Cat004Item100Subfield1();

        // act
        item100Subfield1.decode(input, offset, input.length);

        // assert
        assertEquals("Data not decoded correctly - Area Name", "NPT420GJ", item100Subfield1.getAreaName());
    }
}
