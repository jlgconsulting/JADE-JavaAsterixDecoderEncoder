/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.utils;

import jlg.jade.asterix.FixedLengthAsterixData;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Generic test suite for fixed length ASTERIX Items. This abstract class provides
 * a complete implementaiton for the mandatory tests. There is no need to reimplement the tests
 * in the concrete data field test classes.
 */
public abstract class MandatoryFixedLengthAsterixTests<T extends FixedLengthAsterixData> {
    private final int expectedSizeInBytes;
    private T subfieldInstance;
    private final byte[] defaultInputData;

    protected MandatoryFixedLengthAsterixTests() {
        this.expectedSizeInBytes = setExpectedItemSizeInBytes();
        this.defaultInputData = new byte[expectedSizeInBytes];

        if (expectedSizeInBytes == 0) {
            throw new RuntimeException("Invalid test exception. Expected size is 0. Did you initialize the size in " +
                    "bytes correctly?");
        }
    }

    @Before
    public void init(){
        subfieldInstance = setFixedLengthAsterixDataInstance();
        if (subfieldInstance == null) {
            throw new RuntimeException("Invalid test exception. Subfield instance is null. Did you initialize it " +
                    "correctly?");
        }
    }

    @Test
    public void should_have_length_correct_length() {
        assertEquals("Fixed length Asterix data field has invalid size", expectedSizeInBytes, subfieldInstance
                .getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        int offset = 0;

        //act
        int result = subfieldInstance.decode(defaultInputData, offset, defaultInputData.length);

        //assert
        assertEquals("Offset not incremented after decoding data", offset + expectedSizeInBytes, result);
    }

    /**
     * Set the expected and correct size of the item in bytes. This value will be used for
     * comparing the actual size of the item with the expected one.
     */
    protected abstract int setExpectedItemSizeInBytes();

    /**
     * Instantiates a new fixed length Asterix data item that shall be used in the mandatory test suite.
     */
    protected abstract T setFixedLengthAsterixDataInstance();

    public int getExpectedSizeInBytes() {
        return expectedSizeInBytes;
    }
}
