/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.nio.ByteBuffer;

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
    public byte[] encode() {
        byte[] serviceIdAsByteArray = ByteBuffer.allocate(1).put((byte) this.serviceIdentification).array();

        byte[] encodedItem = new byte[this.sizeInBytes];
        System.arraycopy(serviceIdAsByteArray, 0, encodedItem, 0, 1);

        return encodedItem;
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item015 - Service ID";
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    public int getServiceIdentification() {
        return this.serviceIdentification;
    }

    public void setServiceIdentification(int serviceIdentification) {
        this.serviceIdentification = serviceIdentification;
    }
}
