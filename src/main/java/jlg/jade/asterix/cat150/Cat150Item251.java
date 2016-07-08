/**
 * Created by Dan Geabunea on 7/8/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.RepeatableAsterixData;

/**
 * Cat150 Item251 - Tracks in conflict
 */
public class Cat150Item251 extends RepeatableAsterixData {
    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item251 - Tracks in conflict";
    }
}
