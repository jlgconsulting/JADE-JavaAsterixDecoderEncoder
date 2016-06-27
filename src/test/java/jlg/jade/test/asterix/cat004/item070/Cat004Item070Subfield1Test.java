/* 
* Created by dan-geabunea on 6/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004.item070;

import jlg.jade.asterix.cat004.item070.Cat004Item070Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item070Subfield1Test extends MandatoryFixedLengthAsterixTests<Cat004Item070Subfield1> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat004Item070Subfield1 setFixedLengthAsterixDataInstance() {
        return new Cat004Item070Subfield1();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {103, (byte) 172, (byte) 233};
        int offset = 0;
        Cat004Item070Subfield1 subfield1 = new Cat004Item070Subfield1();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("Time information not decoded correctly", 6794473, subfield1.getTime());
    }
}
