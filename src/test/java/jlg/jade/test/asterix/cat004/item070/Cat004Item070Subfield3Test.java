/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.test.asterix.cat004.item070;

import jlg.jade.asterix.cat004.item070.Cat004Item070Subfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item070Subfield3Test extends
        MandatoryFixedLengthAsterixTests<Cat004Item070Subfield3> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat004Item070Subfield3 setFixedLengthAsterixDataInstance() {
        return new Cat004Item070Subfield3();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {0, 1, 1};
        int offset = 0;
        Cat004Item070Subfield3 subfield3 = new Cat004Item070Subfield3();

        //act
        subfield3.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 257, subfield3.getSeparation());
    }
}
