/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item000;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat004Item000Test extends MandatoryFixedLengthAsterixTests<Cat004Item000> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat004Item000 setFixedLengthAsterixDataInstance() {
        return new Cat004Item000();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {7};
        int offset = 0;
        Cat004Item000 item000 = new Cat004Item000();

        //act
        item000.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", 7, item000.getMessageType());
    }

    @Test
    @Parameters({"0,false","1,true","19,true","20,false"})
    public void the_validate_method_should_correclty_set_valid_flag(int inputByte, boolean expected){
        //arrange
        byte[] input = {(byte) inputByte};
        int offset = 0;
        Cat004Item000 item000 = new Cat004Item000();

        //act
        item000.decode(input, offset, input.length);

        //assert
        assertEquals("Data validation not correct", expected, item000.isValid());
    }
}
