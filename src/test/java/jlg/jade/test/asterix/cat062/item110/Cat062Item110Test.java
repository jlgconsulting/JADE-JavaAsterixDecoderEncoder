/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item110;

import jlg.jade.asterix.cat062.item110.Cat062Item110;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Cat062Item110Test extends MandatoryFspecAsterixTests<Cat062Item110> {
    @Override
    protected Cat062Item110 setDataFieldInstance() {
        return new Cat062Item110();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * subfield 5,6,7 are present
     */
    private final byte[] sampleInput = {
            15,
            1,
            2,
            0,
            1
    };

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat062Item110 item110 = new Cat062Item110();

        //act
        item110.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Actual FSPEC size is invalid", 1, item110.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - Subfield #1", false, item110.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - Subfield #2", false, item110.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - Subfield #3", false, item110.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - Subfield #4", false, item110.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - Subfield #5", true, item110.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - Subfield #6", true, item110.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - Subfield #7", true, item110.fspecDataAtIndex(1));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat062Item110 item110 = new Cat062Item110();

        //act
        item110.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertNotNull(item110.getSubfield5());
        assertNotNull(item110.getSubfield6());
        assertNotNull(item110.getSubfield7());
    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat062Item110 item110 = new Cat062Item110();

        //act
        int result = item110.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Offset not incremented correctly after decoding data", sampleInput.length, result);
    }
}
