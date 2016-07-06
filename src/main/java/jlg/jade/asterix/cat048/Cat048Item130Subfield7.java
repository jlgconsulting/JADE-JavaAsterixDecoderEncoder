/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

import static jlg.jade.common.Constants.SSR_PLOT_RUNLENGTH_TO_DEGREES;

/**
 * Cat048Item130Subfield7 - Difference in Azimuth between PSR and SSR plot
 */
public class Cat048Item130Subfield7 extends FixedLengthAsterixData{
    private double azimuthDifference;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.azimuthDifference = TwoComplementDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Difference in Azimuth between PSR and SSR plot", this.azimuthDifference);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130Subfield7 - Difference in Azimuth between PSR and SSR plot";
    }

    public double getAzimuthDifferenceDegrees() {
        return this.azimuthDifference * SSR_PLOT_RUNLENGTH_TO_DEGREES;
    }
}
