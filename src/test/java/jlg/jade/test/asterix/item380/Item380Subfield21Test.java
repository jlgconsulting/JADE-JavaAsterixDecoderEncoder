/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield21;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item380Subfield21Test extends MandatoryFixedLengthAsterixTests<Item380Subfield21> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item380Subfield21 setFixedLengthAsterixDataInstance() {
        return new Item380Subfield21();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {12};
        int offset = 0;
        Item380Subfield21 subfield = new Item380Subfield21();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Emitter category not decoded correctly", 12, subfield.getEmiterCategory());
    }
}
