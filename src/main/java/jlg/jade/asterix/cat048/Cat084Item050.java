/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat084Item050 - Mode-2 Code in Octal Representation
 * Reply to Mode-2 interrogation
 */
public class Cat084Item050 extends FixedLengthAsterixData{
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
        return "Cat084Item050 - Mode-2 Code in Octal Representation";
    }
}
