/**
 * Created by alexandru on 8/2/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.ARACalculator;
import jlg.jade.asterix.cat048.Cat048Item230;
import jlg.jade.asterix.cat048.Cat048Item260;
import jlg.jade.asterix.cat048.TCASVersions;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ARACalculatorTest {

    @Test
    @Parameters({"128, 0, CLIMB", "64, 0, DND1", "32, 0, DND2"})
    public void the_ara_calculator_should_correctly_calculate_v604_ara_list(int secondInputByte,
                                                                            int thirdInputByte,
                                                                            String expectedAraMessage) {
        // arrange
        byte[] input = {48, (byte) secondInputByte, (byte) thirdInputByte, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item230 item230 = Mockito.mock(Cat048Item230.class);
        Mockito.when(item230.getDeterminedTCASVersion()).thenReturn(TCASVersions.Version604);
        Cat048Item260 item260 = new Cat048Item260(item230);
        List<String> expectedAraList = new ArrayList<>(Arrays.asList(expectedAraMessage));

        // act
        item260.decode(input, offset, input.length);
        ARACalculator araCalculator = new ARACalculator();
        List<String> araList = araCalculator.getARAList(item260);

        // assert
        assertTrue("ARA List does not match expected", expectedAraList.equals(araList));
    }

    @Test
    public void the_ara_calculator_should_correctly_calculate_v7_ara_list() {
        // arrange
        byte[] input = {48, (byte) 192, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item230 item230 = Mockito.mock(Cat048Item230.class);
        Mockito.when(item230.getDeterminedTCASVersion()).thenReturn(TCASVersions.Version70);
        Cat048Item260 item260 = new Cat048Item260(item230);
        List<String> expectedAraList = new ArrayList<>(
                Arrays.asList("CORRECTIVE", "UP",
                              "RATE0", "REVERSAL0",
                              "CROSSING0", "SPEED"));

        // act
        item260.decode(input, offset, input.length);
        ARACalculator araCalculator = new ARACalculator();
        List<String> araList = araCalculator.getARAList(item260);

        // assert
        assertTrue("ARA List does not match expected", expectedAraList.equals(araList));
    }
}
