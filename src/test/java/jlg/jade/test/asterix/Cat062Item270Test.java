/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.cat062.Cat062Item270;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item270Test {

    @Test
    @Parameters({"0,0,0,1", "1,0,0,2", "1,1,0,3"})
    public void the_decode_method_should_increment_offset_after_decoding_data(
            int firstOctet,
            int secondOctet,
            int thirdOctet,
            int expectedLength
    ) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet, (byte) thirdOctet};
        int ofset = 0;
        Cat062Item270 item270 = new Cat062Item270();

        //act
        int result = item270.decode(input, ofset, input.length);

        //assert
        assertEquals("Offset not incremented correctly after decoding data", expectedLength, result);
        assertEquals("Item current length not set correctly", expectedLength, item270.getSizeInBytes());
    }

}
