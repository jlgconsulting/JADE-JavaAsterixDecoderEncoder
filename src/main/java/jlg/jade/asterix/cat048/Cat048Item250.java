/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.RepeatableAsterixData;

/**
 * Cat048Item250 - Mode S MB Data
 * Mode S Comm B data as extracted from the aircraft transponder.
 */
public class Cat048Item250 extends RepeatableAsterixData {
    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.EIGHT_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item250 - Mode S MB Data";
    }
}
