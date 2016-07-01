/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.asterix.cat034.item050;

import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat034Item050Subfield6 - Specific Status information for a Mode S sensor
 */
public class Cat034Item050Subfield6 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return 2;
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item050Subfield6 - Mode S sensor";
    }
}
