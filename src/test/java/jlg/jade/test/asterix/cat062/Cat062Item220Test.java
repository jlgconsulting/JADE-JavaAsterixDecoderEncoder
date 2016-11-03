/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item220;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item220Test extends MandatoryFixedLengthAsterixTests<Cat062Item220> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item220 setFixedLengthAsterixDataInstance() {
        return new Cat062Item220();
    }

    @Test
    @Parameters({"0,0,0", "255,105,-151"})
    public void the_decode_method_should_correctly_decode_data(
            int firstOctet,
            int secondOctet,
            int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item220 item220 = new Cat062Item220();

        //act
        item220.decode(input, offset, input.length);

        //assert
        assertEquals("ROCD not decoded correctly", expected, item220.getRocd());
    }

    /*
    Encoding test
     */

    @Test
    public void the_encode_method_should_produce_correct_byte_array() {
        //arrange
        int rocd = -151;
        Cat062Item220 cat062Item220 = new Cat062Item220();
        cat062Item220.setRocd(rocd);

        //act
        byte[] result = cat062Item220.encode();

        //assert
        byte[] expected = {(byte) 255, 105};
        assertTrue("Cat062 Item220 is not encoded correctly", Arrays.equals(expected, result));
        assertEquals(cat062Item220.getSizeInBytes(), result.length);
    }

}
