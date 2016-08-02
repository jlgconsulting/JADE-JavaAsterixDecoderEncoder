/**
 * Created by alexandru on 7/21/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.AuralCalculator;
import jlg.jade.asterix.cat048.TCASVersion;
import jlg.jade.asterix.cat048.Cat048Item260;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AuralCalculatorTest {

    @Test
    public void the_aural_calculator_should_correctly_calculate_aural_for_version604() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);
        String auralCode = AuralCalculator.determineAuralCode(item260, TCASVersion.VERSION_604);

        // assert
        assertEquals("Aural code is incorrect!", "CCC, or CXC-CXC, or IC-IC, or CCN-CCN",
                     auralCode);
    }

    @Test
    public void the_aural_calculator_should_correctly_calculate_aural_for_version70() {
        // arrange
        byte[] input = {48, (byte) 128, 0, 0, 0, 0, 0};
        int offset = 0;
        Cat048Item260 item260 = new Cat048Item260();

        // act
        item260.decode(input, offset, input.length);
        String auralCode = AuralCalculator.determineAuralCode(item260, TCASVersion.VERSION_70);

        // assert
        assertEquals("Aural code is incorrect", "MVS", auralCode);
    }
}
