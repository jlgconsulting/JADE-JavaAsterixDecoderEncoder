/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Item 390 SUbfield 18 - Pre emergency Callsign
 *
 * @implNote Each one of the seven Octets contains an ASCII Character. The Callsign is
 * always left adjusted. It contains up to seven upper-case alphanumeric
 * characters, the remaining character positions (if any) are padded with space
 * characters
 * This subfield is used only when en emergency Mode 3/A is associated with
 * the track (I062/390 Subfield #17)
 */
public class Item390Subfield18 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Subfield not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }
}
