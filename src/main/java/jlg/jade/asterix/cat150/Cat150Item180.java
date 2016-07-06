/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.RepeatableAsterixData;

/**
 * Cat150 Item190 - Controller ID
 */
public class Cat150Item180 extends RepeatableAsterixData {
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
        return "Cat150Item180 - Route Points, Speed";
    }
}
