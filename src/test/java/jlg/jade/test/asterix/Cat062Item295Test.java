/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.cat062.Cat062Item295;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item295Test {
    @Test
    public void max_fspec_length_should_be_two_bytes() {
        //arrange
        Cat062Item295 item = new Cat062Item295();

        //assert
        assertEquals("Max fpsec size is invalid", 5, item.getMaxFspecSizeInBytes());
    }

    private final byte[] sampleInput = {
            (byte) 147,
            85,
            127,
            1,
            (byte) 224,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7,
            7
    };

    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat062Item295 item295 = new Cat062Item295();

        //act
        item295.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Actual Subfield size is invalid", 5, item295.getActualFspecSizeInBytes());

        assertEquals("Subfield not decoded correctly - Subfield #1", true, item295.fspecDataAtIndex(7));
        assertEquals("Subfield not decoded correctly - Subfield #4", true, item295.fspecDataAtIndex(4));
        assertEquals("Subfield not decoded correctly - Subfield #7", true, item295.fspecDataAtIndex(1));
        assertEquals("Subfield not decoded correctly - Subfield #9", true, item295.fspecDataAtIndex(14));
        assertEquals("Subfield not decoded correctly - Subfield #11", true, item295.fspecDataAtIndex(12));
        assertEquals("Subfield not decoded correctly - Subfield #13", true, item295.fspecDataAtIndex(10));
        assertEquals("Subfield not decoded correctly - Subfield #16", true, item295.fspecDataAtIndex(22));
        assertEquals("Subfield not decoded correctly - Subfield #18", true, item295.fspecDataAtIndex(20));
        assertEquals("Subfield not decoded correctly - Subfield #19", true, item295.fspecDataAtIndex(19));
        assertEquals("Subfield not decoded correctly - Subfield #20", true, item295.fspecDataAtIndex(18));
        assertEquals("Subfield not decoded correctly - Subfield #21", true, item295.fspecDataAtIndex(17));
        assertEquals("Subfield not decoded correctly - Subfield #29", true, item295.fspecDataAtIndex(37));
        assertEquals("Subfield not decoded correctly - Subfield #30", true, item295.fspecDataAtIndex(38));
        assertEquals("Subfield not decoded correctly - Subfield #31", true, item295.fspecDataAtIndex(39));

        assertEquals("Invalid number of present data items", 15, item295.getNbPresentDataFields());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat062Item295 item295 = new Cat062Item295();

        //act
        item295.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Subfield not decoded correctly - Subfield #1", 7, item295.getSubfield1().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #4", 7, item295.getSubfield4().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #9", 7, item295.getSubfield9().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #11", 7, item295.getSubfield11().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #13", 7, item295.getSubfield13().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #16", 7, item295.getSubfield16().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #17", 7, item295.getSubfield17().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #19", 7, item295.getSubfield19().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #20", 7, item295.getSubfield20().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #21", 7, item295.getSubfield21().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #29", 7, item295.getSubfield29().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #30", 7, item295.getSubfield30().getAge());
        assertEquals("Subfield not decoded correctly - Subfield #31", 7, item295.getSubfield31().getAge());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat062Item295 item295 = new Cat062Item295();

        //act
        int result = item295.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Offset not incremented after decoding of data", offset + sampleInput.length, result);
    }
}
