/* 
* Created by dan-geabunea on 5/5/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item290;

import jlg.jade.cat062.item290.Cat062Item290;
import jlg.jade.cat062.item290.Cat062Item290Fspec;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Cat062Item290Test {

    @Test
    public void max_fspec_length_should_be_two_bytes() {
        //arrange
        Cat062Item290 item = new Cat062Item290();

        //assert
        assertEquals("Fpsec size is invalid", 2, item.getMaxFspecSizeInBytes());
    }

    private byte[] sampleInput = {
            127,
            (byte) 160,
            (byte) 255,
            7,
            7,
            (byte) 255,
            (byte) 255,
            (byte) 255,
            (byte) 255,
            (byte) 255,
            (byte) 255
    };

    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat062Item290 item290 = new Cat062Item290();

        //act
        item290.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Actual FSPEC size is invalid", 2, item290.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - Subfield #1", false, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_1));
        assertEquals("FSPEC not decoded correctly - Subfield #2", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_2));
        assertEquals("FSPEC not decoded correctly - Subfield #3", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_3));
        assertEquals("FSPEC not decoded correctly - Subfield #4", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_4));
        assertEquals("FSPEC not decoded correctly - Subfield #5", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_5));
        assertEquals("FSPEC not decoded correctly - Subfield #6", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_6));
        assertEquals("FSPEC not decoded correctly - Subfield #7", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_7));
        assertEquals("FSPEC not decoded correctly - Subfield #8", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_8));
        assertEquals("FSPEC not decoded correctly - Subfield #9", false, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_9));
        assertEquals("FSPEC not decoded correctly - Subfield #10", true, item290.isDataPresent(Cat062Item290Fspec
                .SUBFIELD_10));
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat062Item290 item290 = new Cat062Item290();

        //act
        item290.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertNull("Item 290 Subfield #1 not decoded correctly", item290.getSubfield1());
        assertEquals("Item 290 Subfield #2 not decoded correctly", 255, item290.getSubfield2().getAge());
        assertEquals("Item 290 Subfield #3 not decoded correctly", 7, item290.getSubfield3().getAge());
        assertEquals("Item 290 Subfield #4 not decoded correctly", 7, item290.getSubfield4().getAge());
        assertEquals("Item 290 Subfield #5 not decoded correctly", 65535, item290.getSubfield5().getAge());
        assertEquals("Item 290 Subfield #6 not decoded correctly", 255, item290.getSubfield6().getAge());
        assertEquals("Item 290 Subfield #7 not decoded correctly", 255, item290.getSubfield7().getAge());
        assertEquals("Item 290 Subfield #8 not decoded correctly", 255, item290.getSubfield8().getAge());
        assertNull("Item 290 Subfield #9 not decoded correctly", item290.getSubfield9());
        assertEquals("Item 290 Subfield #10 not decoded correctly", 255, item290.getSubfield10().getAge());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding(){
        //arrange
        int offset = 0;
        Cat062Item290 item290 = new Cat062Item290();

        //act
        int result = item290.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Offset not incremented after decoding of data", offset + sampleInput.length, result);
    }


}
