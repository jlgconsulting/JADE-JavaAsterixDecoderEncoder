/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.item200.Cat062Item200;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item200Test extends MandatoryFixedLengthAsterixTests<Cat062Item200> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat062Item200 setFixedLengthAsterixDataInstance() {
        return new Cat062Item200();
    }

    @Test
    @Parameters({"0,flase", "2,true"})
    public void the_decode_method_should_correctly_decode_adf(int octet, boolean expected) {
        //arrange
        byte[] input = new byte[]{(byte) octet};
        int offset = 0;
        Cat062Item200 item200 = new Cat062Item200();

        //act
        item200.decode(input, offset, input.length);

        //assert
        assertEquals("Cat062 Item200 ADF not decoded correctly", expected, item200.hasAltitudeDiscrepency());
    }

    @Test
    @Parameters({"0,0", "4,1", "8,2", "12,3"})
    public void the_decode_method_should_correctly_decode_vertical_rate(int octet, int expected) {
        //arrange
        byte[] input = new byte[]{(byte) octet};
        int offset = 0;
        Cat062Item200 item200 = new Cat062Item200();

        //act
        item200.decode(input, offset, input.length);

        //assert
        assertEquals("Cat062 Item200 vertical rate not decoded correctly", expected, item200.getVerticalRate());
    }

    @Test
    @Parameters({"0,0", "16,1", "32,2", "48,3"})
    public void the_decode_method_should_correctly_decode_longitudinal_acceleration(int octet, int expected) {
        //arrange
        byte[] input = new byte[]{(byte) octet};
        int offset = 0;
        Cat062Item200 item200 = new Cat062Item200();

        //act
        item200.decode(input, offset, input.length);

        //assert
        assertEquals("Cat062 Item200 longitudinal acc not decoded correctly", expected, item200
                .getLongitudinalAcceleration());
    }

    @Test
    @Parameters({"0,0", "64,1", "128,2", "192,3"})
    public void the_decode_method_sould_correctly_decode_transversal_acceleration(int octet, int expected) {
        //arrange
        byte[] input = new byte[]{(byte) octet};
        int offset = 0;
        Cat062Item200 item200 = new Cat062Item200();

        //act
        item200.decode(input, offset, input.length);

        //assert
        assertEquals("Cat062 Item200 transversal acc not decoded correctly", expected, item200
                .getTransversalAcceleration());
    }

    /*
    Encoding tests
     */

    @Test
    @Parameters({"false,0", "true,2"})
    public void the_encode_method_should_correctly_encode_adf(boolean adfValue, int expected) {
        //arrange
        Cat062Item200 cat062Item200 = new Cat062Item200();
        cat062Item200.setAltitudeDiscrepencyFlag(adfValue);
        cat062Item200.setLongitudinalAcceleration(0);
        cat062Item200.setTransversalAcceleration(0);
        cat062Item200.setVerticalRate(0);

        //act
        byte[] result = cat062Item200.encode();

        //assert
        byte[] expectedByteArray = {(byte) expected};
        assertTrue("Mode of movement not encoded correctly", Arrays.equals(expectedByteArray, result));
        assertEquals(cat062Item200.getSizeInBytes(), result.length);
    }

    @Test
    @Parameters({"0,0", "1,4", "2,8", "3,12"})
    public void the_encode_method_should_correctly_encode_vertical_rate(int verticalRateValue, int expected){
        //arrange
        Cat062Item200 cat062Item200 = new Cat062Item200();
        cat062Item200.setVerticalRate(verticalRateValue);
        cat062Item200.setTransversalAcceleration(0);
        cat062Item200.setLongitudinalAcceleration(0);

        //act
        byte[] result = cat062Item200.encode();

        //assert
        byte[] expectedByteArray = {(byte) expected};
        assertTrue("Mode of movement not encoded correctly", Arrays.equals(expectedByteArray, result));
        assertEquals(cat062Item200.getSizeInBytes(), result.length);
    }

    @Test
    @Parameters({"0,0", "1,16", "2,32", "3,48"})
    public void the_encode_method_should_correctly_encode_longitudinal_acceleration(int longAccValue, int expected) {
        //arrange
        Cat062Item200 cat062Item200 = new Cat062Item200();
        cat062Item200.setLongitudinalAcceleration(longAccValue);
        cat062Item200.setVerticalRate(0);
        cat062Item200.setTransversalAcceleration(0);

        //act
        byte[] result = cat062Item200.encode();

        //assert
        byte[] expectedByteArray = {(byte) expected};
        assertTrue("Mode of movement not encoded correctly", Arrays.equals(expectedByteArray, result));
        assertEquals(cat062Item200.getSizeInBytes(), result.length);
    }

    @Test
    @Parameters({"0,0", "1,64", "2,128", "3,192"})
    public void the_encode_method_should_correctly_encode_transversal_acceleration(int transversalAcc, int expected){
        //arrange
        Cat062Item200 cat062Item200 = new Cat062Item200();
        cat062Item200.setTransversalAcceleration(transversalAcc);
        cat062Item200.setLongitudinalAcceleration(0);
        cat062Item200.setVerticalRate(0);

        //act
        byte[] result = cat062Item200.encode();

        //assert
        byte[] expectedByteArray = {(byte) expected};
        assertTrue("Mode of movement not encoded correctly", Arrays.equals(expectedByteArray, result));
        assertEquals(cat062Item200.getSizeInBytes(), result.length);
    }
}
