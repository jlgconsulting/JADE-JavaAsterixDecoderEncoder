/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat048Item040 - Measured Position in Polar Co-ordinates
 * Measured position of an aircraft in local polar co-ordinates.
 */
public class Cat048Item040 extends FixedLengthAsterixData {
    private int rhoValue;
    private int thetaValue;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.rhoValue = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("RHO", this.rhoValue);

        this.thetaValue = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + 2);
        appendItemDebugMsg("THETA", this.thetaValue);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item040 - Measured Position in Polar Co-ordinates";
    }

    /**
     * @return value of RHO expressed in = 1/256 NM. Max. range = 256 NM
     */
    public int getRhoValue() {
        return rhoValue;
    }

    /**
     * @return value of THETA expressed in 360°/ 2^16 = approx. 0.0055°
     */
    public int getThetaValue() {
        return thetaValue;
    }
}
