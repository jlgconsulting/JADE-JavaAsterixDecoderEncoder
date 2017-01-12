/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.io.UnsupportedEncodingException;

/**
 * Item 390 - Subfield 16 - Standard Instrument Arrival
 *
 * @implSpec Each one of the seven Octets contains an ASCII Character. The STAR
 * is always left adjusted. It contains up to seven alphanumeric characters, the
 * remaining character positions (if any) are padded with space characters.
 */
public class Cat062Item390Subfield16 extends FixedLengthAsterixData {
    private String standardInstrumentArrival;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            this.standardInstrumentArrival = new String(input, offset, getSizeInBytes(), "UTF-8").replace(" ", "");
            appendItemDebugMsg("STAR", this.getStandardInstrumentArrival());
        } catch (UnsupportedEncodingException e) {
            appendErrorMessage("Unsupported encoding exception");
            this.valid = false;
        }
    }

    public String getStandardInstrumentArrival() {
        return standardInstrumentArrival;
    }

    public void setStandardInstrumentArrival(String standardInstrumentArrival) {
        this.standardInstrumentArrival = standardInstrumentArrival;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item390Subfield16 - Standard Instrument Arrvial";
    }
}
