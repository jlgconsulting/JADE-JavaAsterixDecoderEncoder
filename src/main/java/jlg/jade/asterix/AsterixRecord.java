/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.asterix.cat004.Cat004Record;
import jlg.jade.asterix.cat034.Cat034Record;
import jlg.jade.asterix.cat062.Cat062Record;
import jlg.jade.asterix.cat065.Cat065Record;
import jlg.jade.asterix.cat150.Cat150Record;
import jlg.jade.common.DebugMessageSource;
import jlg.jade.common.Decodable;
import jlg.jade.common.Encodable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Represents a single Asterix message of a given category.
 */
public class AsterixRecord extends DebugMessageSource implements Decodable, Encodable {
    private final int category;
    private Cat062Record cat062Record;
    private Cat065Record cat065Record;
    private Cat004Record cat004Record;
    private Cat034Record cat034Record;
    private Cat150Record cat150Record;

    public AsterixRecord(int category) {
        this.category = category;
        switch (category) {
            case 4: {
                this.cat004Record = new Cat004Record();
                break;
            }
            case 34: {
                this.cat034Record = new Cat034Record();
                break;
            }
            case 48: {
                break;
            }
            case 62: {
                this.cat062Record = new Cat062Record();
                break;
            }
            case 65: {
                this.cat065Record = new Cat065Record();
                break;
            }
            case 150: {
                this.cat150Record = new Cat150Record();
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
     * @param input       The raw data
     * @param offset      The start offset in the raw data, at which reading should begin
     * @param inputLength The ammount of data that nees to be read from the input
     * @return The new offset in the raw data
     */
    public int decode(byte[] input, int offset, int inputLength) {
        switch (category) {
            case 4: {
                return this.cat004Record.decode(input, offset, inputLength);
            }
            case 34: {
                return this.cat034Record.decode(input, offset, inputLength);
            }
            case 48: {
                break;
            }
            case 62: {
                return this.cat062Record.decode(input, offset, inputLength);
            }
            case 65: {
                return this.cat065Record.decode(input, offset, inputLength);
            }
            case 150: {
                return this.cat150Record.decode(input, offset, inputLength);
            }
            default:
                throw new NotImplementedException();
        }

        return offset;
    }

    /**
     * Encodes the current Asterix record into a byte array, that can be then sent over the network
     * or written to a file.
     *
     * @param dest   The destination array
     * @param offset The start offset in array dest at which writing should begin
     * @return The new offset in the dest array, after the data has been encoded, or -1 if data
     * can not be written because end of array has
     * been reached
     */
    public int encode(byte[] dest, int offset) {
        throw new NotImplementedException();
    }

    public int getCategory() {
        return category;
    }

    public Cat062Record getCat062Record() {
        return cat062Record;
    }

    public Cat065Record getCat065Record() {
        return cat065Record;
    }

    public Cat004Record getCat004Record() {
        return cat004Record;
    }

    public Cat034Record getCat034Record() {
        return cat034Record;
    }

    public Cat150Record getCat150Record() {
        return cat150Record;
    }
}
