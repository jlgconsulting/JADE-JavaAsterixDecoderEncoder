/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix;

import jlg.jade.asterix.Cat062AsterixAgingDataField;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for all one byte Asterix aging info
 */
public class Cat062OneByteAsterixAgingDataTest extends MandatoryFixedLengthAsterixTests<Cat062AsterixAgingDataField> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat062AsterixAgingDataField setFixedLengthAsterixDataInstance() {
        return new Cat062AsterixAgingDataField();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        //arrange
        byte[] input = {(byte) 255};
        int offset = 0;
        Cat062AsterixAgingDataField subfield1 = new Cat062AsterixAgingDataField();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals("Age was not decoded correctly", 255, subfield1.getAge());
    }

    @Test
    public void the_get_track_age_seconds_method_should_correclty_convert_age_to_sec(){
        //arrange
        byte[] input = {(byte) 8};
        int offset = 0;
        Cat062AsterixAgingDataField subfield1 = new Cat062AsterixAgingDataField();

        //act
        subfield1.decode(input, offset, input.length);

        //assert
        assertEquals(2, subfield1.getAgeSeconds(), 0.01);
    }
}
