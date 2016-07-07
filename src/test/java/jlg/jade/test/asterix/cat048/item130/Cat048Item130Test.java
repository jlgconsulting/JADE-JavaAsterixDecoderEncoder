/**
 * Created by alexandru on 7/7/16.
 */
package jlg.jade.test.asterix.cat048.item130;

import jlg.jade.asterix.cat048.item130.Cat048Item130;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Cat048Item130Test extends MandatoryFspecAsterixTests<Cat048Item130> {
    @Override
    protected Cat048Item130 setDataFieldInstance() {
        return new Cat048Item130();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * FSPEC = 32
     * Subfield1 = not present
     * Subfield2 = not present
     * Subfield3 = 188
     * Subfield4 = not present
     * Subfield5 = not present
     * Subfield6 = not present
     * Subfield7 = not present
     */
    private final byte[] input = {32, (byte) 188};

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        // arrange
        int offset = 0;
        Cat048Item130 item130 = new Cat048Item130();

        // act
        item130.decode(input, offset, input.length);

        // assert
        assertEquals("FSPEC actual length not correct", 1, item130.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - #1", false, item130.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #2", false, item130.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - #3", true, item130.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - #4", false, item130.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", false, item130.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", false, item130.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - #7", false, item130.fspecDataAtIndex(1));
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        // arrange
        int offset = 0;
        Cat048Item130 item130 = new Cat048Item130();

        // act
        int newOffset = item130.decode(input, offset, input.length);

        // assert
        assertEquals("Offset not incremented after decoding data", input.length, newOffset);
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        int offset = 0;
        Cat048Item130 item130 = new Cat048Item130();

        // act
        item130.decode(input, offset, input.length);

        // assert
        assertNull("Subfield #1 should be null", item130.getSubfield1());
        assertNull("Subfield #2 should be null", item130.getSubfield2());
        assertNotNull("Subfield #3 should not be null", item130.getSubfield3());
        assertNull("Subfield #4 should be null", item130.getSubfield4());
        assertNull("Subfield #5 should be null", item130.getSubfield5());
        assertNull("Subfield #6 should be null", item130.getSubfield6());
        assertNull("Subfield #7 should be null", item130.getSubfield7());
    }

    @Test
    public void the_decode_method_should_correctly_decode_primary_amplitude_subfield(){
        // arrange
        byte[] input = {8, 34};
        int offset = 0;
        Cat048Item130 item130 = new Cat048Item130();

        // act
        item130.decode(input, offset, input.length);

        // assert
        assertNotNull("Subfield #5 should not be null", item130.getSubfield5());
        assertEquals("Item not decoded correctly - PAM", 34, item130.getSubfield5().getAmplitudeOfPrimaryPlot());
    }

}
