/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item230;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item230Test extends MandatoryFixedLengthAsterixTests<Cat048Item230> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item230 setFixedLengthAsterixDataInstance() {
        return new Cat048Item230();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {32, (byte) 245};
        int offset = 0;
        Cat048Item230 item230 = new Cat048Item230();

        // act
        item230.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - COM", 1, item230.getCommunicationsCapability());
        assertEquals("Item not decoded correctly - STAT", 0, item230.getFlightStatus());
        assertEquals("Item not decoded correctly - SI", 0, item230.getTransponderCapability());
        assertEquals("Item not decoded correctly - MSSC", 1,
                     item230.getModeSSpecificServiceCapability());
        assertEquals("Item not decoded correctly - ARC", 1,
                     item230.getAltitudeReportingCapability());
        assertEquals("Item not decoded correctly - AIC", 1,
                     item230.getAircraftIdentificationCapability());
    }

    @Test
    @Parameters({"8, 245, 0", "32, 245, 1", "80, 245, 2", "96, 245, 3", "144, 245, 4"})
    public void the_decode_method_should_correctly_decode_com_field(int firstInputBte,
                                                                    int secondInputByte,
                                                                    int expected) {
        // arrange
        byte[] input = {(byte) firstInputBte, (byte) secondInputByte};
        int offset = 0;
        Cat048Item230 item230 = new Cat048Item230();

        // act
        item230.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - COM", expected,
                     item230.getCommunicationsCapability());
    }

    @Test
    @Parameters({"32, 245, 0", "4, 245, 1", "136, 245, 2", "140, 245, 3", "16, 245, 4", "20, 245, 5"})
    public void the_decode_method_should_correctly_decode_stat_field(int firstInputByte,
                                                                     int secondInputByte,
                                                                     int expected) {
        // arrange
        byte[] input = {(byte) firstInputByte, (byte) secondInputByte};
        int offset = 0;
        Cat048Item230 item230 = new Cat048Item230();

        // act
        item230.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - STAT", expected, item230.getFlightStatus());
    }

    @Test
    public void the_decode_method_should_correctly_decode_bds_10_register_bits() {
        // arrange
        byte[] input = {32, (byte) 255};
        int offset = 0;
        Cat048Item230 item230 = new Cat048Item230();

        // act
        item230.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - BDS 1,0 bit 16", 1, item230.getBDS10Bit16());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 37", 1, item230.getBDS10Bit37());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 38", 1, item230.getBDS10Bit38());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 39", 1, item230.getBDS10Bit39());
        assertEquals("Item not decoded correctly - BDS 1,0 bit 40", 1, item230.getBDS10Bit40());
    }
}
