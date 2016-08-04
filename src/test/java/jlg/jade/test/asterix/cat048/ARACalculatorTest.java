/**
 * Created by alexandru on 8/2/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.ARACalculator;
import jlg.jade.asterix.cat048.Cat048Item260;
import jlg.jade.asterix.cat048.TCASVersion;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ARACalculatorTest {

    @Test
    @Parameters({"128, 0, Climb", "64, 0, Don’t descend", "32, 0, Don’t descend faster than 500 fpm"})
    public void the_ara_calculator_should_correctly_calculate_v604_ara_list(int secondInputByte,
                                                                            int thirdInputByte,
                                                                            String expectedAraMessage) {
        // arrange
        byte[] input = {48, (byte) secondInputByte, (byte) thirdInputByte, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();
        List<String> expectedAraList = new ArrayList<>(Arrays.asList(expectedAraMessage));

        // act
        item260.decode(input, offset, input.length);
        ARACalculator araCalculator = new ARACalculator();
        List<String> araList = araCalculator.getARAList(item260, TCASVersion.VERSION_604);

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
        ARACalculator araCalculator = new ARACalculator();
        List<String> araList = araCalculator.getARAList(item260, TCASVersion.VERSION_70);

        // assert
        assertTrue("ARA List does not match expected", expectedAraList.equals(araList));
    }
}
