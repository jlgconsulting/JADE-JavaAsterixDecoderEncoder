/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.asterix.cat004.item070;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat004 Item070 Subfield4 - Estimated Minimum Horizontal Separation
 *
 * @implSpec Unit of measure is 0.5 meters
 */
public class Cat004Item070Subfield4 extends FixedLengthAsterixData {
    private int separation;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.separation = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Estimated Min Horizontal Separation", this.separation);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item070Subfield4 - Estimated min. hrz. separation";
    }

    /**
     * @return The minimum estimated horizontal separation in 0.5 meters
     */
    public int getSeparation() {
        return separation;
    }
}
