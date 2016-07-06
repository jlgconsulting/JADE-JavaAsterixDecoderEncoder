/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat048Item130Subfield5 - Amplitude of Primary Plot
 */
public class Cat048Item130Subfield5 extends FixedLengthAsterixData{
    private int amplitudeOfPrimaryPlot;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.amplitudeOfPrimaryPlot = TwoComplementDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Amplitude of Primary Plot", this.getAmplitudeOfPrimaryPlot());
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130Subfield5 - Amplitude of Primary Plot";
    }

    public int getAmplitudeOfPrimaryPlot() {
        return amplitudeOfPrimaryPlot;
    }
}
