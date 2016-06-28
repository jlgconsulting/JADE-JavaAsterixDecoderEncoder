/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Record;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004DecodingTest extends MandatoryFspecAsterixTests<Cat004Record> {

    private final byte[] SAMPLE_INPUT = {
            (byte) 221,
            (byte) 129,
            64,
            48,
            (byte) 255,
            7,
            32,
            (byte) 254,
            (byte) 128,
            0,
            84,
            0,
            20,
            55,
            29,
            65
    };

    @Override
    protected Cat004Record setDataFieldInstance() {
        return new Cat004Record();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 3;
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat004Record cat004Record = new Cat004Record();

        //act
        cat004Record.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("Actual FSPEC size not decoded correctly", 3,
                cat004Record.getActualFspecSizeInBytes());
        assertEquals("Number of present field is not correct", 7,
                cat004Record.getNbPresentDataFields());
        assertEquals("FSPEC not decoded correctly - 010", true, cat004Record.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - 000", true, cat004Record.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - 020", true, cat004Record.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - 040", true, cat004Record.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - 045", true, cat004Record.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - 030", true, cat004Record.fspecDataAtIndex(15));
        assertEquals("FSPEC not decoded correctly - 035", true, cat004Record.fspecDataAtIndex(22));
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat004Record cat004Record = new Cat004Record();

        //act
        cat004Record.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("Item 010 not decoded correctly", 48, cat004Record.getItem010().getSac());
        assertEquals("Item 010 not decoded correctly", 255, cat004Record.getItem010().getSic());
        assertEquals("Item 000 not decoded correctly", 7,
                cat004Record.getItem000().getMessageType());
        assertEquals("Item 020 not decoded correctly", 2162304,
                cat004Record.getItem020().getTime());
        assertEquals("Item 040 not decoded correctly", 84,
                cat004Record.getItem040().getAlertIdentifier());
        assertEquals("Item 045 not decoded correctly", 0,
                cat004Record.getItem045().getAlertStatus());
        assertEquals("Item 030 not decoded correctly", 5175,
                cat004Record.getItem030().getTrackNumber());
        assertEquals("Item 035 not decoded correctly", 7489,
                cat004Record.getItem035().getTrackNumber());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat004Record cat004Record = new Cat004Record();

        //act
        int newOffset = cat004Record.decode(SAMPLE_INPUT, offset, SAMPLE_INPUT.length);

        //assert
        assertEquals("Offset not incremented correctly after data decoding", SAMPLE_INPUT.length,
                newOffset);
    }
}
