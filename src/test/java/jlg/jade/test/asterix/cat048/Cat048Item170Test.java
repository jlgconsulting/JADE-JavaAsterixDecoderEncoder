/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item170;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat048Item170Test {

    @Test
    public void should_have_length_correct_length() {
        // arrange
        byte[] input = {64};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Variable length Asterix data field has invalid size", 1,
                     item170.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        // arrange
        byte[] input = {76};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - CNF", 0, item170.getConfirmedTrack());
        assertEquals("Item not decoded correctly - RAD", 2,
                     item170.getSensorMaintainingTrackType());
        assertEquals("Item not decoded correctly - DOU", 0, item170.getTrackConfidenceLevel());
        assertEquals("Item not decoded correctly - MAH", 1,
                     item170.getManoeuvreDetectionInHorizontalSense());
        assertEquals("Item not decoded correctly - CDM", 2, item170.getClimbingDescendingMode());

    }

    @Test
    @Parameters({"146, 1", "96, 0"})
    public void the_decode_method_should_correctly_decode_cnf_field(int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - CNF", expected, item170.getConfirmedTrack());
    }


    @Test
    @Parameters({"128, 0", "164, 1", "200, 2", "96, 3"})
    public void the_decode_method_should_correctly_decode_rad_field(int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - RAD", expected,
                     item170.getSensorMaintainingTrackType());
    }

    @Test
    @Parameters({"16, 1", "128, 0"})
    public void the_decode_method_should_correctly_decode_dou_field(int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - DOU", expected,
                     item170.getTrackConfidenceLevel());
    }

    @Test
    @Parameters({"72, 1", "16, 0"})
    public void the_decode_method_should_correctly_decode_mah_field(int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - MAH", expected,
                     item170.getManoeuvreDetectionInHorizontalSense());
    }

    @Test
    @Parameters({"64, 0", "194, 1", "68, 2", "134, 3"})
    public void the_decode_method_should_correctly_decode_cdm_field(int inputByte, int expected) {
        // arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - CDM", expected,
                     item170.getClimbingDescendingMode());
    }

    @Test
    public void the_decode_method_should_correctly_decode_first_extent_data() {
        // arrange
        byte[] input = {(byte) 141, (byte) 208};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TRE", 1, item170.getSignalEndOfTrack());
        assertEquals("Item not decoded correctly - GHO", 1, item170.getGhostVsTrueTarget());
        assertEquals("Item not decoded correctly - SUP", 0,
                     item170.getMaintainedWithNeighbourSupport());
        assertEquals("Item not decoded correctly - TCC", 1, item170.getCoordinatePlotType());
    }

    @Test
    @Parameters({"141, 208, 1", "141, 112, 0"})
    public void the_decode_method_should_correctly_decode_first_extent_tre_field(
            int firstInnputByte, int secondInputByte, int expected) {
        // arrange
        byte[] input = {(byte) firstInnputByte, (byte) secondInputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TRE", expected, item170.getSignalEndOfTrack());
    }

    @Test
    @Parameters({"141, 208, 1", "141, 128, 0"})
    public void the_decode_method_should_correctly_decode_first_extent_gho_field(int firstInputByte,
                                                                                 int secondInputByte,
                                                                                 int expected) {
        // arrange
        byte[] input = {(byte) firstInputByte, (byte) secondInputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - GHO", expected, item170.getGhostVsTrueTarget());
    }

    @Test
    @Parameters({"141, 224, 1", "141, 208, 0"})
    public void the_decode_method_should_correctly_decode_first_extent_sup_field(int firstInputByte,
                                                                                 int secondInputByte,
                                                                                 int expected) {
        // arrange
        byte[] input = {(byte) firstInputByte, (byte) secondInputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - SUP", expected,
                     item170.getMaintainedWithNeighbourSupport());
    }

    @Test
    @Parameters({"141, 208, 1", "141, 224, 0"})
    public void the_decode_method_should_correctly_decode_first_extent_tcc_field(int firstInputByte,
                                                                                 int secondInputByte,
                                                                                 int expected) {
        // arrange
        byte[] input = {(byte) firstInputByte, (byte) secondInputByte};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        // act
        item170.decode(input, offset, input.length);

        // assert
        assertEquals("Item not decoded correctly - TCC", expected, item170.getCoordinatePlotType());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {(byte) 81, 44};
        int offset = 0;
        Cat048Item170 item170 = new Cat048Item170();

        //act
        int newOffset = item170.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 2, newOffset);

    }
}
