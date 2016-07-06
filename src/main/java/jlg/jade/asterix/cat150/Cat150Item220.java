/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat150 Item210 - Correlated Track Number
 */
public class Cat150Item220 extends FixedLengthAsterixData {
    private int correlatedTrackNb;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.correlatedTrackNb = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.appendItemDebugMsg("Correlated Track Nb", this.correlatedTrackNb);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item220 - Correlated Track Number";
    }

    public int getCorrelatedTrackNb() {
        return correlatedTrackNb;
    }
}
