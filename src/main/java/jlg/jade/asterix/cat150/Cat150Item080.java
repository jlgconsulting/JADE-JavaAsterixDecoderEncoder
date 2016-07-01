/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item080 - Departure Aerodrome.
 * Identification of the flight’s departure aerodrome.
 */
public class Cat150Item080 extends FixedLengthAsterixData {
    private String departureAerodrome;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.departureAerodrome = new String(input, offset, this.sizeInBytes).replace(" ", "");
        appendItemDebugMsg("Departure Aerodrome", this.departureAerodrome);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item080 - Departure Aerodrome";
    }

    public String getDepartureAerodrome() {
        return departureAerodrome;
    }
}
