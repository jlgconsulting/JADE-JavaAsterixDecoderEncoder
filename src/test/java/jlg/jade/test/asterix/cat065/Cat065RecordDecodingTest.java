/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat065;

import jlg.jade.asterix.cat065.Cat065Record;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat065RecordDecodingTest extends MandatoryFspecAsterixTests<Cat065Record> {
    @Override
    protected Cat065Record setDataFieldInstance() {
        return new Cat065Record();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 2;
    }


    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        byte[] input = {(byte) 248, 70, 16, 2, 0, 103, (byte) 201, 57, 99};
        int offset = 0;
        Cat065Record cat065Record = new Cat065Record();

        //act
        cat065Record.decode(input, offset, input.length);

        //assert
        assertEquals("Actual FSPEC size not decoded correctly", 1, cat065Record.getActualFspecSizeInBytes());
        assertEquals("FSPEC not decoded correctly - 010", true, cat065Record.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - 000", true, cat065Record.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - 015", true, cat065Record.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - 030", true, cat065Record.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - 020", true, cat065Record.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - 040", false, cat065Record.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - 050", false, cat065Record.fspecDataAtIndex(1));
        assertEquals("FSPEC not decoded correctly - RE", false, cat065Record.fspecDataAtIndex(10));
        assertEquals("FSPEC not decoded correctly - SP", false, cat065Record.fspecDataAtIndex(10));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {(byte) 248, 70, 16, 2, 0, 103, (byte) 201, 57, 99};
        int offset = 0;
        Cat065Record cat065Record = new Cat065Record();

        //act
        cat065Record.decode(input, offset, input.length);

        //assert
        assertEquals("Item size is not correct", 9, cat065Record.getSizeInBytes());
        assertEquals("Item not decoded correctly - 010", 70, cat065Record.getItem010().getSac());
        assertEquals("Item not decoded correctly - 010", 16, cat065Record.getItem010().getSic());
        assertEquals("Item not decoded correctly - 000", 2, cat065Record.getItem000().getMessageType());
        assertEquals("Item not decoded correctly - 015", 0, cat065Record.getItem015().getServiceIdentification());
        assertEquals("Item not decoded correctly - 030", 6801721, cat065Record.getItem030().getTime());
        assertEquals("Item not decoded correctly - 020", 99, cat065Record.getItem020().getBatchNumber());
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        byte[] input = {(byte) 248, 70, 16, 2, 0, 103, (byte) 201, 57, 99};
        int offset = 0;
        Cat065Record cat065Record = new Cat065Record();

        //act
        int result = cat065Record.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented correctly after decoding of data", input.length, result);
    }
}
