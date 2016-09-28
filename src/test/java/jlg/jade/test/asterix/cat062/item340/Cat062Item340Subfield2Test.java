/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item340;

import jlg.jade.asterix.cat062.item340.Cat062Item340Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item340Subfield2Test extends MandatoryFixedLengthAsterixTests<Cat062Item340Subfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat062Item340Subfield2 setFixedLengthAsterixDataInstance() {
        return new Cat062Item340Subfield2();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {95, 8, (byte) 224, (byte) 164};
        int offset = 0;
        Cat062Item340Subfield2 subfield2 = new Cat062Item340Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly (distance)", 24328, subfield2.getMeasuredDistance());
        assertEquals("Subfield not decoded correctly (azimuth)", 57508, subfield2.getMeasuredAzimuth());
    }
}
