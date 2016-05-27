/* 
* Created by dan-geabunea on 5/13/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item500;

import jlg.jade.asterix.cat062.item500.Item500Subfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item500Subfield6Test extends MandatoryFixedLengthAsterixTests<Item500Subfield6> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item500Subfield6 setFixedLengthAsterixDataInstance() {
        return new Item500Subfield6();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arramge
        byte[] input = {8,12};
        int offset = 0;
        Item500Subfield6 subfield6 = new Item500Subfield6();

        //act
        subfield6.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly - ATVX", 8, subfield6.getAccuracyForVelocityX());
        assertEquals("Subfield not decoded correctly - ATVY", 12, subfield6.getAccuracyForVelocityY());
    }
}
