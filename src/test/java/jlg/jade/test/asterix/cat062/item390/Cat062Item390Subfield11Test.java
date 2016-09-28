/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item390;

import jlg.jade.asterix.cat062.item390.Cat062Item390Subfield11;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item390Subfield11Test extends MandatoryFixedLengthAsterixTests<Cat062Item390Subfield11> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item390Subfield11 setFixedLengthAsterixDataInstance() {
        return new Cat062Item390Subfield11();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat062Item390Subfield11 subfield11 = new Cat062Item390Subfield11();

        //act
        subfield11.decode(input, offset, input.length);

        //assert
        assertEquals("Item390 #11 Center not decoded correctly", 1, subfield11.getControlCenter());
        assertEquals("Item390 #11 Position not decoded correctly", 2, subfield11.getControlPosition());
    }
}
