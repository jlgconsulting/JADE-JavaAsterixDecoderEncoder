/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.cat062.Cat062Item135;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item135Test extends MandatoryFixedLengthAsterixTests<Cat062Item135> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item135 setFixedLengthAsterixDataInstance() {
        return new Cat062Item135();
    }

    @Test
    @Parameters({"128,0,true", "1,0,false"})
    public void the_decode_method_should_correclty_decode_qnh_info(int firstOctet, int secondOctet, boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item135 item135 = new Cat062Item135();

        //act
        item135.decode(input, offset, input.length);

        //assert
        assertEquals("QNG not decoded correctly", expected, item135.isQnhCorrectionApplied());
    }

    @Test
    @Parameters({"5,200,1480", "129,1,257", "127,1,-255"})
    public void the_decode_method_should_correctly_decode_barometric_altitude(int firstOctet, int secondOctet, int
            expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item135 item135 = new Cat062Item135();

        //act
        item135.decode(input, offset, input.length);

        //assert
        assertEquals("Barometric altitude not decoded correctly", expected, item135.getBarometricAltitude());
    }

    @Test
    public void the_get_barometric_altitude_ft_should_correclty_convert_alt_to_feet() {
        //arrange
        byte[] input = {5, (byte) 200};  //370 FL => 37000 ft
        int offset = 0;
        Cat062Item135 item135 = new Cat062Item135();

        //act
        item135.decode(input, offset, input.length);

        //assert
        assertEquals(37000, item135.getBarometricAltitudeFeet());
    }

    @Test
    @Parameters({"0,0,true", "23,112,true", "23,113,false"})
    public void the_validate_method_should_correctly_set_valid_flag(int firstOctet,
                                                                    int secondOctet,
                                                                    boolean expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item135 item135 = new Cat062Item135();

        //act
        item135.decode(input, offset, input.length);

        //assert
        assertEquals("Validation failed for barometric alt", expected, item135.isValid());
    }
}
