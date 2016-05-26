/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.asterix.cat062.item390.Cat062Item390;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;

import static org.junit.Assert.assertEquals;

public class Cat062Item390Test extends MandatoryFspecAsterixTests<Cat062Item390> {
    @Override
    protected Cat062Item390 setDataFieldInstance() {
        return new Cat062Item390();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 3;
    }

    private final byte[] inputSample = {
            (byte) 223,
            (byte) 177,
            0,
            99,
            (byte) 129,
            77,
            65,
            83,
            49,
            32,
            32,
            32,
            64,
            65,
            51,
            56,
            56,
            76,
            69,
            71,
            76,
            76,
            87,
            77,
            75,
            75,
            5,
            (byte) 200,
            0, 1
    };

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat062Item390 item390 = new Cat062Item390();

        //act
        item390.decode(inputSample, offset, inputSample.length);

        //assert
        assertEquals("FSPEC not decoded correctly - #1", true, item390.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #2", true, item390.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - #3", false, item390.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - #4", true, item390.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", true, item390.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", true, item390.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - #7", true, item390.fspecDataAtIndex(1));
        assertEquals("FSPEC not decoded correctly - #8", true, item390.fspecDataAtIndex(15));
        assertEquals("FSPEC not decoded correctly - #9", false, item390.fspecDataAtIndex(14));
        assertEquals("FSPEC not decoded correctly - #10", true, item390.fspecDataAtIndex(13));
        assertEquals("FSPEC not decoded correctly - #11", true, item390.fspecDataAtIndex(12));
        assertEquals("FSPEC not decoded correctly - #12", false, item390.fspecDataAtIndex(11));
        assertEquals("FSPEC not decoded correctly - #13", false, item390.fspecDataAtIndex(10));
        assertEquals("FSPEC not decoded correctly - #14", false, item390.fspecDataAtIndex(9));
        assertEquals("FSPEC not decoded correctly - #15", false, item390.fspecDataAtIndex(23));
        assertEquals("FSPEC not decoded correctly - #16", false, item390.fspecDataAtIndex(22));
        assertEquals("FSPEC not decoded correctly - #17", false, item390.fspecDataAtIndex(21));
        assertEquals("FSPEC not decoded correctly - #18", false, item390.fspecDataAtIndex(22));
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat062Item390 item390 = new Cat062Item390();

        //act
        item390.decode(inputSample, offset, inputSample.length);

        //assert
        assertEquals("Item390 not decoded correctly - #1", 99, item390.getSubfield1().getSac());
        assertEquals("Item390 not decoded correctly - #1", 129, item390.getSubfield1().getSic());
        assertEquals("Item390 not decoded correctly - #2", "MAS1", item390.getSubfield2().getCallsign());
        assertEquals("Item390 not decoded correctly - #4", 1, item390.getSubfield4().getTrafficType());
        assertEquals("Item390 not decoded correctly - #4", 0, item390.getSubfield4().getRvsm());
        assertEquals("Item390 not decoded correctly - #4", 0, item390.getSubfield4().getFlightRules());
        assertEquals("Item390 not decoded correctly - #5", "A388", item390.getSubfield5().getTypeOfAircraft());
        assertEquals("Item390 not decoded correctly - #6", "L", item390.getSubfield6().getWakeTurbulenceCategory());
        assertEquals("Item390 not decoded correctly - #7", "EGLL", item390.getSubfield7().getDepartureAirport());
        assertEquals("Item390 not decoded correctly - #8", "WMKK", item390.getSubfield8().getDestinationAirport());
        assertEquals("Item390 not decoded correctly - #10", 1480, item390.getSubfield10().getCfl());
        assertEquals("Item390 not decoded correctly - #11", 0, item390.getSubfield11().getControlCenter());
        assertEquals("Item390 not decoded correctly - #11", 1, item390.getSubfield11().getControlPosition());
    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat062Item390 item390 = new Cat062Item390();

        //act
        int result = item390.decode(inputSample, offset, inputSample.length);

        //assert
        assertEquals("Offset not incremented correctly after decoding of data", inputSample.length, result);
    }
}
