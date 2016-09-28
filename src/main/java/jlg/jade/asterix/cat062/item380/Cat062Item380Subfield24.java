/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Item 380 Subfield 24 - Position Uncertainty
 */
public class Cat062Item380Subfield24 extends FixedLengthAsterixData{
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Subfield not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item380Subfield24 - Position Uncertainty";
    }
}
