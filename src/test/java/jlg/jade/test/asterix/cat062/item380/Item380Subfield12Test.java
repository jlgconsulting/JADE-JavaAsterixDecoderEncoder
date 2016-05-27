/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield12;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Item380Subfield12Test extends MandatoryFixedLengthAsterixTests<Item380Subfield12> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Item380Subfield12 setFixedLengthAsterixDataInstance() {
        return new Item380Subfield12();
    }

    @Test
    public void the_validate_method_should_correctly_set_valid_flag() {
        //arrange
        byte[] input = {0, 1, 2, 3, 4, 5, 6};
        int offset = 0;
        Item380Subfield12 subfield = new Item380Subfield12();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());
    }
}
