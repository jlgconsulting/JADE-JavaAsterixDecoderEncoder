/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.utils;

import jlg.jade.asterix.cat004.item100.Cat004Item100RimcaDesignatorData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class MandatoryCat004Item100RimcaDataTests<T extends
        Cat004Item100RimcaDesignatorData> {
    private final int expectedSizeInBytes;
    private T subfieldInstance;
    private final byte[] defaultInputData;

    protected MandatoryCat004Item100RimcaDataTests() {
        this.expectedSizeInBytes = 7;
        this.defaultInputData = new byte[expectedSizeInBytes];

        if (expectedSizeInBytes == 0) {
            throw new RuntimeException(
                    "Invalid test exception. Expected size is 0. Did you initialize the size in " +
                            "bytes correctly?");
        }
    }

    @Before
    public void init() {
        subfieldInstance = setFixedLengthAsterixDataInstance();
        if (subfieldInstance == null) {
            throw new RuntimeException(
                    "Invalid test exception. Subfield instance is null. Did you initialize it " +
                            "correctly?");
        }
    }

    @Test
    public void should_have_length_correct_length() {
        assertEquals("Fixed length Asterix data field has invalid size", expectedSizeInBytes,
                subfieldInstance
                        .getSizeInBytes());
    }

    @Test
    public void the_decode_method_should_increment_offset_after_decoding_data() {
        //arrange
        int offset = 0;

        //act
        int result = subfieldInstance.decode(defaultInputData, offset, defaultInputData.length);

        //assert
        assertEquals("Offset not incremented after decoding data", offset + expectedSizeInBytes,
                result);
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {65, 66, 67, 68, 69, 70, 32};  //'ABCDEF '
        int offset = 0;

        //act
        subfieldInstance.decode(input, offset, input.length);

        //assert
        assertEquals("Data not decoded correctly", "ABCDEF", subfieldInstance.getDesignator());
    }

    /**
     * Instantiates a new fixed length Asterix data item that shall be used in the mandatory test
     * suite.
     */
    protected abstract T setFixedLengthAsterixDataInstance();
}
