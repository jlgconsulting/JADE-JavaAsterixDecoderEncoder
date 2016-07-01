/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item070 - Next Mode 3A
 * Next transponder code mode 3A of the flight
 * Unit of measure: octal representation
 */
public class Cat150Item070 extends FixedLengthAsterixData {
    private String mode3AOctal;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.mode3AOctal = new String(input, offset, this.sizeInBytes);
        appendItemDebugMsg("Next Mode-3A", this.getMode3AOctal());
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item070 - Next Mode 3A";
    }

    /**
     * @return The next Mode 3A as octal representation
     */
    public String getMode3AOctal() {
        return mode3AOctal;
    }
}
