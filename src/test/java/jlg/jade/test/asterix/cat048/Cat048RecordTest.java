/**
 * Created by alexandru on 8/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.cat048.Cat048Record;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Cat048RecordTest extends MandatoryFspecAsterixTests<Cat048Record> {
    @Override
    protected Cat048Record setDataFieldInstance() {
        return new Cat048Record();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    public void the_decode_method_should_correctly_populate_fspec_field() {
        // arrange
        byte[] input = {(byte) 255, (byte) 215, 3, (byte) 128, 52, 83, 0, (byte) 214, (byte) 226,
                (byte) 162, 50, 1, (byte) 148, 107, 47, (byte) 254, 13, 56, 32, (byte) 197, 67,
                (byte) 191, 25, 9, 84, (byte) 146, 77, 48, 113, 0, (byte) 206, 0, 0, (byte) 148, 104,
                64, 32, 32, 48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Record cat048Record = new Cat048Record();

        // act
        cat048Record.decode(input, offset, input.length);

        // assert

        assertEquals("Actual FSPEC size not decoded correctly", 4,
                     cat048Record.getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - 010", true, cat048Record.fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - 140", true, cat048Record.fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - 020", true, cat048Record.fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - 040", true, cat048Record.fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - 070", true, cat048Record.fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - 090", true, cat048Record.fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - 130", true, cat048Record.fspecDataAtIndex(1));

        assertEquals("FSPEC not decoded correctly - 220", true, cat048Record.fspecDataAtIndex(15));
        assertEquals("FSPEC not decoded correctly - 240", true, cat048Record.fspecDataAtIndex(14));
        assertEquals("FSPEC not decoded correctly - 250", false, cat048Record.fspecDataAtIndex(13));
        assertEquals("FSPEC not decoded correctly - 161", true, cat048Record.fspecDataAtIndex(12));
        assertEquals("FSPEC not decoded correctly - 042", false, cat048Record.fspecDataAtIndex(11));
        assertEquals("FSPEC not decoded correctly - 200", true, cat048Record.fspecDataAtIndex(10));
        assertEquals("FSPEC not decoded correctly - 170", true, cat048Record.fspecDataAtIndex(9));

        assertEquals("FSPEC not decoded correctly - 210", false, cat048Record.fspecDataAtIndex(23));
        assertEquals("FSPEC not decoded correctly - 030", false, cat048Record.fspecDataAtIndex(22));
        assertEquals("FSPEC not decoded correctly - 080", false, cat048Record.fspecDataAtIndex(21));
        assertEquals("FSPEC not decoded correctly - 100", false, cat048Record.fspecDataAtIndex(20));
        assertEquals("FSPEC not decoded correctly - 110", false, cat048Record.fspecDataAtIndex(19));
        assertEquals("FSPEC not decoded correctly - 120", false, cat048Record.fspecDataAtIndex(18));
        assertEquals("FSPEC not decoded correctly - 230", true, cat048Record.fspecDataAtIndex(17));

        assertEquals("FSPEC not decoded correctly - 260", true, cat048Record.fspecDataAtIndex(31));
        assertEquals("FSPEC not decoded correctly - 055", false, cat048Record.fspecDataAtIndex(30));
        assertEquals("FSPEC not decoded correctly - 050", false, cat048Record.fspecDataAtIndex(29));
        assertEquals("FSPEC not decoded correctly - 065", false, cat048Record.fspecDataAtIndex(28));
        assertEquals("FSPEC not decoded correctly - 060", false, cat048Record.fspecDataAtIndex(27));
        assertEquals("FSPEC not decoded correctly - SP", false, cat048Record.fspecDataAtIndex(26));
        assertEquals("FSPEC not decoded correctly - RE", false, cat048Record.fspecDataAtIndex(25));

    }

    @Override
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        // arrange
        byte[] input = {(byte) 255, (byte) 215, 3, (byte) 128, 52, 83, 0, (byte) 214, (byte) 226,
                (byte) 162, 50, 1, (byte) 148, 107, 47, (byte) 254, 13, 56, 32, (byte) 197, 67,
                (byte) 191, 25, 9, 84, (byte) 146, 77, 48, 113, 0, (byte) 206, 0, 0, (byte) 148, 104,
                64, 32, 32, 48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Record cat048Record = new Cat048Record();

        // act
        int result = cat048Record.decode(input, offset, input.length);

        // assert
        assertEquals("Offset not incremented correctly after decoding of data", input.length,
                     result);
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {(byte) 255, (byte) 215, 3, (byte) 128, 52, 83, 0, (byte) 214, (byte) 226,
                (byte) 162, 50, 1, (byte) 148, 104, 47, (byte) 254, 13, 56, 32, (byte) 197, 67,
                (byte) 191, 25, 9, 84, (byte) 146, 77, 48, 113, 0, (byte) 206, 0, 0, (byte) 148, 104,
                64, 32, 32, 48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Record cat048Record = new Cat048Record();

        // act
        cat048Record.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - SAC", 52, cat048Record.getItem010().getSac());
        assertEquals("Item not decoded correctly - SIC", 83, cat048Record.getItem010().getSic());

        assertEquals("Item not decoded correctly - Time of Day", 55010,
                     cat048Record.getItem140().getTime());

        assertEquals("Item not decoded correctly - Item020 - RAB", 1,
                     cat048Record.getItem020().getRabValue());
        assertEquals("Item not decoded correctly - Item020 - TYP", 5,
                     cat048Record.getItem020().getTypValue());

        assertEquals("Item not decoded correctly - Item040 - RHO", 12801,
                     cat048Record.getItem040().getRhoValue());
        assertEquals("Item not decoded correctly - Item040 - THETA", 37992,
                     cat048Record.getItem040().getThetaValue());

        assertEquals("Item not decoded correctly - Item070 - Mode3A Validated", true,
                     cat048Record.getItem070().getMode3AValidated());
        assertEquals("Item not decoded correctly - Item070 - Mode3A Garbled", false,
                     cat048Record.getItem070().getMode3AGarbled());
        assertEquals("Item not decoded correctly - Item070 - Mode3A Deduction", 1,
                     cat048Record.getItem070().getMode3ADeduction());
        assertEquals("Item not decoded correctly - Item070 - Mode3A", 4094,
                     cat048Record.getItem070().getMode3AReply());

        assertEquals("Item not decoded correctly - Item090 - Flight level validated", true,
                     cat048Record.getItem090().getFlightLevelValidated());
        assertEquals("Item not decoded correctly - Item090 - Flight level garbled", false,
                     cat048Record.getItem090().getFlightLevelGarbled());
        assertEquals("Item not decoded correctly - Item090 - Flight level (feet)", 84600,
                     cat048Record.getItem090().getFlightLevelFeet());

        assertEquals("Item not decoded correctly - Item130 - Amplitude of SSR Reply field present",
                     true, cat048Record.getItem130().fspecDataAtIndex(5));
        assertEquals("Item not decoded correctly - Item130 - Amplitude of SSR Reply value", -59,
                     cat048Record.getItem130().getSubfield3().getAmplitudeOfReply());

        assertEquals("Item not decoded correctly - Item220 - Aircraft Address", 4439833,
                     cat048Record.getItem220().getAircraftAddress());

        assertEquals("Item not decoded correctly - Item240 - Aircraft Identification", "BURRSSA1",
                     cat048Record.getItem240().getAircraftIdentification());

        assertEquals("Item not decoded correctly - Item161 - Track number", 206,
                     cat048Record.getItem161().getTrackNumber());

        assertEquals(
                "Item not decoded correctly - Item200 - Ground speed of calculated track velocity in polar coordinates",
                0, cat048Record.getItem200().getCalculatedGroundSpeed());
        assertEquals(
                "Item not decoded correctly - Item200 - Calculated heading of track velocity in polar coordinates",
                37992, cat048Record.getItem200().getCalculatedHeading());

        assertEquals("Item not decoded correctly - Item170 - Track status RAD", 2,
                     cat048Record.getItem170().getSensorMaintainingTrackType());

        assertEquals(
                "Item not decoded correctly - Item230 - Communications/ACAS Capability and Flight Status -- Transponder capability",
                1, cat048Record.getItem230().getCommunicationsCapability());

        assertEquals(
                "Item not decoded correctly - Item230 - Communications/ACAS Capability and Flight Status -- Flight status",
                0, cat048Record.getItem230().getFlightStatus());

        assertEquals(
                "Item not decoded correctly - Item230 - Communications/ACAS Capability and Flight Status -- ModeS Specific Service Capability",
                0, cat048Record.getItem230().getModeSSpecificServiceCapability());

        assertEquals(
                "Item not decoded correctly - Item230 - Communications/ACAS Capability and Flight Status -- Altitude Reporting Capability",
                0, cat048Record.getItem230().getAltitudeReportingCapability());

        assertEquals(
                "Item not decoded correctly - Item230 - Communications/ACAS Capability and Flight Status -- Aircraft Identification Capability",
                1, cat048Record.getItem230().getAircraftIdentificationCapability());

        assertEquals(
                "Item not decoded correctly - Item230 - Communications/ACAS Capability and Flight Status -- BDS Register 1,0 bit 16",
                0, cat048Record.getItem230().getBDS10Bit16());

        assertEquals(
                "Item not decoded correctly - Item260 - ACAS RA Report -- Threat Type Indicator", 0,
                cat048Record.getItem260().getThreatTypeIndicator());

        assertEquals("Item not decoded correctly - Item260 - ACAS RA Report -- MTI", 0,
                     cat048Record.getItem260().getMultiThreatIndicator());

    }
}
