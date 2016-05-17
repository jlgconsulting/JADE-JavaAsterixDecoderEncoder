/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.ReservedAsterixField;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservedFieldTest {

    @Test
    public void the_decode_method_with_default_impl_should_read_length_from_first_octet_and_jump_it() {
        //arrange
        byte[] input = {4, 2, 3, 1};
        int offset = 0;
        ReservedAsterixField re = new ReservedAsterixField();

        //act
        int result = re.decode(input, offset, input.length);

        //assert
        assertEquals("Default reserved field not decoded correctly", 4, result);
    }
}
