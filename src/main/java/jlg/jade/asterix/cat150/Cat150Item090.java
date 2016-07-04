/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item090 - Destination Aerodrome
 * Identification of the flight’s destination aerodrome.
 */
public class Cat150Item090 extends FixedLengthAsterixData {
    private String destinationAerodrome;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.destinationAerodrome = new String(input, offset, this.sizeInBytes).replace(" ", "");
        appendItemDebugMsg("Destination Aerodrome", this.destinationAerodrome);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item090 - Destination Aerodrome";
    }

    public String getDestinationAerodrome() {
        return destinationAerodrome;
    }
}
