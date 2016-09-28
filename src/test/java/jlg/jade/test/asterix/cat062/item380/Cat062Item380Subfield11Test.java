/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Cat062Item380Subfield11;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Cat062Item380Subfield11Test extends MandatoryFixedLengthAsterixTests<Cat062Item380Subfield11> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item380Subfield11 setFixedLengthAsterixDataInstance() {
        return new Cat062Item380Subfield11();
    }

    @Test
    public void the_validate_method_should_correctly_set_valid_flag() {
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat062Item380Subfield11 subfield = new Cat062Item380Subfield11();

        //act
        subfield.decode(input,offset,input.length);

        //assert
        assertTrue(subfield.isValid());
    }
}

