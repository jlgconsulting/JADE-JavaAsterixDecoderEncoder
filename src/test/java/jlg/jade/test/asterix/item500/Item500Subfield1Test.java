/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item500;

import jlg.jade.asterix.cat062.item500.Item500Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item500Subfield1Test extends MandatoryFixedLengthAsterixTests<Item500Subfield1> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Item500Subfield1 setFixedLengthAsterixDataInstance() {
        return new Item500Subfield1();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {0,35,0,33};
        int offset = 0;
        Item500Subfield1 subfield1 = new Item500Subfield1();

        //act
        subfield1.decode(input,offset, input.length);

        //assert
        assertEquals("APC X not decoded correctly", 35, subfield1.getAccuracyOfPositionX());
        assertEquals("APC X not decoded correctly", 33, subfield1.getAccuracyOfPositionY());
    }
}
