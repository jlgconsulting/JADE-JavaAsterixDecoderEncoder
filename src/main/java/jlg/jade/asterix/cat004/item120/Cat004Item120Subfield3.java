/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.asterix.cat004.item120;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat004 - Item120 - Subfield3 - Conflict Probability
 *
 * @implNote EUnit of measure is 0.5%
 */
public class Cat004Item120Subfield3 extends FixedLengthAsterixData {
    private int probability;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.probability = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("Conflict Probability", this.getProbability());
        appendItemDebugMsg("Conflict Probability Percent", this.getProbabilityPercent());
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item120Subfield3 - Conflict Probability";
    }

    @Override
    protected boolean validate() {
        final int MAX_VALUE = 200;  //200 asterix units are 100 percent
        return this.probability <= MAX_VALUE;
    }

    /**
     * @return The probability of a conflict expressed in 0.5% units
     */
    public int getProbability() {
        return probability;
    }

    /**
     * @return The probability of a conflict expressed in percentage (0-100)
     */
    public int getProbabilityPercent() {
        return probability / 2;
    }
}
