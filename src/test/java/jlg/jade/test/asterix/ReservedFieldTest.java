/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.ReservedAsterixField;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class ReservedFieldTest {

    @Test
    public void the_decode_method_with_default_impl_should_return_minus_one() {
        //arrange
        byte[] input = {1, 2, 3, 4};
        int offset = 0;
        ReservedAsterixField re = new ReservedAsterixField(null);

        //act
        int result = re.decode(input, offset, input.length);

        //assert
        assertEquals("Unimplemented reserved field should return -1", -1, result);
    }

    @Test
    public void the_decode_method_with_custom_impl_should_correctly_decode_data() {
        //arrange
        byte[] input = {1, 2, 3, 4};
        int offset = 0;

        //create sample custom impl that takes 4 bytes and sums them up
        Function<ReservedAsterixField, Integer> parseAllBytesImpl;
        parseAllBytesImpl = reservedAsterixField -> {
            reservedAsterixField.getValues().put("sum", String.valueOf(input[offset] + input[offset + 1] +
                    input[offset + 2] + input[offset + 3]));
            return 4;
        };

        ReservedAsterixField re = new ReservedAsterixField(parseAllBytesImpl);

        //act
        int result = re.decode(input, offset, input.length);

        //assert
        assertEquals("Reserved field not decoded correctly", "10", re.getValues().get("sum"));
        assertEquals("Offset not incremented after data decoding", 4, result);

    }
}
