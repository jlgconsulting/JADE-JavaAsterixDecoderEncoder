/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat004 Item075 - Transversal Distance Deviation
 * Transversal distance deviation for Route Adherence Monitoring,
 * in two’s complement form.
 *
 * @implSpec Unit of measure is 0.5 meters
 */
public class Cat004Item075 extends FixedLengthAsterixData {
    private int transversalDistanceDeviation;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.transversalDistanceDeviation = TwoComplementDecoder.decodeFromThreeBytes(input,offset);
        appendItemDebugMsg("Transversal Distance Deviation", this.transversalDistanceDeviation);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item075 - Transversal Distance Deviation";
    }

    /**
     * @return Transversal distance deviation expressed in units of 0.5 meters
     * @implSpec Clockwise deviation will be coded as a positive value.
     * Anticlockwise deviation will be coded as a negative value
     */
    public int getTransversalDistanceDeviation() {
        return transversalDistanceDeviation;
    }
}
