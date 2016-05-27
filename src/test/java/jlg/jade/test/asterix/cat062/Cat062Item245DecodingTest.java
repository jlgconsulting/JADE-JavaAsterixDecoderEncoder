/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.jade.asterix.cat062.Cat062Item245;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat062Item245DecodingTest {

    /**
     * This item is not used any more, so decoding it is not necessary. The only impl it has
     * is to increase the offset, without actually decoding anything.
     */

    @Test
    public void should_have_length_of_7_bytes(){
        //arrange
        Cat062Item245 item = new Cat062Item245();

        //assert
        assertEquals("Item length is invalid", 7, item.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increase_offset_by_7(){
        //arrange
        byte[] input = {1,2,3,4,5,6,7};
        Cat062Item245 item = new Cat062Item245();
        int offset = 0;

        //act
        int result = item.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented after data decoding", offset + item.getSizeInBytes(), result);
    }
}
