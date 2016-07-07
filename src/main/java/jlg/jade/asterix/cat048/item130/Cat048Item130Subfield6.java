/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048.item130;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat048Item130Subfield6 - Difference in Range between PSR and SSR plot
 */
public class Cat048Item130Subfield6 extends FixedLengthAsterixData{
    private int rangeDifference;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.rangeDifference = TwoComplementDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Difference in Range between PSR and SSR plot", this.getRangeDifference());
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130Subfield6 - Difference in Range between PSR and SSR plot";
    }

    public int getRangeDifference() {
        return rangeDifference;
    }
}
