/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048.item130;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

import static jlg.jade.common.Constants.SSR_PLOT_RUNLENGTH_TO_DEGREES;

/**
 * Cat048Item130Subfield1 - SSR Plot Runlength
 * SSR plot runlength, expressed as a positive binary value.
 */
public class Cat048Item130Subfield1 extends FixedLengthAsterixData{
    private int SSRPlotRunlength;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.SSRPlotRunlength = UnsignedNumericDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("SSR Plot Runlength (dg)", this.getSSRPlotRunlength());
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130Subfield1 - SSR Plot Runlength";
    }

    /**
     * @return
     * SSR plot runlength, expressed as a positive binary value
     * LSB = 360/2^13 dg = 0.044 dg; so the total range covered is therefore from 0 to 11.21 dg.
     */
    public double getSSRPlotRunlength() {
        return this.SSRPlotRunlength * SSR_PLOT_RUNLENGTH_TO_DEGREES;
    }
}
