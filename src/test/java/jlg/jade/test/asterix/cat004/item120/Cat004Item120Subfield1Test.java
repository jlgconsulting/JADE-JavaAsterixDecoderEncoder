/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.test.asterix.cat004.item120;

import jlg.jade.asterix.cat004.item120.Cat004Item120Subfield1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item120Subfield1Test {
    @Test
    public void the_decode_method_should_correctly_decode_data_when_all_fields_are_1() {
        //arrange
        byte[] input = {(byte) 255, (byte) 224};
        int offset = 0;
        Cat004Item120Subfield1 subfield1 = new Cat004Item120Subfield1();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("MAS not decoded correctly", 1, subfield1.getMAS());
        assertEquals("CAS not decoded correctly", 1, subfield1.getCAS());
        assertEquals("FLD not decoded correctly", 1, subfield1.getFLD());
        assertEquals("FVD not decoded correctly", 1, subfield1.getFVD());
        assertEquals("TYPE not decoded correctly", 1, subfield1.getTypeOfInfringement());
        assertEquals("Cross not decoded correctly", 1, subfield1.getCrossingTest());
        assertEquals("Div not decoded correctly", 1, subfield1.getDivergenceTest());
        assertEquals("RRC not decoded correctly", 1, subfield1.getRRC());
        assertEquals("RTC not decoded correclty", 1, subfield1.getRTC());
        assertEquals("MRVA not decoded correctly", 1, subfield1.getMRVA());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data_when_all_fields_are_0() {
        //arrange
        byte[] input = {(byte) 1, (byte) 0};
        int offset = 0;
        Cat004Item120Subfield1 subfield1 = new Cat004Item120Subfield1();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("MAS not decoded correctly", 0, subfield1.getMAS());
        assertEquals("CAS not decoded correctly", 0, subfield1.getCAS());
        assertEquals("FLD not decoded correctly", 0, subfield1.getFLD());
        assertEquals("FVD not decoded correctly", 0, subfield1.getFVD());
        assertEquals("TYPE not decoded correctly", 0, subfield1.getTypeOfInfringement());
        assertEquals("Cross not decoded correctly", 0, subfield1.getCrossingTest());
        assertEquals("Div not decoded correctly", 0, subfield1.getDivergenceTest());
        assertEquals("RRC not decoded correctly", 0, subfield1.getRRC());
        assertEquals("RTC not decoded correclty", 0, subfield1.getRTC());
        assertEquals("MRVA not decoded correctly", 0, subfield1.getMRVA());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        byte[] input = {(byte) 1, (byte) 0};
        int offset = 0;
        Cat004Item120Subfield1 subfield1 = new Cat004Item120Subfield1();

        //act
        int result = subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", input.length, result);
    }
}
