/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item340;

import jlg.jade.asterix.cat062.item340.Cat062Item340Subfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item340Subfield3Test extends MandatoryFixedLengthAsterixTests<Cat062Item340Subfield3> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item340Subfield3 setFixedLengthAsterixDataInstance() {
        return new Cat062Item340Subfield3();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat062Item340Subfield3 subfield3 = new Cat062Item340Subfield3();

        //act
        subfield3.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly", 258, subfield3.getMeasured3dDistance());

    }
}
