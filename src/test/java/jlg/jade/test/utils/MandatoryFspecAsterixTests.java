/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.utils;

import jlg.jade.abstraction.FspecAsterixData;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.assertEquals;

/**
 * Mandatory and minimum tests that need to written in order to cover a FSPEC Asterix
 * data field validaiton. Additional tests can be written in the concrete test class
 *
 * @param <T> The Asterix FPSEC data field type under test
 */
public abstract class MandatoryFspecAsterixTests<T extends FspecAsterixData> {
    private final int expectedMaxFspecSize;
    private T asterixDataFieldInstance;
    private byte[] defaultInputData;

    protected MandatoryFspecAsterixTests() {
        this.expectedMaxFspecSize = setExpectedMaxFspecSize();
        if (expectedMaxFspecSize == 0) {
            throw new RuntimeException("Invalid test exception. Expected max FSPEC size is 0. Did you " +
                    "initialize it correctly in the test suite class?");
        }

    }

    @Before
    public void init() {
        asterixDataFieldInstance = setDataFieldInstance();
        if (asterixDataFieldInstance == null) {
            throw new RuntimeException("Invalid test exception. Asterix data item instance is null. Did you " +
                    "initialize it correctly in the test suite class?");
        }
    }

    /**
     * Instantiate a new FSPEC Asterix data field that shall be used by the mandatory test suite.
     */
    protected abstract T setDataFieldInstance();

    /**
     * Set the expected and correct max FSPEC size for this Asterix data field in bytes
     */
    protected abstract int setExpectedMaxFspecSize();

    @Test
    public void max_fsec_size_should_be_correct() {
        assertEquals("Asterix data field has invalid FSPEC size", expectedMaxFspecSize,
                asterixDataFieldInstance.getMaxFspecSizeInBytes());
    }

    @Test
    public void the_decode_method_should_correctly_populate_fspec_field(){
        throw new NotImplementedException();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data(){
        throw new NotImplementedException();
    }

    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding(){
        throw new NotImplementedException();
    }

    public int getExpectedMaxFspecSize() {
        return expectedMaxFspecSize;
    }

}
