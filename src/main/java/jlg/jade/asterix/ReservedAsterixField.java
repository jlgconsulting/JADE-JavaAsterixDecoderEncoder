/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.common.Decodable;
import jlg.jade.common.UnsignedNumericDecoder;

import java.util.Hashtable;
import java.util.Map;

/**
 * Represents a reserved Asterix field with defaulot behaviour:
 * - interprets the first octet as the length of the item
 * - skips the item
 * For custom implementations, you need to derive from this class ad oerride the decode method
 */
public class ReservedAsterixField extends AsterixItem implements Decodable {
    private Map<String, String> values;

    public ReservedAsterixField() {
        this.values = new Hashtable<>();
    }

    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        /**
         * @implNote
         * We have the item present, but no custom implementation function. By default, we assume that the
         * first octet represents the size of the reserved field.
         */

        appendNotImplementedMsg();
        appendDebugMsg("Using default behaviour. Read length from first octet and " +
                "skip data. You might loose data if you do not implement this field.");
        appendNewLine();

        int length = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("Length ", length);

        return offset + length;
    }

    /**
     * @return The reserved field values, as a key value dictionary of Strings
     */
    public Map<String, String> getValues() {
        return values;
    }
}
