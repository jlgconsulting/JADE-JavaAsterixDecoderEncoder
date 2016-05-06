/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item290;

import jlg.jade.cat062.item290.Item290Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item290Subfield2Test extends MandatoryFixedLengthAsterixTests<Item290Subfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item290Subfield2 setFixedLengthAsterixDataInstance() {
        return new Item290Subfield2();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {(byte) 255};
        int offset = 0;
        Item290Subfield2 subfield2 = new Item290Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("PSR Age not decoded correctly", 255, subfield2.getPsrAge());
    }

    @Test
    public void the_get_psr_age_seconds_should_correctly_convert_age_to_sec(){
        //arrange
        byte[] input = {(byte) 8};
        int offset = 0;
        Item290Subfield2 subfield2 = new Item290Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals(2, subfield2.getPsrAgeSeconds());
    }
}
