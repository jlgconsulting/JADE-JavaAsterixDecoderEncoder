/**
 * Created by alexandru on 7/5/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item020;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item020Test {

    @Test
    public void should_have_length_correct_length() {
        // arrange
        byte[] input = {(byte) 168};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Variable length Asterix data field has invalid size", 1,
                     item020.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {(byte) 190};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - RAB", 1, item020.getRabValue());
        assertEquals("Item not decoded correctly - SPI", 1,
                     item020.getSpecialPosIdentificationValue());
        assertEquals("Item not decoded correctly - RDP", 1, item020.getReportFromRDPValue());
        assertEquals("Item not decoded correctly - SIM", 1,
                     item020.getSimulatedTargetReportValue());
        assertEquals("Item not decoded correctly - TYP", 5, item020.getTypValue());
    }

    @Test
    public void the_decode_method_should_correctly_decode_first_extent_data() {
        // arrange
        byte[] input = {1, (byte) 254};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - FOE/FRI", 3, item020.getFoeFriValue());
        assertEquals("Item not decoded correctly - MI", 1,
                     item020.getMilitaryIdentificationValue());
        assertEquals("Item not decoded correctly - ME", 1, item020.getMilitaryEmergencyValue());
        assertEquals("Item not decoded correctly - XPP", 1, item020.getxPulsePresentValue());
        assertEquals("Item not decoded correctly - TST", 1, item020.getTestTargetValue());
    }

    /**
     * @param inputByte represents a byte which has bits 8/6 set to correspond to the type of detection
     * @param expected  represents the integer value of the detection type
     */
    @Test
    @Parameters({"0, 0", "32, 1", "64, 2", "96, 3", "128, 4", "160, 5", "192, 6", "224, 7"})
    public void the_decode_method_should_correctly_decode_typ_field(int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TYP", expected, item020.getTypValue());
    }

    /**
     * @param inputByte represents byte with corresponding value of 1 or 0 set for SIM field
     */
    @Test
    @Parameters({"208, 1", "32, 0"})
    public void the_decode_method_should_correctly_decode_simulated_target_field(int inputByte,
                                                                                 int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - SIM", expected,
                     item020.getSimulatedTargetReportValue());
    }

    /**
     * @param inputByte represents a byte with corresponding bit set to 1 or 0 for RDP field
     */
    @Test
    @Parameters({"136, 1", "128, 0"})
    public void the_decode_method_should_correctly_decode_report_from_RDP_field(int inputByte,
                                                                                int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - RDP", expected, item020.getReportFromRDPValue());
    }

    /**
     * @param inputByte represents a byte with corresponding bit value of 1 or 0 set for SPI field
     */
    @Test
    @Parameters({"4, 1", "128, 0"})
    public void the_decode_method_should_correctly_decode_special_position_identification_field(
            int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - SPI", expected,
                     item020.getSpecialPosIdentificationValue());
    }

    /**
     * @param inputByte represents a byte with corresponding bit value of 1 or 0 set for RAB field
     */
    @Test
    @Parameters({"134, 1", "68, 0"})
    public void the_decode_method_should_correctly_decode_rab_field(int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - RAB", expected, item020.getRabValue());
    }

    /**
     * @param firstByte is a generic byte for the first part with FX = 1
     * @param secondByte represents a byte with corresponding value of 1 or 2 set for TST field
     */
    @Test
    @Parameters({"149, 128 ,1", "149, 20, 0"})
    public void the_decode_method_should_correctly_decode_first_extent_test_target_field(
            int firstByte, int secondByte, int expected) {
        // arrange
        byte[] input = {(byte) firstByte, (byte) secondByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TST", expected, item020.getTestTargetValue());
    }

    /**
     * @param firstByte is a generic byte for the first part with FX = 1
     * @param secondByte represents a byte with corresponding value of 1 or 2 set for XPP field
     */
    @Test
    @Parameters({"149, 160, 1", "149, 128, 0"})
    public void the_decode_method_should_correctly_decode_first_extent_x_pulse_present_field(
            int firstByte, int secondByte, int expected) {
        // arrange
        byte[] input = {(byte) firstByte, (byte) secondByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - XPP", expected, item020.getxPulsePresentValue());
    }

    /**
     * @param firstByte is a generic byte for the first part with FX = 1
     * @param secondByte represents a byte with corresponding value of 1 or 2 set for ME field
     */
    @Test
    @Parameters({"149, 150, 1", "149, 190, 1"})
    public void the_decode_method_should_correctly_decode_first_extent_military_emergency_field(
            int firstByte, int secondByte, int expected) {
        // arrange
        byte[] input = {(byte) firstByte, (byte) secondByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - ME", expected,
                     item020.getMilitaryEmergencyValue());
    }

    /**
     * @param firstByte is a generic byte for the first part with FX = 1
     * @param secondByte represents a byte with corresponding value of 1 or 2 set for MI field
     */
    @Test
    @Parameters({"149, 138, 1", "149, 70, 0"})
    public void the_decode_method_should_correctly_decode_first_extent_military_identification_field(
            int firstByte, int secondByte, int expected) {
        // arrange
        byte[] input = {(byte) firstByte, (byte) secondByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - MI", expected,
                     item020.getMilitaryIdentificationValue());
    }

    /**
     * @param firstByte is a generic byte for the first part with FX = 1
     * @param secondByte represents a byte with corresponding
     *                      values ( 2 bits ) set to 00, 01, 10 or 11 set for FOE/FRI field
     */
    @Test
    @Parameters({"149, 174, 3", "149, 156, 2", "149, 34, 1", "149, 184, 0"})
    public void the_decode_method_should_correctly_populate_first_extent_foe_fri_field(
            int firstByte, int secondByte, int expected) {
        // arrange
        byte[] input = {(byte) firstByte, (byte) secondByte};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        // act
        item020.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - FOE/FRI", expected, item020.getFoeFriValue());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {(byte) 168};
        int offset = 0;
        Cat048Item020 item020 = new Cat048Item020();

        //act
        int newOffset = item020.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 1, newOffset);

    }
}
