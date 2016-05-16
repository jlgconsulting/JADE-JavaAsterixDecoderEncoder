/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.utils;

import jlg.jade.asterix.RepeatableAsterixData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class MandatoryRepeatableAsterixTests<T extends RepeatableAsterixData> {
    private final int expectedRepeatableBlockSize;
    private T asterixDataFieldInstance;
    private final byte[] defaultInputData;

    protected MandatoryRepeatableAsterixTests() {
        this.expectedRepeatableBlockSize = setExpectedRepeatableBlockSizeInBytes();
        this.defaultInputData = new byte[1 + this.expectedRepeatableBlockSize];
        final int repFactor = 1;
        this.defaultInputData[0] = repFactor;
    }

    @Before
    public void init() {
        asterixDataFieldInstance = setRepeatableAsterixDataInstance();
        if (asterixDataFieldInstance == null) {
            throw new RuntimeException("Invalid test exception. Asterix data item instance is null. Did you " +
                    "initialize it correctly in the test suite class?");
        }
    }

    @Test
    public void repeatable_block_size_should_be_correct() {
        assertEquals("Repeatable Asterix data field has invalid rep block size", expectedRepeatableBlockSize,
                asterixDataFieldInstance.getRepeatableBlockSizeInBytes());
    }

    @Test
    public void the_decode_method_should_calculate_correct_size() {
        //arrange
        int offset = 0;

        //act
        int result = asterixDataFieldInstance.decode(defaultInputData, offset, defaultInputData.length);

        //assert
        assertEquals("Repeatable Asterix data field has invalid total size", expectedRepeatableBlockSize + 1,
                asterixDataFieldInstance.getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        int offset = 0;

        //act
        int result = asterixDataFieldInstance.decode(defaultInputData, offset, defaultInputData.length);

        //assert
        assertEquals("Offset not incremented after decoding data", offset + expectedRepeatableBlockSize + 1, result);
    }


    /**
     * Set the expected and correct size of the repeatable block in bytes.
     */
    protected abstract int setExpectedRepeatableBlockSizeInBytes();

    /**
     * Instantiates a new repeatable Asterix data item that shall be used in the mandatory test suite.
     */
    protected abstract T setRepeatableAsterixDataInstance();

    public int getExpectedRepeatableBlockSize() {
        return expectedRepeatableBlockSize;
    }
}
