/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.RepeatableAsterixData;

/**
 * Cat034Item070 - Message Count Values
 * Message Count values, according the various types of messages, for the last completed antenna revolution, counted between two North crossings
 */
public class Cat034Item070 extends RepeatableAsterixData{
    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item070 - Message Count Values";
    }
}
