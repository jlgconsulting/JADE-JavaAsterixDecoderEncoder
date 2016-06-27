/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.test.asterix.cat004.item070;

import jlg.jade.asterix.cat004.item070.Cat004Item070Subfield5;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item070Subfield5Test extends
        MandatoryFixedLengthAsterixTests<Cat004Item070Subfield5> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item070Subfield5 setFixedLengthAsterixDataInstance() {
        return new Cat004Item070Subfield5();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {1, 1};
        int offset = 0;
        Cat004Item070Subfield5 subfield5 = new Cat004Item070Subfield5();

        //act
        subfield5.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 257, subfield5.getSeparation());
        assertEquals("Data not decoded correctly", 257 * 25, subfield5.getSeparationFt());
    }
}
