/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 015 - Service Identification - Optional
 * Identification of the service provided to one or more users
 */
public class Cat062Item015 extends FixedLengthAsterixData {
    private int serviceIdentification;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.serviceIdentification = Byte.toUnsignedInt(input[offset]);

        appendItemDebugMsg("Service identification:", this.serviceIdentification);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    public int getServiceIdentification() {
        return this.serviceIdentification;
    }
}
