/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat034Item090 - Collimation Error
 * Averaged difference in range and in azimuth for the primary target position
 * with respect to the SSR target position as calculated by the radar station.
 * Units of measure:
 * RANGE ERROR = 1/128 NM
 * AZIMUTH ERROR = 360°/(214) = approx. 0.022°
 */
public class Cat034Item090 extends FixedLengthAsterixData {
    private int rangeError;
    private int azimuthError;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.azimuthError = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        this.rangeError = UnsignedNumericDecoder.decodeFromOneByte(input, offset+1);

        appendItemDebugMsg("AZIMUTH ERROR", this.azimuthError);
        appendItemDebugMsg("RANGE ERROR", this.rangeError);
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item090 - Collimation Error";
    }

    /**
     * @return Range error expressed in 1/128 NM
     */
    public int getRangeError() {
        return rangeError;
    }

    /**
     * @return Azimuth error expressed in 360°/(214) = approx. 0.022°
     */
    public int getAzimuthError() {
        return azimuthError;
    }
}
