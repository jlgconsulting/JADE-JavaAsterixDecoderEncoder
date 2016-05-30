/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.asterix.cat004.Cat004Item020;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item020Test extends MandatoryFixedLengthAsterixTests {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected FixedLengthAsterixData setFixedLengthAsterixDataInstance() {
        return new Cat004Item020();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {32, (byte) 254, (byte) 128};
        int offset = 0;
        Cat004Item020 item020 = new Cat004Item020();

        //act
        item020.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 2162304, item020.getTime());
    }
}
