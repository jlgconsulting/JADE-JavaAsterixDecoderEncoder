/**
 * Created by alexandru on 7/21/16.
 */
package jlg.jade.test.asterix;

import jlg.jade.asterix.AuralCalculator;
import jlg.jade.asterix.TCASVersion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
}
