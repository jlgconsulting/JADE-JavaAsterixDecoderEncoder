/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.VariableLengthAsterixData;

public class Cat048Item030 extends VariableLengthAsterixData {
    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item030 - Warning/Error Conditions";
    }
}
