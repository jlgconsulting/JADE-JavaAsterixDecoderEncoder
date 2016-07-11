/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048.item120;

import jlg.jade.asterix.cat048.Cat048Item120;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Cat048Item120Test extends MandatoryFspecAsterixTests<Cat048Item120> {
    @Override
    protected Cat048Item120 setDataFieldInstance() {
        return new Cat048Item120();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * FSPEC = 192
     * Subfield1 - present
     * Subfield2 - present
     */
    private final byte[] sampleInput = {
            (byte) 192,
            23,
            14,
            1,
            17,
            45,
            36,
            20,
            58,
            16

    };

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        // arrange
        int offset = 0;
        Cat048Item120 item120 = new Cat048Item120();

        // act
        item120.decode(sampleInput, offset, sampleInput.length);

        // assert
        assertEquals("Actual FSPEC size is invalid", 1, item120.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - Subfield #1", true,
                     item120.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - Subfield #2", true,
                     item120.fspecDataAtIndex(6));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        int offset = 0;
        Cat048Item120 item120 = new Cat048Item120();

        // act
        item120.decode(sampleInput, offset, sampleInput.length);

        // assert
        assertNotNull(item120.getSubfield1());
        assertNotNull(item120.getSubfield2());
    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        // arrange
        int offset = 0;
        Cat048Item120 item120 = new Cat048Item120();

        // act
        int result = item120.decode(sampleInput, offset, sampleInput.length);

        // assert
        assertEquals("Offset not incremented correctly after decoding data", sampleInput.length,
                     result);
    }
}
