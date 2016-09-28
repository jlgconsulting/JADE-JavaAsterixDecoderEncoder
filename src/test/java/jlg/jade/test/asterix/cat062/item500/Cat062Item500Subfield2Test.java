/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item500;

import jlg.jade.asterix.cat062.item500.Cat062Item500Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat062Item500Subfield2Test extends MandatoryFixedLengthAsterixTests<Cat062Item500Subfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat062Item500Subfield2 setFixedLengthAsterixDataInstance() {
        return new Cat062Item500Subfield2();
    }

    @Test
    @Parameters({"1,1,257", "255,1,-255"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet, int secondOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Cat062Item500Subfield2 subfield2 = new Cat062Item500Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield not decoded correctly", expected, subfield2.getCovariance());
    }

}
