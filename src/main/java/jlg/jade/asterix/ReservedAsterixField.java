/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.common.Decodable;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Function;

/**
 * Represents a reserved Asterix field, in which the implementation can be inserted as a Function at runtime.
 */
public class ReservedAsterixField extends AsterixItem implements Decodable {
    private Map<String, String> values;
    private Function<ReservedAsterixField, Integer> decodingFunction;

    /**
     * Create an Asterix reserved field with a custom implementation
     *
     * @param decodingFunction The custom implementation for this field
     */
    public ReservedAsterixField(Function<ReservedAsterixField, Integer> decodingFunction) {
        this.values = new Hashtable<>();
        this.decodingFunction = decodingFunction;
    }

    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        /**
         * @implNote
         * We have the item present, but no custom implementation function. Will log and return -1
         */
        if (decodingFunction == null) {
            appendNotImplementedMsg();
            appendDebugMsg("Reserved field not implemented. Will return -1. You might loose data if you do not " +
                    "implement this field.");
            appendNewLine();
            return -1;
        }

        int newOffset = decodingFunction.apply(this);
        for (String key : values.keySet()) {
            String value = values.get(key);
            appendItemDebugMsg(key,value);
        }
        return newOffset;
    }

    /**
     * @return The reserved field values, as a key value dictionary of Strings
     */
    public Map<String, String> getValues() {
        return values;
    }
}
