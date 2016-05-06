/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item290;

import jlg.jade.cat062.item290.Item290Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Item290Subfield1Test extends MandatoryFixedLengthAsterixTests<Item290Subfield1> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item290Subfield1 setFixedLengthAsterixDataInstance() {
        return new Item290Subfield1();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {(byte) 255};
        int offset = 0;
        Item290Subfield1 subfield1 = new Item290Subfield1();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("Track age was not decoded correctly", 255, subfield1.getTrackAge());
    }

    @Test
    public void the_get_track_age_seconds_method_should_correclty_convert_age_to_sec(){
        //arrange
        byte[] input = {(byte) 8};
        int offset = 0;
        Item290Subfield1 subfield1 = new Item290Subfield1();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals(2, subfield1.getTrackAgeSeconds(), 0.01);
    }
}
