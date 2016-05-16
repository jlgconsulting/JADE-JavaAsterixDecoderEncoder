/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Item 390 - Subfield 1 - FPPS Identification Tag (SAC-SIC)
 */
public class Item390Subfield1 extends FixedLengthAsterixData {
    private int sac;
    private int sic;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.sac = Byte.toUnsignedInt(input[offset]);
        this.sic = Byte.toUnsignedInt(input[offset + 1]);
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
