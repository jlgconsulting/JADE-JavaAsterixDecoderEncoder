/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item130;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item130Test extends MandatoryFixedLengthAsterixTests<Cat062Item130> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item130 setFixedLengthAsterixDataInstance() {
        return new Cat062Item130();
    }

    @Test
    @Parameters({"255,1,-255", "0,0,0", "1,1,257", "21,138,5514"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet, int secondOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item130 item130 = new Cat062Item130();

        //act
        item130.decode(input, offset, input.length);

        //assert
        assertEquals("Geometric altitude not decoded correctly", expected, item130.getGeometricAltitude());
    }

    @Test
    @Parameters({"255,16,true", "255,15,false", "93,192,true", "93,193,false"})
    public void the_validate_method_should_correclty_set_valid_flag(int firstOctet, int secondOctet, boolean expected) {
        /**
         * (LSB) = 6.25 ft
         * Vmin = -1500 ft
         * Vmax = 150000 ft
         */

        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item130 item130 = new Cat062Item130();

        //act
        item130.decode(input, offset, input.length);

        //assert
        assertEquals("Geometric altitude validation failed", expected, item130.isValid());
    }

    @Test
    public void the_get_geometric_altitude_in_ft_should_return_geo_alt_in_ft() {
        //arrange
        byte[] input = {0, 25}; //6.25 * 4 => 25
        int offset = 0;
        Cat062Item130 item130 = new Cat062Item130();

        //act
        item130.decode(input, offset, input.length);

        //assert
        assertEquals(4, item130.getGeometricAltitudeFeet(), 0.001);
    }
}
