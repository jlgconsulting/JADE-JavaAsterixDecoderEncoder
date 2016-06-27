/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.asterix.cat004.item070;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat004 Item070 Subfield 6 - Estimated Minimum Vertical Separation
 *
 * @implSpec Unit of measure is 25 ft (1/4 FL)
 */
public class Cat004Item070Subfield6 extends FixedLengthAsterixData {
    private int separation;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.separation = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Estimated min. vrt. separation", this.separation);
        appendItemDebugMsg("Estimated min. vrt. separation [ft]", this.getSeparationFt());
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item070Subfield6 - Estimated min. vert. separation";
    }

    /**
     * @return The estimated minumum vertical separation in units of 25 ft
     */
    public int getSeparation() {
        return separation;
    }

    /**
     * @return The estimated minumum vertical separation expressed in feet
     */
    public int getSeparationFt() {
        return separation * 25;
    }
}
