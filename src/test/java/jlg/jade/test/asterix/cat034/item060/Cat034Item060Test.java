/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.test.asterix.cat034.item060;

import jlg.jade.asterix.cat034.item060.Cat034Item060;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class Cat034Item060Test extends MandatoryFspecAsterixTests<Cat034Item060> {
    @Override
    protected Cat034Item060 setDataFieldInstance() {
        return new Cat034Item060();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * FSPEC = 24
     * Subfield1 = not present
     * Subfield4 = 1
     * Subfield5 = 2
     * Subfield6 = not present
     */

    private final byte[] input = {24, 1, 1};

    @Override
    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        int offset = 0;
        Cat034Item060 item060 = new Cat034Item060();

        // act
        item060.decode(input, offset, input.length);

        // assert
        assertNull("Subfield #1 should be null", item060.getSubfield1());
        assertNotNull("Subfield #4 should not be null", item060.getSubfield4());
        assertNotNull("Subfield #5 should not be null", item060.getSubfield5());
        assertNull("Subfield #6 should be null", item060.getSubfield6());
   }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat034Item060 item060 = new Cat034Item060();

        // act
        int newOffset = item060.decode(input, offset, input.length);

        // assert
        assertEquals("Offset not incremented after decoding data", input.length, newOffset);    }

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        // arrange
        int offset = 0;
        Cat034Item060 item060 = new Cat034Item060();

        // act
        item060.decode(input, offset, input.length);

        // assert
        assertEquals("FSPEC actual length not correct", 1, item060.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - #1", false, item060.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #4", true, item060.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", true, item060.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", false, item060.fspecDataAtIndex(2));
    }
}
