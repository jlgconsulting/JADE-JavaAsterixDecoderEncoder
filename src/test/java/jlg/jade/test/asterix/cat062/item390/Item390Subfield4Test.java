/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.item390;

import jlg.jade.asterix.cat062.item390.Item390Subfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Item390Subfield4Test extends MandatoryFixedLengthAsterixTests<Item390Subfield4> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Item390Subfield4 setFixedLengthAsterixDataInstance() {
        return new Item390Subfield4();
    }

    @Test
    @Parameters({"0,0", "64,1", "128,2", "192,3"})
    public void the_decode_method_should_correctly_decode_traffic_type(int firstOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet};
        int offset = 0;
        Item390Subfield4 subfield4 = new Item390Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("I062/390 #4 Traffic type not decoded correctly", expected, subfield4.getTrafficType());
    }

    @Test
    @Parameters({"0,0", "16,1", "32,2", "48,3"})
    public void the_decode_method_should_correctly_decode_flight_rules(int firstOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet};
        int offset = 0;
        Item390Subfield4 subfield4 = new Item390Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("I062/390 #4 Flight rules not decoded correctly", expected, subfield4.getFlightRules());
    }

    @Test
    @Parameters({"0,0", "4,1", "8,2", "12,3"})
    public void the_decode_method_should_correctly_decode_rvsm(int firstOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet};
        int offset = 0;
        Item390Subfield4 subfield4 = new Item390Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("I062/390 #4 RVSM not decoded correctly", expected, subfield4.getRvsm());
    }

    @Test
    @Parameters({"0,0", "1,1"})
    public void the_decode_method_should_correctly_decode_hpr(int firstOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet};
        int offset = 0;
        Item390Subfield4 subfield4 = new Item390Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals("I062/390 #4 HPR not decoded correctly", expected, subfield4.getPriority());
    }

    @Test
    public void the_decode_method_should_correclty_decode_all_data() {
        byte[] input = {64};
        int offset = 0;
        Item390Subfield4 subfield4 = new Item390Subfield4();

        //act
        subfield4.decode(input, offset, input.length);

        //assert
        assertEquals(1, subfield4.getTrafficType());
        assertEquals(0, subfield4.getFlightRules());
        assertEquals(0, subfield4.getRvsm());
        assertEquals(0, subfield4.getPriority());
    }
}
