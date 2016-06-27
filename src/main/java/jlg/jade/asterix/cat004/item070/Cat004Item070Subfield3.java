/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.asterix.cat004.item070;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat004 Item070 Subfield 3 - Current Horizontal Separation
 *
 * @implSpec Unit of measure is 0.5 meters
 */
public class Cat004Item070Subfield3 extends FixedLengthAsterixData {

    private int separation;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.separation = UnsignedNumericDecoder.decodeFromThreeBytes(input, offset);
        appendItemDebugMsg("Current Horizontal Separation", this.separation);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item070Subfield3 - Current Horizontal Separation";
    }

    /**
     * @return Current Horizontal Separation in 0.5 meters
     */
    public int getSeparation() {
        return separation;
    }
}
