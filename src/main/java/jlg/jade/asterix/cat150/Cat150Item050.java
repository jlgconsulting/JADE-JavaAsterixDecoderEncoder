/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item050 - Callsign
 * Flight Identity
 */
public class Cat150Item050 extends FixedLengthAsterixData {
    private String callsign;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.callsign = new String(input, offset, this.sizeInBytes).replace(" ", "");
        appendItemDebugMsg("Callsign", this.callsign);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item050 - Callsign";
    }

    public String getCallsign() {
        return callsign;
    }
}
