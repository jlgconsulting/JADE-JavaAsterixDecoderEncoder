/* 
* Created by dan-geabunea on 6/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item060;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004Item060Test {

    @Test
    public void the_decode_method_should_set_correct_size() {
        //arrange
        byte[] input = {1, 1, 0};
        int offset = 0;
        Cat004Item060 item060 = new Cat004Item060();

        //act
        item060.decode(input, offset, input.length);

        //assert
        assertEquals("Incorrect size", 3, item060.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        byte[] input = {1, 0};
        int offset = 0;
        Cat004Item060 item060 = new Cat004Item060();

        //act
        int result = item060.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", 2, result);
    }
}
