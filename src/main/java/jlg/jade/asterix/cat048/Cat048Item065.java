/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat048Item065 - Mode-1 Code Confidence Indicator
 * Confidence level for each bit of a Mode-1 reply as provided by a monopulse SSR station.
 */
public class Cat048Item065 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item065 - Mode-1 Code Confidence Indicator";
    }
}
