/**
 * Created by alexandru on 7/4/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Record;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat034RecordTest extends MandatoryFspecAsterixTests<Cat034Record> {
    @Override
    protected Cat034Record setDataFieldInstance() {
        return new Cat034Record();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 2;
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        // arrange
        byte[] input = {(byte) 244, 52, 83, 2, 0, (byte) 149, (byte) 237, (byte) 168, (byte) 132, 0, 32, 0, 0};
        int offset = 0;
        Cat034Record cat034Record = new Cat034Record();

        // act
        cat034Record.decode(input, offset, input.length);

        // assert
        assertEquals("Actual FSPEC size not decoded correctly", 1,
                     cat034Record.getActualFspecSizeInBytes());
        assertEquals("FSPEC not decoded correctly - 010", true, cat034Record.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - 000", true, cat034Record.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - 030", true, cat034Record.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - 020", true, cat034Record.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - 041", false, cat034Record.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - 050", true, cat034Record.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - 060", false, cat034Record.fspecDataAtIndex(1));
        assertEquals("FSPEC not decoded correctly - 070", false, cat034Record.fspecDataAtIndex(15));
        assertEquals("FSPEC not decoded correctly - 100", false, cat034Record.fspecDataAtIndex(14));
        assertEquals("FSPEC not decoded correctly - 110", false, cat034Record.fspecDataAtIndex(13));
        assertEquals("FSPEC not decoded correctly - 120", false, cat034Record.fspecDataAtIndex(12));
        assertEquals("FSPEC not decoded correctly - 090", false, cat034Record.fspecDataAtIndex(11));
        assertEquals("FSPEC not decoded correctly - RE", false, cat034Record.fspecDataAtIndex(10));
        assertEquals("FSPEC not decoded correctly - SP", false, cat034Record.fspecDataAtIndex(9));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {(byte) 244, 52, 83, 2, 0, (byte) 149, (byte) 237, (byte) 168, (byte) 132, 0, 32, 0,};
        int offset = 0;
        Cat034Record cat034Record = new Cat034Record();

        // act
        cat034Record.decode(input, offset, input.length);

        // assert
        assertEquals("Item size is not correct", 12, cat034Record.getSizeInBytes());
        assertEquals("Item not decoded correctly - 010", 52, cat034Record.getItem010().getSac());
        assertEquals("Item not decoded correctly - 010", 83, cat034Record.getItem010().getSic());
        assertEquals("Item not decoded correctly - 000", 2,
                     cat034Record.getItem000().getMessageType().getValue());

    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        byte[] input = {(byte) 244, 52, 83, 2, 0, (byte) 149, (byte) 237, (byte) 168, (byte) 132, 0, 32, 0};
        int offset = 0;
        Cat034Record cat034Record = new Cat034Record();

        //act
        int result = cat034Record.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented correctly after decoding of data", input.length,
                     result);

    }
}
