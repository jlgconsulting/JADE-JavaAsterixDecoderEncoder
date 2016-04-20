/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.abstraction.DebugMessageSource;
import jlg.jade.abstraction.DecodableVariableLength;
import jlg.jade.abstraction.EncodableVariableLength;
import jlg.jade.cat062.AsterixCat062Record;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Represents a single Asterix message of a given category.
 */
public class AsterixRecord extends DebugMessageSource implements DecodableVariableLength, EncodableVariableLength {
    private int category;
    private AsterixCat062Record cat062Record;

    public AsterixRecord(int category) {
        this.category = category;
        switch (category) {
            case 4: {
                break;
            }
            case 34: {
                break;
            }
            case 48: {
                break;
            }
            case 62: {
                break;
            }
            case 65: {
                break;
            }
            case 150: {
                break;
            }
            default:
                throw new NotImplementedException();
        }
    }

    /**
     * Decodes the raw data to Asterix data block, containing zero or more Asterix
     * records
     *
     * @param input The raw data
     * @param offset The start offset in the raw data, at which reading should begin
     * @return The new offset in the raw data
     */
    public int decode(byte[] input, int offset) {
        return offset;
    }

    /**
     * Encodes the current Asterix record into a byte array, that can be then sent over the network
     * or written to a file.
     * @param dest The destination array
     * @param offset The start offset in array dest at which writing should begin
     * @return The new offset in the dest array, after the data has been encoded, or -1 if data can not be written because end of array has
     * been reached
     */
    public int encode(byte[] dest, int offset) {
        throw new NotImplementedException();
    }

    public int getCategory() {
        return category;
    }

    public AsterixCat062Record getCat062Record() {
        return cat062Record;
    }
}
