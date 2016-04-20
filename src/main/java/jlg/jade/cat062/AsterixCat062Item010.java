/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.AsterixItem;
import jlg.jade.asterix.AsterixItemLength;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Cat-062 Item 010 - Data Source Identifier - Mandatory
 * Identification of the system sending the data (SAC-SIC)
 */
public class AsterixCat062Item010 extends AsterixItem {
    private int sac;
    private int sic;

    public AsterixCat062Item010() {
        itemLength = AsterixItemLength.TWO_BYTES;
        sac = 0;
        sic = 0;
    }

    public int getSac() {
        return sac;
    }

    public int getSic() {
        return sic;
    }

    @Override
    public int decode(byte[] input, int offset, int length) {
        reset();
        checkLength(offset, length);

        sac = Byte.toUnsignedInt(input[offset]);
        sic = Byte.toUnsignedInt(input[offset + 1]);

        appendDebugMsg(String.format("%-30s %-20s", "SAC:", sac));
        appendDebugMsg(String.format("%-30s %-20s", "SAC:", sic));

        offset += offset + itemLength.getValue();
        return offset;
    }

    @Override
    public int encode(byte[] dest, int offset, int length) {
        throw new NotImplementedException();
    }

    @Override
    public void reset() {
        sac = 0;
        sic = 0;
    }
}
