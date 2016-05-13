/* 
* Created by dan-geabunea on 5/13/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item500;

import jlg.jade.cat062.item500.Item500Subfield7;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item500Subfield7Test extends MandatoryFixedLengthAsterixTests<Item500Subfield7> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item500Subfield7 setFixedLengthAsterixDataInstance() {
        return new Item500Subfield7();
    }

    @Test
    public void the_deocde_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Item500Subfield7 subfield7 = new Item500Subfield7();

        //act
        subfield7.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly AAX", 1, subfield7.getAccuracyForAccelerationX());
        assertEquals("Subfield not decoded correctly AAY", 2, subfield7.getAccuracyForAccelerationY());
    }
}
