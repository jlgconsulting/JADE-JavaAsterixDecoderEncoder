/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.test.asterix.cat004.item120;

import jlg.jade.asterix.cat004.item120.Cat004Item120;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Cat004Item120Test extends MandatoryFspecAsterixTests<Cat004Item120> {

    @Override
    protected Cat004Item120 setDataFieldInstance() {
        return new Cat004Item120();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * FSPEC = 112
     * Subfield 1 = not present
     * Subfield 2 = 1
     * Subfield 3 = 2
     * Subfield 4 = 0, 0, 1
     */
    private final byte[] sampleInput = {112, 1, 2, 0, 0, 1};

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat004Item120 item120 = new Cat004Item120();

        //act
        item120.decode(this.sampleInput, offset, this.sampleInput.length);

        //assert
        assertEquals("FSPEC actual length not correct", 1, item120.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - #1", false, item120.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #2", true, item120.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - #3", true, item120.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - #4", true, item120.fspecDataAtIndex(4));
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat004Item120 item120 = new Cat004Item120();

        //act
        item120.decode(this.sampleInput, offset, this.sampleInput.length);

        //assert
        assertNull("Subfield 1 should be null", item120.getSubfield1());
        assertEquals("Subfield 2 not decoded correctly", 1,
                item120.getSubfield2().getConflictSeverity());
        assertEquals("Subfield 3 not decoded correctly", 2,
                item120.getSubfield3().getProbability());
        assertEquals("Subfield 4 not decoded correctly", 1, item120.getSubfield4().getTime());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat004Item120 item120 = new Cat004Item120();

        //act
        int newOffset = item120.decode(this.sampleInput, offset, this.sampleInput.length);

        //assert
        assertEquals("Offset not incremented after decoding data", sampleInput.length, newOffset);
    }
}

