/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048.item130;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

import static jlg.jade.common.Constants.SSR_PLOT_RUNLENGTH_TO_DEGREES;

/**
 * Cat048Item130Subfield4 - Primary Plot Run Length
 * Primary Plot Runlength, expressed as positive binary value
 */
public class Cat048Item130Subfield4 extends FixedLengthAsterixData {
    private long plotRunLength;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.plotRunLength = UnsignedNumericDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Primary Plot Run Length", this.getPlotRunlengthDegrees());
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130Subfield4 - Primary Plot Run Length";
    }

    public double getPlotRunlengthDegrees() {
        return this.plotRunLength * SSR_PLOT_RUNLENGTH_TO_DEGREES;
    }
}
