/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.*;
import jlg.jade.asterix.AsterixItemLength;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Cat-062 Item 010 - Data Source Identifier - Mandatory
 * Identification of the system sending the data (SAC-SIC)
 */
public class AsterixCat062Item010 extends AsterixItem implements DecodableFixedLength, EncodableFixedLength {
    private int sac;
    private int sic;

    public AsterixCat062Item010() {
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
    public int decode(byte[] input, int offset) {
        reset();
        checkLength(input, offset, this.sizeInBytes);

        this.sac = Byte.toUnsignedInt(input[offset]);
        this.sic = Byte.toUnsignedInt(input[offset + 1]);

        appendItemDebugMsg("SAC:", this.sac);
        appendItemDebugMsg("SIC:", this.sic);

        offset += offset + this.sizeInBytes;
        return offset;
    }

    @Override
    public int encode(byte[] dest, int offset) {
        throw new NotImplementedException();
    }

    @Override
    public void reset() {
        this.sac = 0;
        this.sic = 0;
    }
}
