/* 
* Created by dan-geabunea on 5/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Record;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;

import static org.junit.Assert.assertEquals;

public class Cat062RecordSampleTwoTest extends MandatoryFspecAsterixTests<Cat062Record> {
    @Override
    protected Cat062Record setDataFieldInstance() {
        return new Cat062Record();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 5;
    }

    private final byte[] sampleInput = {
            (byte) 191, 95, (byte) 255, 14,
            (byte) 132, 0, (byte) 160, 2, (byte) 211,
            89, 0, 126, 91, (byte) 227,
            0, 75, 35, (byte) 205, 7, 91,
            58, 5, (byte) 251, 57, 3,
            59, (byte) 253, (byte) 255, 9, (byte) 221,
            (byte) 235, 39, (byte) 241, 14, 117,
            2, (byte) 143, 52, 20, (byte) 241,
            (byte) 130, 8, 32, 83, 32,
            1, (byte) 232, 5, (byte) 200, 32,
            (byte) 245, 0, 10, 0, 5,
            (byte) 255, (byte) 238, 0, 0, 86,
            96, 8, 100, 1, 18,
            0, 105, 8, 85, 31,
            (byte) 235, 13, 19, 1, 8,
            127, (byte) 160, 27, 14, 19,
            (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255,
            (byte) 255, 0, (byte) 147, 85, 127,
            1, (byte) 224, 14, 14, 19,
            19, 19, 19, 19, 19,
            19, 19, 19, 19, 19,
            19, 19, 5, (byte) 200, 23,
            25, 5, (byte) 200, 0, 0,
            (byte) 223, (byte) 177, 0, 99, (byte) 129,
            77, 65, 83, 49, 32,
            32, 32, 64, 65, 51,
            56, 56, 76, 69, 71,
            76, 76, 87, 77, 75,
            75, 5, (byte) 200, 0, 1,
            47, 22, 26, (byte) 191, (byte) 128,
            0, 35, 0, 33, 0,
            28, 0, 41, 47, 1,
            8, 12, 1, 2, 15,
            (byte) 220, (byte) 132, 5, 95, 8,
            (byte) 224, (byte) 164, 5, (byte) 200, 9,
            (byte) 221, 64, 62
    };

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat062Record cat062Record = new Cat062Record();

        //act
        cat062Record.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("FSPEC actual size invalid", 4, cat062Record.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - 010", true, cat062Record.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - 015", true, cat062Record.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - 070", true, cat062Record.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - 105", true, cat062Record.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - 100", true, cat062Record.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - 185", true, cat062Record.fspecDataAtIndex(1));
        assertEquals("FSPEC not decoded correctly - 060", true, cat062Record.fspecDataAtIndex(14));
        assertEquals("FSPEC not decoded correctly - 380", true, cat062Record.fspecDataAtIndex(12));
        assertEquals("FSPEC not decoded correctly - 040", true, cat062Record.fspecDataAtIndex(11));
        assertEquals("FSPEC not decoded correctly - 080", true, cat062Record.fspecDataAtIndex(10));
        assertEquals("FSPEC not decoded correctly - 290", true, cat062Record.fspecDataAtIndex(9));
        assertEquals("FSPEC not decoded correctly - 200", true, cat062Record.fspecDataAtIndex(23));
        assertEquals("FSPEC not decoded correctly - 295", true, cat062Record.fspecDataAtIndex(22));
        assertEquals("FSPEC not decoded correctly - 136", true, cat062Record.fspecDataAtIndex(21));
        assertEquals("FSPEC not decoded correctly - 135", true, cat062Record.fspecDataAtIndex(19));
        assertEquals("FSPEC not decoded correctly - 220", true, cat062Record.fspecDataAtIndex(18));
        assertEquals("FSPEC not decoded correctly - 390", true, cat062Record.fspecDataAtIndex(21));
        assertEquals("FSPEC not decoded correctly - 510", true, cat062Record.fspecDataAtIndex(27));
        assertEquals("FSPEC not decoded correctly - 500", true, cat062Record.fspecDataAtIndex(26));
        assertEquals("FSPEC not decoded correctly - 340", true, cat062Record.fspecDataAtIndex(25));

        assertEquals("Nb of present data fields invalid", 21, cat062Record.getNbPresentDataFields());
    }

    @Override
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat062Record cat062Record = new Cat062Record();

        //act
        cat062Record.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Item not decoded correctly - 010", 132, cat062Record.getItem010().getSac());
        assertEquals("Item not decoded correctly - 010", 0, cat062Record.getItem010().getSic());
        assertEquals("Item not decoded correctly - 015", 160, cat062Record.getItem015().getServiceIdentification());
        assertEquals("Item not decoded correctly - 070", 185177, cat062Record.getItem070().getTime());
        assertEquals("Item not decoded correctly - 105", 8281059, cat062Record.getItem105().getLatitudeWsg84());
        assertEquals("Item not decoded correctly - 105", 4924365, cat062Record.getItem105().getLongitudeWsg84());
        assertEquals("Item not decoded correctly - 100", 482106, cat062Record.getItem100().getX());
        assertEquals("Item not decoded correctly - 100", 391993, cat062Record.getItem100().getY());
        assertEquals("Item not decoded correctly - 185", 827, cat062Record.getItem185().getVx());
        assertEquals("Item not decoded correctly - 185", -513, cat062Record.getItem185().getVy());
        assertEquals("Item not decoded correctly - 060", false, cat062Record.getItem060().getModeAChange());
        assertEquals("Item not decoded correctly - 060", 2525, cat062Record.getItem060().getModeADecimal());
        assertEquals("Item not decoded correctly - 380", 21280, cat062Record.getItem380().getSubfield3()
                .getMagneticHeading());
        assertEquals("Item not decoded correctly - 380", 488, cat062Record.getItem380().getSubfield5()
                .getTrueAirSpeedKn());
        assertEquals("Item not decoded correctly - 380", 1480, cat062Record.getItem380().getSubfield7()
                .getSelectedAltitude());
        assertEquals("Item not decoded correctly - 380", 10, cat062Record.getItem380().getSubfield13()
                .getBarometricVerticalRate());
        assertEquals("Item not decoded correctly - 380", 5, cat062Record.getItem380().getSubfield14()
                .getGeometricVerticalRate());
        assertEquals("Item not decoded correctly - 380", -18, cat062Record.getItem380().getSubfield15()
                .getRollAngle());
        assertEquals("Item not decoded correctly - 380", 22112, cat062Record.getItem380().getSubfield17()
                .getTrackAngle());
        assertEquals("Item not decoded correctly - 380", 2148, cat062Record.getItem380().getSubfield18()
                .getGroundSpeed());
        assertEquals("Item not decoded correctly - 380", 274, cat062Record.getItem380().getSubfield26()
                .getIndicatedAirSpeed());
        assertEquals("Item not decoded correctly - 380", 105, cat062Record.getItem380().getSubfield27()
                .getMachNumber());
        assertEquals("Item not decoded correctly - 136", 370, cat062Record.getItem136().getMeasuredFlightLevelInFL());
        assertEquals("Item not decoded correctly - 130", 5913, cat062Record.getItem130().getGeometricAltitude());
        assertEquals("Item not decoded correctly - 135", false, cat062Record.getItem135().isQnhCorrectionApplied());
        assertEquals("Item not decoded correctly - 135", 37000, cat062Record.getItem135().getBarometricAltitudeFeet());
        assertEquals("Item not decoded correctly - 220", 0, cat062Record.getItem220().getRocd());
        assertEquals("Item not decoded correctly - 390", "MAS1", cat062Record.getItem390().getSubfield2()
                .getCallsign());
        assertEquals("Item not decoded correctly - 390", 1, cat062Record.getItem390().getSubfield4()
                .getTrafficType());
        assertEquals("Item not decoded correctly - 390", 0, cat062Record.getItem390().getSubfield4()
                .getFlightRules());
        assertEquals("Item not decoded correctly - 390", 0, cat062Record.getItem390().getSubfield4()
                .getRvsm());
        assertEquals("Item not decoded correctly - 390", "A388", cat062Record.getItem390().getSubfield5()
                .getTypeOfAircraft());
        assertEquals("Item not decoded correctly - 390", "L", cat062Record.getItem390().getSubfield6()
                .getWakeTurbulenceCategory());
        assertEquals("Item not decoded correctly - 390", "EGLL", cat062Record.getItem390().getSubfield7()
                .getDepartureAirport());
        assertEquals("Item not decoded correctly - 390", "WMKK", cat062Record.getItem390().getSubfield8()
                .getDestinationAirport());
        assertEquals("Item not decoded correctly - 390", 1480, cat062Record.getItem390().getSubfield10()
                .getCfl());
        assertEquals("Item not decoded correctly - 390", 0, cat062Record.getItem390().getSubfield11()
                .getControlCenter());
        assertEquals("Item not decoded correctly - 390", 1, cat062Record.getItem390().getSubfield11()
                .getControlPosition());
    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat062Record cat062Record = new Cat062Record();

        //act
        int result = cat062Record.decode(sampleInput, offset, sampleInput.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 177, result);
    }
}
