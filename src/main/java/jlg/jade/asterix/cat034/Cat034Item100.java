/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat034Item100 - Generic Polar Window
 * Geographical window defined in polar co-ordinates.
 * Units of measure:
 * RHO = 1/256 NM
 * THETA = 360°/(216) = approx. 0.0055°
 */
public class Cat034Item100 extends FixedLengthAsterixData{
    private int rhoStart;
    private int rhoEnd;
    private int thetaStart;
    private int thetaEnd;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.EIGHT_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.thetaEnd = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.thetaStart = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset+2);
        this.rhoEnd = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset+4);
        this.rhoStart = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset+6);

        appendItemDebugMsg("RHO-START", this.rhoStart);
        appendItemDebugMsg("RHO-END", this.rhoEnd);
        appendItemDebugMsg("THETA-START", this.thetaStart);
        appendItemDebugMsg("THETA-END", this.thetaEnd);
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item100 - Generic Polar Window";
    }

    /**
     * @return Rho Start expressed in 1/256 NM
     */
    public int getRhoStart() {
        return rhoStart;
    }

    /**
     * @return Rho End expressed in 1/256 NM
     */
    public int getRhoEnd() {
        return rhoEnd;
    }

    /**
     * @return Theta Start expressed in 360°/(216) = approx. 0.0055°
     */
    public int getThetaStart() {
        return thetaStart;
    }

    /**
     * @return Theta End expressed in 360°/(216) = approx. 0.0055°
     */
    public int getThetaEnd() {
        return thetaEnd;
    }
}
