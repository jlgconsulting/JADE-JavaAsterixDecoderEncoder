/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixItem;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat-062 Item 010 - Data Source Identifier - Mandatory
 * Identification of the system sending the data (SAC-SIC)
 */
public class Cat062Item010 extends FixedLengthAsterixItem {
    private int sac;
    private int sic;

    public Cat062Item010() {
        this.sizeInBytes = AsterixItemLength.TWO_BYTES.getValue();
        this.sac = 0;
        this.sic = 0;
    }

    public int getSac() {
        return this.sac;
    }

    public int getSic() {
        return this.sic;
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {
        this.sac = Byte.toUnsignedInt(input[offset]);
        this.sic = Byte.toUnsignedInt(input[offset + 1]);

        appendItemDebugMsg("SAC:", this.sac);
        appendItemDebugMsg("SIC:", this.sic);

        offset += offset + this.sizeInBytes;
        return offset;
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }
}
