/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.test.asterix.cat004.item070;

import jlg.jade.asterix.cat004.item070.Cat004Item070;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item070Test extends MandatoryFspecAsterixTests<Cat004Item070> {
    @Override
    protected Cat004Item070 setDataFieldInstance() {
        return new Cat004Item070();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 1;
    }

    /**
     * FPSEC is 165 and contains #1, #3 and #6
     * Subfield1 is 1 TTC
     * Subfield2 is 2 CHS
     * Subfield3 is 3 EVMS
     */
    private final byte[] SAMPLE_INPUT = {(byte) 165, 0, 0, 1, 0, 0, 2, 0, 3};

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat004Item070 item070 = new Cat004Item070();

        //act
        item070.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("FSPEC actual length not correct", 1, item070.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - #1", true, item070.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #2", false, item070.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - #3", true, item070.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - #4", false, item070.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", false, item070.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", true, item070.fspecDataAtIndex(2));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat004Item070 item070 = new Cat004Item070();

        //act
        item070.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("Subfield #1 not decoded correctly", 1, item070.getSubfield1().getTime());
        assertEquals("Subfield #3 not decoded correctly", 2,
                item070.getSubfield3().getSeparation());
        assertEquals("Subfield #6 not decoded correctly", 3,
                item070.getSubfield6().getSeparation());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat004Item070 item070 = new Cat004Item070();

        //act
        int newOffset = item070.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("Offset not incremented after data decoding", SAMPLE_INPUT.length, newOffset);
    }
}
