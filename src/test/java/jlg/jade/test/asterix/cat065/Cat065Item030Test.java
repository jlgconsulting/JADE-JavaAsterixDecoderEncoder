/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat065;

import jlg.jade.asterix.cat065.Cat065Item030;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Cat065Item030Test extends MandatoryFixedLengthAsterixTests<Cat065Item030> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat065Item030 setFixedLengthAsterixDataInstance() {
        return new Cat065Item030();
    }

    @Test
    public void the_decode_method_shold_correctly_decode_data() {
        //arrange
        byte[] input = {103, (byte) 201, 57};
        int offset = 0;
        Cat065Item030 item030 = new Cat065Item030();

        //act
        item030.decode(input, offset, input.length);

        //assert
        assertEquals("Data nod decoded correctly", 6801721, item030.getTimeOfTrack());
    }
}
