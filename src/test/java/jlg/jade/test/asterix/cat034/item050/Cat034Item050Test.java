/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.test.asterix.cat034.item050;

import jlg.jade.asterix.cat034.item050.Cat034Item050;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class Cat034Item050Test extends MandatoryFspecAsterixTests<Cat034Item050> {

    @Override
    protected Cat034Item050 setDataFieldInstance() {
        return new Cat034Item050();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * FSPEC = 136
     * Subfield1 = 1
     * Subfield4 = not present
     * Subfield5 = 2
     * Subfield6 = not present
     */
    private final byte[] input = {(byte) 136, 1, 2};

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        // arrange
        int offset = 0;
        Cat034Item050 item50 = new Cat034Item050();

        // act
        item50.decode(input, offset, input.length);

        // assert
        assertEquals("FSPEC actual length not correct", 1, item50.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - #1", true, item50.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #4", false, item50.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", true, item50.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", false, item50.fspecDataAtIndex(2));

    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        int offset = 0;
        Cat034Item050 item050 = new Cat034Item050();

        // act
        item050.decode(input, offset, input.length);

        // assert
        assertNotNull("Subfield #1 should not be null", item050.getSubfield1());
        assertNull("Subfield #4 should be null", item050.getSubfield4());
        assertNotNull("Subfield #5 should not be null", item050.getSubfield5());
        assertNull("Subfield #6 should be null", item050.getSubfield6());
    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        // arrange
        int offset = 0;
        Cat034Item050 item050 = new Cat034Item050();

        // act
        int newOffset = item050.decode(input, offset, input.length);

        // assert
        assertEquals("Offset not incremented after decoding data", input.length, newOffset);

   }
}
