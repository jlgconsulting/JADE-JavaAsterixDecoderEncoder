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
        byte[] input = {48, (byte) 128, 0, 5, 0, 29, 52};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Threat Type Indicator ", 2, item260.getThreatTypeIndicator());
        assertEquals("Item not decoded correctly - Threat Identity Data Altitude", 32423423, item260.getTIDAltitude());
        assertEquals("Item not decoded correctly - Threat Identity Data Range", 43, item260.getTIDRange());
        assertEquals("Item not decoded correctly - Threat Identity Data Bearing", 170, item260.getTIDBearing());
    }
}
