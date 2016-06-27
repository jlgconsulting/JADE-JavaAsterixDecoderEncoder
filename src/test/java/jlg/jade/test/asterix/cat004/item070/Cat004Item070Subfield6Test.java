/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.test.asterix.cat004.item070;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.cat004.item070.Cat004Item070Subfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item070Subfield6Test extends
        MandatoryFixedLengthAsterixTests<Cat004Item070Subfield6> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected Cat004Item070Subfield6 setFixedLengthAsterixDataInstance() {
        return new Cat004Item070Subfield6();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {1, 1};
        int offset = 0;
        Cat004Item070Subfield6 subfield6 = new Cat004Item070Subfield6();

        //act
        subfield6.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 257, subfield6.getSeparation());
        assertEquals("COnversion to ft not correct", 257 * 25, subfield6.getSeparationFt());
    }


}
