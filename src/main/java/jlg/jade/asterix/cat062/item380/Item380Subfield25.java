/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.RepeatableAsterixData;

/**
 * Item 380 Subfield 25 - Mode S MB Data
 * Repetitive starting with an one-octet Field Repetition Indicator
 * (REP) followed by at least one BDS report comprising one seven
 * octet BDS register and one octet BDS code.
 */
public class Item380Subfield25 extends RepeatableAsterixData {
    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.EIGHT_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }
}
