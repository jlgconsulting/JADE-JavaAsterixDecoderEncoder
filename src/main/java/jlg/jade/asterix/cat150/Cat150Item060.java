/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item060 - Mode 3A
 * Represented as 4 characters, where zzzz means no code available/assigned
 */
public class Cat150Item060 extends FixedLengthAsterixData {
    private String modeAOctal;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.modeAOctal = new String(input, offset, this.sizeInBytes);
        appendItemDebugMsg("Mode 3A", this.modeAOctal);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item060 - Mode 3A";
    }

    /**
     * @return The Mode3A code in octal representation
     */
    public String getModeAOctal() {
        return modeAOctal;
    }
}
