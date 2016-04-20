/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.AsterixItem;
import jlg.jade.asterix.AsterixItemLength;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Cat 062 Item 015 - Service Identification - Optional
 * Identification of the service provided to one or more users
 */
public class AsterixCat062Item015 extends AsterixItem {
    private int serviceIdentification;

    public AsterixCat062Item015(){
        itemLength = AsterixItemLength.ONE_BYTE;
    }

    @Override
    public int decode(byte[] input, int offset, int length) {
        reset();
        checkLength(offset, length);

        serviceIdentification = Byte.toUnsignedInt(input[offset]);
        appendDebugMsg(String.format("%-30s %-20s", "Service identification:", serviceIdentification));
        offset++;

        return offset;
    }

    @Override
    public int encode(byte[] dest, int offset, int length) {
        throw new NotImplementedException();
    }

    @Override
    public void reset() {
        serviceIdentification = 0;
    }

    public int getServiceIdentification() {
        return serviceIdentification;
    }

}
