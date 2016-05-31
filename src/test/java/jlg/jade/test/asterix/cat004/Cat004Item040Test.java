/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item040;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item040Test extends MandatoryFixedLengthAsterixTests<Cat004Item040> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item040 setFixedLengthAsterixDataInstance() {
        return new Cat004Item040();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {0,84};
        int offset = 0;
        Cat004Item040 item040 = new Cat004Item040();

        //act
        item040.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 84, item040.getAlertIdentifier());
    }
}
