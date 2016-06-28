/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.asterix.cat004.item100;

import jlg.jade.asterix.cat004.item100.Cat004Item100;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Cat004Item100Test extends MandatoryFspecAsterixTests<Cat004Item100> {
    @Override
    protected Cat004Item100 setDataFieldInstance() {
        return new Cat004Item100();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * Sample data for all tests
     * FPSEC is 100 => Subfields 2,3,6 are present
     * Subfield2 value is ABCDE
     * Subfield3 value is ABCDEF
     * Subfield6 value is ABCDEFG
     */
    private final byte[] SAMPLE_INPUT = {
            100,
            65, 66, 67, 68, 69, 32, 32,
            65, 66, 67, 68, 69, 70, 32,
            65, 66, 67, 68, 69, 70, 71
    };

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat004Item100 cat004Item100 = new Cat004Item100();

        //act
        cat004Item100.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("FSPEC actual length not correct", 1,
                cat004Item100.getActualFspecSizeInBytes());
        assertEquals("Nb. of present data fields is not valid", 3,
                cat004Item100.getNbPresentDataFields());

        assertEquals("FSPEC not decoded correctly - #1", false, cat004Item100.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #2", true, cat004Item100.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - #3", true, cat004Item100.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - #4", false, cat004Item100.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", false, cat004Item100.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", true, cat004Item100.fspecDataAtIndex(2));
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat004Item100 cat004Item100 = new Cat004Item100();

        //act
        cat004Item100.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertNull(cat004Item100.getSubfield1());
        assertEquals("Subfield 2 not decoded correctly", "ABCDE",
                cat004Item100.getSubfield2().getCrossingAreaName());
        assertEquals("Subfield 5 not decoded correctly", "ABCDEF",
                cat004Item100.getSubfield3().getDesignator());
        assertNull(cat004Item100.getSubfield4());
        assertNull(cat004Item100.getSubfield5());
        assertEquals("Subfield 6 not decoded correctly", "ABCDEFG",
                cat004Item100.getSubfield6().getDesignator());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat004Item100 cat004Item100 = new Cat004Item100();

        //act
        int newOffset = cat004Item100.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("Offset not incremented after data decoding", SAMPLE_INPUT.length, newOffset);
    }
}
