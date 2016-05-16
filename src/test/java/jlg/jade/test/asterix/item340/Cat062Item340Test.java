/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item340;

import jlg.jade.asterix.cat062.item340.Cat062Item340;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class Cat062Item340Test extends MandatoryFspecAsterixTests<Cat062Item340> {
    @Override
    protected Cat062Item340 setDataFieldInstance() {
        return new Cat062Item340();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    private byte[] sampleInput = {
            (byte) 220,
            (byte) 132,
            5,
            95,
            8,
            (byte) 224,
            (byte) 164,
            5,
            (byte) 200,
            9,
            (byte) 221,
            64
    };

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat062Item340 item340 = new Cat062Item340();

        //act
        item340.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Actual FSPEC size is invalid", 1, item340.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - Subfield #1", true, item340.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - Subfield #2", true, item340.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - Subfield #3", false, item340.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - Subfield #4", true, item340.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - Subfield #5", true, item340.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - Subfield #6", true, item340.fspecDataAtIndex(2));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat062Item340 item340 = new Cat062Item340();

        //act
        item340.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Item 340 Subfield #1 not decoded correctly", 132, item340.getSubfield1().getSac());
        assertEquals("Item 340 Subfield #1 not decoded correctly", 5, item340.getSubfield1().getSic());
        assertEquals("Item 340 Subfield #2 not decoded correctly", 24328, item340.getSubfield2().getMeasuredDistance());
        assertEquals("Item 340 Subfield #2 not decoded correctly", 57508, item340.getSubfield2().getMeasuredAzimuth());
        assertNull(item340.getSubfield3());
        assertEquals("Item 340 Subfield #4 not decoded correctly", false, item340.getSubfield4().getCodeValidation());
        assertEquals("Item 340 Subfield #4 not decoded correctly", false, item340.getSubfield4().isCodeGarbled());
        assertEquals("Item 340 Subfield #2 not decoded correctly", 1480, item340.getSubfield4().getLastMeasuredModeC());
        assertEquals("Item 340 Subfield #4 not decoded correctly", false, item340.getSubfield5().getCodeValidation());
        assertEquals("Item 340 Subfield #5 not decoded correctly", false, item340.getSubfield5().isCodeGarbled());
        assertEquals("Item 340 Subfield #5 not decoded correctly", false, item340.getSubfield5().isSmoothed());
        assertEquals("Item 340 Subfield #6 not decoded correctly", 2525, item340.getSubfield5()
                .getLastMeasuredModeACode());
        assertNotNull(item340.getSubfield6());
    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat062Item340 item340 = new Cat062Item340();

        //act
        int result = item340.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Offset not incremented after data decoding", sampleInput.length, result);
    }
}
