/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import jlg.jade.common.Constants;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Generic class that implementes decoding behaviour for aging
 * fields of 1 octet (99% of Cat062 aging info is represente on 1 octet)
 */
public class Cat062AsterixAgingDataField extends FixedLengthAsterixData {
    private int age;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.age = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("Age", this.age);
        appendItemDebugMsg("Age (sec)", getAgeSeconds());
    }

    /**
     * @return The age informaiton, in 1/4 seconds
     */
    public int getAge() {
        return age;
    }

    /**
     * @return The aging information, in seconds
     */
    public double getAgeSeconds() {
        return this.age / Constants.FROM_QUARTER_OF_SEC_TO_SEC;
    }
}
