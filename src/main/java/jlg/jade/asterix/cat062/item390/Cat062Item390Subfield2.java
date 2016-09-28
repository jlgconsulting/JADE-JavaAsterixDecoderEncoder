/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.io.UnsupportedEncodingException;

/**
 * Item 390 Subfield 2 - Callsign
 * Each one of the seven Octets contains an ASCII Character. The
 * Callsign is always left adjusted. It contains up to seven upper-case
 * alphanumeric characters, the remaining character positions (if any)
 * are padded with space characters.
 */
public class Cat062Item390Subfield2 extends FixedLengthAsterixData {
    private String callsign;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            /**
             * @implNote Callsign encoded on 7 characters, but can have less. We need to
             * trim whitespaces at the end if need be.
             */
            this.callsign = new String(input, offset, 7, "UTF-8").replace(" ", "");
        } catch (UnsupportedEncodingException e) {
            appendDebugMsg("[ERROR] - UnsupportedEncodingException");
        }
        appendItemDebugMsg("Callsign", this.callsign);
    }

    /**
     * @return The aircraft callsign, without whitespace characters
     */
    public String getCallsign() {
        return callsign;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item390Subfield2 - Callsign";
    }
}
