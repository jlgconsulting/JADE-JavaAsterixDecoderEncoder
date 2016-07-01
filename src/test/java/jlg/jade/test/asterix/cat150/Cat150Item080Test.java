/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item080;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat150Item080Test extends MandatoryFixedLengthAsterixTests<Cat150Item080> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item080 setFixedLengthAsterixDataInstance() {
        return new Cat150Item080();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {65,66,67,32};
        int offset = 0;
        Cat150Item080 cat150Item080 = new Cat150Item080();

        //act
        cat150Item080.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", "ABC", cat150Item080.getDepartureAerodrome());
    }
}
