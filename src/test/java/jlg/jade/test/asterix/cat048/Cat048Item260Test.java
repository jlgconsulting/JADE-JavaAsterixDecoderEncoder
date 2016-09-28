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

import static junit.framework.TestCase.assertEquals;

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

    @Override
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        int result = item260.decode(input, offset, input.length);

        // assert
        assertEquals("Offset not incremented after decoding data", 7, result);
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
    @Parameters({"5, 0, 29, 52, 4196173", "197, 97, 95, 152, 5789670", "5, 50, 166, 112, 5024156"})
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
    @Parameters({"8, 145, 10, 188, 5000, 42, 60",
            "8, 132, 66, 219, 2000, 11, 27",
            "8, 133, 64, 192, 1500, 3, 0",
            "10, 4, 65, 76, 2200, 5, 12"})
    public void the_decode_method_should_correctly_decode_threat_identity_data_altitude_range_and_bearing(
            int firstTIDByte, int secondTIDByte, int thirdTIDByte, int fourthTIDByte,
            int expectedAltitude, int expectedRange, int expectedBearing) {
        // arrange
        byte[] input = {48, (byte) 128, 0, (byte) firstTIDByte, (byte) secondTIDByte, (byte) thirdTIDByte, (byte) fourthTIDByte};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - Threat Type Indicator ", 2,
                     item260.getThreatTypeIndicator());
        assertEquals("Item not decoded correctly - Threat Identity Data Altitude", expectedAltitude,
                     item260.getTIDAltitude());
        assertEquals("Item not decoded correctly - Threat Identity Data Range", expectedRange,
                     item260.getTIDRange());
        assertEquals("Item not decoded correctly - Threat Identity Data Bearing", expectedBearing,
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
