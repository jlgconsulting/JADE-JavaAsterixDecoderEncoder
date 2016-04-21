/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.*;
import jlg.jade.asterix.AsterixItemLength;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Cat 062 Item 015 - Service Identification - Optional
 * Identification of the service provided to one or more users
 */
public class AsterixCat062Item015 extends AsterixItem implements DecodableFixedLength, EncodableFixedLength {
    private int serviceIdentification;

    public AsterixCat062Item015(){
        sizeInBytes = AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    public int decode(byte[] input, int offset) {
        reset();
        checkLength(input, offset, this.sizeInBytes);

        this.serviceIdentification = Byte.toUnsignedInt(input[offset]);

        appendItemDebugMsg("Service identification:", this.serviceIdentification);
        offset++;

        return offset;
    }

    @Override
    public int encode(byte[] dest, int offset) {
        throw new NotImplementedException();
    }

    @Override
    public void reset() {
        this.serviceIdentification = 0;
    }

    public int getServiceIdentification() {
        return this.serviceIdentification;
    }

}
