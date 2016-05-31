/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item045;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat004Item045Test extends MandatoryFixedLengthAsterixTests<Cat004Item045> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat004Item045 setFixedLengthAsterixDataInstance() {
        return new Cat004Item045();
    }

    @Test
    @Parameters({"3,1", "5,2", "9,4", "7,3", "15,7"})
    public void the_decode_method_should_correctly_decode_data(int inputByte, int expected) {
        //arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat004Item045 item045 = new Cat004Item045();

        //act
        item045.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", expected, item045.getAlertStatus());
    }

    @Test
    @Parameters({"2,true", "6,true", "16,false", "8,true", "4,true", "31,false", "3,false"})
    public void the_validate_function_should_correctly_set_valid_flag(int inputByte, boolean expected) {
        //arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat004Item045 item045 = new Cat004Item045();

        //act
        item045.decode(input, offset, input.length);

        //assert
        assertEquals("Data not validated correctly", expected, item045.isValid());
    }
}
