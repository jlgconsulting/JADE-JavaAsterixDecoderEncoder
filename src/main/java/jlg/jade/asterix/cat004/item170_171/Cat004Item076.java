/**
 * Created by Dan Geabunea on 6/27/2016.
 */

package jlg.jade.asterix.cat004.item170_171;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat004 Item076 - Vertical Deviation
 * Vertical Deviation from planned altitude, in two’s complement form
 *
 * @implSpec Unit of measure is 25ft
 */
public class Cat004Item076 extends FixedLengthAsterixData {
    private int verticalDeviation;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.verticalDeviation = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Vertical Deviation", this.verticalDeviation);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item076 - Vertical Deviation";
    }

    /**
     * @return The vertical deviation in units of 0.25 feet
     * @implNote Deviation is positive is aircraft is above planned altitude, and negative if
     * value is bellow planned altitude
     */
    public int getVerticalDeviation() {
        return verticalDeviation;
    }
}
