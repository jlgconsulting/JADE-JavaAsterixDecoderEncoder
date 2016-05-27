/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item500;

import jlg.jade.asterix.cat062.item500.Item500Subfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item500Subfield4Test extends MandatoryFixedLengthAsterixTests<Item500Subfield4> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item500Subfield4 setFixedLengthAsterixDataInstance() {
        return new Item500Subfield4();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {47};
        int offset = 0;
        Item500Subfield4 subfield4 = new Item500Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 47, subfield4.getAccuracyForGeometricAltitude());
    }
}
