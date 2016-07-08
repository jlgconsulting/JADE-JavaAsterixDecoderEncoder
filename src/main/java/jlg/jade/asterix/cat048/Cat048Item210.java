/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat048Item210 - Track Quality
 * Track quality in the form of a vector of standard deviations.
 */
public class Cat048Item210 extends FixedLengthAsterixData{
    private int stdDevHorizontal;
    private int stdDevVertical;
    private int stdDevGroundspeed;
    private int stdDevHeading;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.stdDevHorizontal = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        this.stdDevVertical = UnsignedNumericDecoder.decodeFromOneByte(input, offset+1);
        this.stdDevGroundspeed = UnsignedNumericDecoder.decodeFromOneByte(input, offset+2);
        this.stdDevHeading = UnsignedNumericDecoder.decodeFromOneByte(input, offset+3);

        appendItemDebugMsg("Sigma (X) - Standard Deviation Horizontal", this.stdDevHorizontal);
        appendItemDebugMsg("Sigma (Y) - Standard Deviation Vertical", this.stdDevVertical);
        appendItemDebugMsg("Sigma (V) - Standard Deviation Groundspeed", this.stdDevGroundspeed);
        appendItemDebugMsg("Sigma (H) - Standard Deviation Heading", this.stdDevHeading);

    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item210 - Track Quality";
    }

    /**
     * @return Standard Deviation on the horizontal axis of the local grid system
     * expressed in 1/128 NM
     */
    public int getStdDevHorizontal() {
        return stdDevHorizontal;
    }

    /**
     * @return Standard Deviation on the vertical axis of the local grid system
     * expressed in 1/128 NM
     */
    public int getStdDevVertical() {
        return stdDevVertical;
    }

    /**
     * @return Standard Deviation on the groundspeed within the local grid system
     * expressed in (2^-14) NM/s = 0.22 Kt
     */
    public int getStdDevGroundspeed() {
        return stdDevGroundspeed;
    }

    /**
     * @return Standard Deviation on the heading within the local grid system
     * expressed in 360/(2^12) degrees = 0.08789
    degrees
     */
    public int getStdDevHeading() {
        return stdDevHeading;
    }
}
