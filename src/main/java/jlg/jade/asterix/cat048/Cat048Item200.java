/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat048Item200 - Calculated Track Velocity in Polar Co-ordinates
 * Calculated track velocity expressed in polar co-ordinates.
 */
public class Cat048Item200 extends FixedLengthAsterixData {
    private int calculatedGroundSpeed;
    private int calculatedHeading;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.calculatedGroundSpeed = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.calculatedHeading = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + 2);

        appendItemDebugMsg("Calculated ground speed", this.calculatedGroundSpeed);
        appendItemDebugMsg("Calculated heading", this.calculatedHeading);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item200 - Calculated Track Velocity in Polar Co-ordinates";
    }

    /**
      * @return calculated ground speed expressed in (2^-14) NM/s = approx. 0.22 kt
     */
    public int getCalculatedGroundSpeed() {
        return calculatedGroundSpeed;
    }

    /**
     * @return calculated heading expressed in 360°/ 2^16 = approx. 0.0055°
     */
    public int getCalculatedHeading() {
        return calculatedHeading;
    }
}
