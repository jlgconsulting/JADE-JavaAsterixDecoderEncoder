/**
 * Created by alexandru on 7/21/16.
 */
package jlg.jade.test.asterix;

import jlg.jade.asterix.AuralCalculator;
import jlg.jade.asterix.TCASVersion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuralCalculatorTest {

    @Test
    public void the_aural_calculator_should_correctly_calculate_aural_for_version604() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};

        // act
        String auralCode = AuralCalculator.getAuralCode(input, TCASVersion.VERSION_604);

        // assert
        assertEquals("Aural code is incorrect!", "CCC, or CXC-CXC, or IC-IC, or CCN-CCN",
                     auralCode);
    }

    @Test
    public void the_aural_calculator_should_correcly_calculate_ara_list_for_version604() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        List<String> expectedAraList = new ArrayList<>(Arrays.asList("Climb"));

        // act
        List<String> araList = AuralCalculator.getAraList(input, TCASVersion.VERSION_604);

        // assert
        assertTrue("ARA list does not match!", expectedAraList.equals(araList));
    }
}
