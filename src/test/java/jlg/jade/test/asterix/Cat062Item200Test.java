/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.cat062.item200.Cat062Item200;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Cat062 Item200 vertical rate not decoded correctly", expected, item200.getVerticalRate()
                .getValue());
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
                .getLongitudinalAcceleration()
                .getValue());
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
                .getTransversalAcceleration()
                .getValue());
    }


}
