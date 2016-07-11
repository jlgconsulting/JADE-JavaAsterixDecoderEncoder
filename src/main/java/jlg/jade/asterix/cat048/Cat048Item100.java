/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat048Item100 - Mode-C Code and Code Confidence Indicator
 * Mode-C height in Gray notation as received from the
 * transponder together with the confidence level for each reply bit
 * as provided by a MSSR/Mode S station.
 */
public class Cat048Item100 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item100 - Mode-C Code and Code Confidence Indicator";
    }
}
