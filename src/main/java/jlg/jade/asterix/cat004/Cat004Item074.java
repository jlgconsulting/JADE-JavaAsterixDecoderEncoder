/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.asterix.cat004;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat004 Item074 - Longitudinal Deviation
 * Longitudinal deviation for Route Adherence Monitoring, in two’s
 * complement form.
 *
 * @implSpec Unit of measure is 32 meters
 */
public class Cat004Item074 extends FixedLengthAsterixData {
    private int longitudinalDeviation;

    @Override
    protected int setSizeInBytes() {
        return 2;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.longitudinalDeviation = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Longitudinal Deviation", this.longitudinalDeviation);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item074 - Longitudinal Deviation";
    }

    /**
     * @return Longitudinal deviation expressed in units of 32 meters
     * @implSpec Longitudinal deviation will be positive if the aircraft is ahead of its
     * planned position. Longitudinal deviation will be negative if the aircraft is behind its
     * planned position.
     */
    public int getLongitudinalDeviation() {
        return longitudinalDeviation;
    }
}
