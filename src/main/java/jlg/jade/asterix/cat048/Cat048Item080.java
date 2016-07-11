/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat048Item080 - Mode-3/A Code Confidence Indicator
 * Confidence level for each bit of a Mode-3/A reply as provided by a monopulse SSR station.
 */
public class Cat048Item080 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item080 - Mode-3/A Code Confidence Indicator";
    }
}
