/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048.item120;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.RepeatableAsterixData;

/**
 * Cat048Item120Subfield2 - Raw Doppler Speed
 */
public class Cat048Item120Subfield2 extends RepeatableAsterixData {

    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.SIX_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item120Subfield2 - Raw Doppler Speed";
    }
}
