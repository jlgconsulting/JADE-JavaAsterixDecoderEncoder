package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.item070.Cat004Item030;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item030Test extends MandatoryFixedLengthAsterixTests<Cat004Item030> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item030 setFixedLengthAsterixDataInstance() {
        return new Cat004Item030();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {20, 55};
        int offset = 0;
        Cat004Item030 item030 = new Cat004Item030();

        //act
        item030.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 5175, item030.getTrackNumber());
    }
}
