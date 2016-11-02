/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.asterix.cat004.Cat004Record;
import jlg.jade.asterix.cat034.Cat034Record;
import jlg.jade.asterix.cat048.Cat048Record;
import jlg.jade.asterix.cat062.Cat062Record;
import jlg.jade.asterix.cat065.Cat065Record;
import jlg.jade.asterix.cat150.Cat150Record;
import jlg.jade.common.DebugMessageSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.AbstractMap;
import java.util.HashMap;

/**
 * Represents a single Asterix message of a given category.
 */
public class StandardAsterixRecord extends DebugMessageSource implements AsterixRecord {
    private String sacSicCode;
    private final int category;
    private Cat062Record cat062Record;
    private Cat065Record cat065Record;
    private Cat004Record cat004Record;
    private Cat034Record cat034Record;
    private Cat048Record cat048Record;
    private Cat150Record cat150Record;
    /**
     * This field is used by 3rd party applications using this library. It helps to
     * add more informaiton on the ASTERIX record, that can simplify the logic in
     * their own apps.
     *
     * @implNote No ASTERIX decoded field shall be inserted here. This will be empty. Only users can
     * add info on this list after the decoding has been done.
     */
    private AbstractMap<String, Object> additionalInfo;

    public StandardAsterixRecord(int category) {
        this.category = category;
        this.additionalInfo = new HashMap<>();
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
                this.cat048Record = new Cat048Record();
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
    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        switch (category) {
            case 4: {
                int newOffset = this.cat004Record.decode(input, offset, inputLength);
                this.sacSicCode = cat004Record.getItem010().getSac() + "/" + cat004Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 34: {
                int newOffset = this.cat034Record.decode(input, offset, inputLength);
                this.sacSicCode = cat034Record.getItem010().getSac() + "/" + cat034Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 48: {
                int newOffset = this.cat048Record.decode(input, offset, inputLength);
                this.sacSicCode = cat048Record.getItem010().getSac() + "/" + cat048Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 62: {
                int newOffset = this.cat062Record.decode(input, offset, inputLength);
                this.sacSicCode = cat062Record.getItem010().getSac() + "/" + cat062Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 65: {
                int newOffset = this.cat065Record.decode(input, offset, inputLength);
                this.sacSicCode = cat065Record.getItem010().getSac() + "/" + cat065Record
                        .getItem010().getSic();
                return newOffset;
            }
            case 150: {
                int newOffset = this.cat150Record.decode(input, offset, inputLength);
                this.sacSicCode = "NA";
                return newOffset;
            }
            default:
                throw new NotImplementedException();
        }
    }

    /**
     * Encodes the current Asterix record into a byte array, that can be then sent over the network
     * or written to a file.
     *
     * @return The new offset in the dest array, after the data has been encoded, or -1 if data
     * can not be written because end of array has
     * been reached
     */
    @Override
    public byte[] encode() {
        throw new NotImplementedException();
    }

    @Override
    public int getCategory() {
        return category;
    }

    @Override
    public Cat062Record getCat062Record() {
        return cat062Record;
    }

    @Override
    public Cat065Record getCat065Record() {
        return cat065Record;
    }

    @Override
    public Cat004Record getCat004Record() {
        return cat004Record;
    }

    @Override
    public Cat034Record getCat034Record() {
        return cat034Record;
    }

    @Override
    public Cat048Record getCat048Record() { return cat048Record; }

    @Override
    public Cat150Record getCat150Record() {
        return cat150Record;
    }

    /**
     * Dictionary of key-value pairs for extending the information of the ASTERIX record
     */
    @Override
    public AbstractMap<String, Object> getAdditionalInfo() {
        return this.additionalInfo;
    }

    /**
     * The SAC/SIC code of the Asterix Record. Cat150 message will always have NA as a value, since
     * this information is not present.
     *
     * @return
     */
    @Override
    public String getSacSicCode() {
        return sacSicCode;
    }
}
