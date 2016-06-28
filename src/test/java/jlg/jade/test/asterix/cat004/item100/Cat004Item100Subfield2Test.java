/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.asterix.cat004.item100;

import jlg.jade.asterix.cat004.item100.Cat004Item100Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item100Subfield2Test
        extends MandatoryFixedLengthAsterixTests<Cat004Item100Subfield2> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Cat004Item100Subfield2 setFixedLengthAsterixDataInstance() {
        return new Cat004Item100Subfield2();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {65, 66, 67, 68, 69, 70, 32}; //'ABCDEF '
        int offset = 0;
        Cat004Item100Subfield2 subfield2 = new Cat004Item100Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", "ABCDEF", subfield2.getCrossingAreaName());
    }
}
