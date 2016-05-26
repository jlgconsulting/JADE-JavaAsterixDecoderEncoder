/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item300;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cat062Item300Test extends MandatoryFixedLengthAsterixTests<Cat062Item300> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat062Item300 setFixedLengthAsterixDataInstance() {
        return new Cat062Item300();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {7};     //emergency
        int offset = 0;
        Cat062Item300 item300 = new Cat062Item300();

        //act
        item300.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correclty", 7, item300.getVehicleFleetId());
        assertTrue(item300.isValid());
    }
}
