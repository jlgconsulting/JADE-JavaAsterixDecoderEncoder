/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat065;

import jlg.jade.asterix.cat065.Cat065Item000;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat065Item000Test extends MandatoryFixedLengthAsterixTests<Cat065Item000> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat065Item000 setFixedLengthAsterixDataInstance() {
        return new Cat065Item000();
    }

    @Test
    public void the_decode_method_should_correclty_decode_data(){
        //arrange
        byte[] inputData = {2};
        int offset = 0;
        Cat065Item000 item000 = new Cat065Item000();

        //act
        item000.decode(inputData, offset,inputData.length);

        //assert
        assertEquals("Data not decoded correctly", 2, item000.getMessageType());
    }
}
