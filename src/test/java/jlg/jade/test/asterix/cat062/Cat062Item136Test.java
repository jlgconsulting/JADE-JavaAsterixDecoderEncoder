/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item136;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item136Test extends MandatoryFixedLengthAsterixTests<Cat062Item136> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item136 setFixedLengthAsterixDataInstance() {
        return new Cat062Item136();
    }

    @Test
    @Parameters({"0,0,0", "1,1,257", "255,1,-255", "5,200,1480"})
    public void the_decode_method_should_correclty_decode_data(int firstOctet, int secondOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item136 item136 = new Cat062Item136();

        //act
        item136.decode(input, offset, input.length);

        //assert
        assertEquals("MFL not decoded correctly", expected, item136.getMeasuredFlightLevel());
    }

    @Test
    @Parameters({"0,0,0", "0,4,1"})
    public void the_get_measured_fl_in_fl_should_correclty_convert_asterix_mfl_to_actual_fl(
            int firstOctet, int
            secondOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item136 item136 = new Cat062Item136();

        //act
        item136.decode(input, offset, input.length);

        //assert
        assertEquals("MFL not decoded correctly", expected, item136.getMeasuredFlightLevelInFL());
    }

    @Test
    @Parameters({"255,195,false", "255,196,true", "23,112,true", "23,113,false"})
    public void the_validate_method_should_correctly_set_valid_flag(int firstOctet, int secondOctet, boolean expected) {
        /**
         * @implNote
         * Vmin = -15 FL (-60 Asterix units)
         * Vmax = 1500 FL (6000 Asterix units)
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item136 item136 = new Cat062Item136();

        //act
        item136.decode(input, offset, input.length);

        //assert
        assertEquals("Validation of MFL invalid", expected, item136.isValid());
    }

    /*
    ENCODE TEST
     */

    @Test
    public void when_altitude_is_negative_the_encode_method_should_produce_correct_byte_array(){
        //arrange
        int mfl = -255;
        Cat062Item136 cat062Item136 = new Cat062Item136();
        cat062Item136.setMeasuredFLightLevel(mfl);

        //act
        byte[] result = cat062Item136.encode();

        //assert
        byte[] expected = {(byte) 255, 1};
        assertTrue(Arrays.equals(expected, result));
    }

    @Test
    public void when_altitude_is_positive_the_encode_method_should_produce_correct_byte_array(){
        //arrange
        int mfl = 1480;
        Cat062Item136 cat062Item136 = new Cat062Item136();
        cat062Item136.setMeasuredFLightLevel(mfl);

        //act
        byte[] result = cat062Item136.encode();

        //assert
        byte[] expected = {(byte) 5, (byte) 200};
        assertTrue(Arrays.equals(expected, result));
    }
}
