/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat065;

import jlg.jade.asterix.cat065.Cat065Item010;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat065Item010Test extends MandatoryFixedLengthAsterixTests<Cat065Item010> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat065Item010 setFixedLengthAsterixDataInstance() {
        return new Cat065Item010();
    }

    @Test
    public void the_decode_method_should_correclt_decode_data(){
        //arrange
        byte[] input = {70, 16};
        int offset = 0;
        Cat065Item010 item010 = new Cat065Item010();

        //act
        item010.decode(input,offset,input.length);

        //assert
        assertEquals("Data not decoded correctly:SAC", 70, item010.getSac());
        assertEquals("Data not decoded correctly:SIC",16,item010.getSic());
    }
}
