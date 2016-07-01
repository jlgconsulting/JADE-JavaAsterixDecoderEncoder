/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.asterix.cat034.item060;

import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat034Item060Subfield4 - PSR
 * Specific Processing Mode information for a PSR sensor
 */
public class Cat034Item060Subfield4 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return 1;
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item060Subfield4 - PSR";
    }
}
