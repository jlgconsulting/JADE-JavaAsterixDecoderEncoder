/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.io.UnsupportedEncodingException;

/**
 * Item 390 Subfield 7 - Departure airport
 * Each one of the four Octets composing the name of an airport contains an
 * ASCII Character (upper case alphabetic).
 *
 * @implSpec The Airport Names are indicated in the ICAO Location Indicators book.
 */
public class Item390Subfield7 extends FixedLengthAsterixData {
    private String departureAirport;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            this.departureAirport = new String(input, offset, getSizeInBytes(), "UTF-8").replace("", "");
        } catch (UnsupportedEncodingException e) {
            appendErrorMessage("Unsupported encoding exception");
        }
    }

    /**
     * @return The code for the departure airport as defined in ICAO Locations Indicators book
     */
    public String getDepartureAirport() {
        return departureAirport;
    }
}
