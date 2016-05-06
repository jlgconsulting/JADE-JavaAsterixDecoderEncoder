/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item290;

import jlg.jade.cat062.item290.Item290Subfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item290Subfield3Test extends MandatoryFixedLengthAsterixTests<Item290Subfield3> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item290Subfield3 setFixedLengthAsterixDataInstance() {
        return new Item290Subfield3();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {8};
        int offset = 0;
        Item290Subfield3 subfield3 = new Item290Subfield3();

        //act
        subfield3.decode(input, offset, input.length);

        //assert
        assertEquals("SSR age not decoded correctly", 8, subfield3.getSsrAge());
    }

    @Test
    public void the_get_ssr_age_seconds_method_should_correctly_transform_age_to_sec(){
        //arrange
        byte[] input = {8};
        int offset = 0;
        Item290Subfield3 subfield3 = new Item290Subfield3();

        //act
        subfield3.decode(input, offset, input.length);

        //assert
        assertEquals(2, subfield3.getSsrAgeSeconds());
    }
}
