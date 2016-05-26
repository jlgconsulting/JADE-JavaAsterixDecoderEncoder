/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat065;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat 065 Item 015 - Service Identification
 * Identification of the service provided to one or more users.
 */
public class Cat065Item015 extends FixedLengthAsterixData {
    private int serviceIdentification;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.serviceIdentification = UnsignedNumericDecoder.decodeFromOneByte(input,offset);
        appendItemDebugMsg("Service Identification", this.serviceIdentification);
    }

    @Override
    protected String setDisplayName() {
        return "Cat065Item015 - Service Identification";
    }

    public int getServiceIdentification() {
        return serviceIdentification;
    }
}
