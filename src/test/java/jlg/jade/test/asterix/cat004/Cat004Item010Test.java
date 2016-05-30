/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item010;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item010Test extends MandatoryFixedLengthAsterixTests<Cat004Item010> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item010 setFixedLengthAsterixDataInstance() {
        return new Cat004Item010();
    }

    @Test
    public void the_decode_methid_should_correctly_decode_data() {
        //arrange
        byte[] input = {48, (byte) 255};
        int offset = 0;
        Cat004Item010 item010 = new Cat004Item010();

        //act
        item010.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correclty", 48, item010.getSac());
        assertEquals("Data not decoded correctly", 255, item010.getSic());
    }
}
