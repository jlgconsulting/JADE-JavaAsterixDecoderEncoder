/**
 * Created by alexandru on 7/14/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item260;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item260Test extends MandatoryFixedLengthAsterixTests<Cat048Item260> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Cat048Item260 setFixedLengthAsterixDataInstance() {
        return new Cat048Item260();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TTI", 0, item260.getThreatTypeIndicator());
        assertEquals("Item not decoded correctly - MTI / MTE", 0,
                     item260.getMultiThreatIndicator());
        assertEquals("Item not decoded correctly - RAT", 0, item260.getRaTerminated());
        assertTrue("RA complements list should be empty", item260.getRAComplementList().isEmpty());
    }

    @Test
    public void the_decode_method_should_correctly_decode_ara_bits() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - ARA Bit41", 1, item260.getARABit41());
    }

    @Test
    public void the_decode_method_should_correctly_decode_aural_for_v604() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        int BDSRegister10Bit39 = 0;
        Cat048Item260 item260 = new Cat048Item260(BDSRegister10Bit39);

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Aural", "CCC, or CXC-CXC, or IC-IC, or CCN-CCN", item260.getAuralCode());
    }

    @Test
    public void the_decode_method_should_correctly_decode_aural_for_v70() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        int BDSREgister10Bit39 = 1;
        Cat048Item260 item260 = new Cat048Item260(BDSREgister10Bit39);

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Aural", "MVS", item260.getAuralCode());
    }

    @Test
    public void the_decode_method_should_correctly_decode_rac_list() {
        // arrange
        byte[] input = {48, (byte) 128, 3, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();
        List<String> expectedRAComplements = new ArrayList<>(
                Arrays.asList("Do not pass below", "Do not pass above"));

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertTrue("RAC list does not match",
                   expectedRAComplements.equals(item260.getRAComplementList()));
    }

    @Test
    @Parameters({"5, 0, 29, 52, 4196173", "197, 97, 95, 152, 5789670"})
    public void the_decode_method_should_correctly_decode_threat_identity_data_as_mode_s_address(
            int fourthInputByte, int fifthInputByte, int sixtInputByte, int seventhInputByte,
            int expected) {
        // arrange
        byte[] input = {48, (byte) 128, 0, (byte) fourthInputByte, (byte) fifthInputByte,
                (byte) sixtInputByte, (byte) seventhInputByte};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Threat Type Indicator is incorrect", 1, item260.getThreatTypeIndicator());
        assertEquals("Threat Identity Data ModeS Address is incorrect", expected,
                     item260.getTIDModeSAddress());
    }

    @Test
    public void the_decode_method_should_correctly_decode_threat_identity_data_altitude_range_and_bearing() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 8, (byte) 145, 10, (byte) 188};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Threat Type Indicator ", 2,
                     item260.getThreatTypeIndicator());
        assertEquals("Item not decoded correctly - Threat Identity Data Altitude", 5000,
                     item260.getTIDAltitude());
        assertEquals("Item not decoded correctly - Threat Identity Data Range", 42,
                     item260.getTIDRange());
        assertEquals("Item not decoded correctly - Threat Identity Data Bearing", 60,
                     item260.getTIDBearing());
    }

    @Test
    @Parameters({"8, 145, 10, 5000", "8, 196, 64, 11500", "8, 192, 0, 14500", "9, 117, 64, 19800", "10, 64, 224, 78200", "8, 32, 0, -1200", "8, 129, 64, 0"})
    public void the_decode_method_should_correctly_decode_threat_identity_data_altitude(
            int firstTIDAByte, int secondTIDAByte, int thirdTIDAByte, int expected) {
        // arrange
        byte[] input = {48, (byte) 128, 0, (byte) firstTIDAByte, (byte) secondTIDAByte, (byte) thirdTIDAByte, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TID Altitude", expected,
                     item260.getTIDAltitude());
    }
}
