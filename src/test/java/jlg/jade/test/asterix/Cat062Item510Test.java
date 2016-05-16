/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.cat062.Cat062Item510;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item510Test {
    @Test
    public void should_have_correct_length() {
        //arrange
        byte[] input = {0, 0, 1, 0, 0, 0};  //2 extents of 3 octets
        int offset = 0;
        Cat062Item510 item510 = new Cat062Item510();

        //act
        item510.decode(input, offset, input.length);

        //assert
        assertEquals("Invalid item size", 6, item510.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        byte[] input = {0, 0, 1, 0, 0, 0};  //2 extents of 3 octets
        int offset = 0;
        Cat062Item510 item510 = new Cat062Item510();

        //act
        int result = item510.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after decoding of data", 6, result);
    }
}
