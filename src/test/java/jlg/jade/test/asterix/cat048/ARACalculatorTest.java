/**
 * Created by alexandru on 8/2/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.ARACalculator;
import jlg.jade.asterix.cat048.TCASVersion;
import jlg.jade.asterix.cat048.Cat048Item260;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ARACalculatorTest {

    @Test
    public void the_ara_calculator_should_correctly_calculate_v604_ara_list() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();
        List<String> expectedAraList = new ArrayList<>(Arrays.asList("Climb"));

        // act
        item260.decode(input, offset, input.length);
        List<String> araList = ARACalculator.getARAList(item260, TCASVersion.VERSION_604);

        // assert
        assertTrue("ARA List does not match expected", expectedAraList.equals(araList));
    }

    @Test
    public void the_ara_calculator_should_correctly_calculate_v7_ara_list() {
        // arrange
        byte[] input = {48, (byte) 192, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();
        List<String> expectedAraList = new ArrayList<>(
                Arrays.asList("RA is corrective", "Upward sense RA has been generated",
                              "RA is not increased rate", "RA is not a sense reversal",
                              "RA is not altitude crossing", "RA is vertical speed limit"));

        // act
        item260.decode(input, offset, input.length);
        List<String> araList = ARACalculator.getARAList(item260, TCASVersion.VERSION_70);

        // assert
        assertTrue("ARA List does not match expected", expectedAraList.equals(araList));
    }
}
