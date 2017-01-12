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
 * Item 390 Subfield 15 - Standard Instrumented Departure
 *
 * @implSpec Each one of the seven Octets contains an ASCII Character. The SID is
 * always left adjusted. It contains up to seven alphanumeric characters, the
 * remaining character positions (if any) are padded with space characters.
 */
public class Cat062Item390Subfield15 extends FixedLengthAsterixData {
    private String standardInstrumentDeparture;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            this.standardInstrumentDeparture = new String(input, offset, getSizeInBytes(), "UTF-8").replace(" ", "");
            appendItemDebugMsg("SID", this.standardInstrumentDeparture);
        } catch (UnsupportedEncodingException e) {
            appendErrorMessage("Unsupported encoding exception");
            valid = false;
        }
    }

    public String getStandardInstrumentDeparture() {
        return standardInstrumentDeparture;
    }

    public void setStandardInstrumentDeparture(String standardInstrumentDeparture) {
        this.standardInstrumentDeparture = standardInstrumentDeparture;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item390Subfield15 - Standard Instrumented Departure";
    }
}
