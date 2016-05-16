/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item340;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Item 340 Subfield 1 - Sensor Identification
 */
public class Item340Subfield1 extends FixedLengthAsterixData {
    private int sac;
    private int sic;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.sac = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        this.sic = UnsignedNumericDecoder.decodeFromOneByte(input, offset + 1);

        appendItemDebugMsg("SAC", this.sac);
        appendItemDebugMsg("SIC", this.sic);
    }

    public int getSac() {
        return sac;
    }

    public int getSic() {
        return sic;
    }
}
