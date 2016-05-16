/* 
* Created by dan-geabunea on 5/6/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item290;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.Constants;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Item 290 - Subfield 5 - ADS-C age
 * Age of the last ADS-C report used to update the track
 */
public class Item290Subfield5 extends FixedLengthAsterixData {
    private int age;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.age = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Age", age);
        appendItemDebugMsg("Age (sec)", getAgeSeconds());
    }

    /**
     * @return The agin info in 1/4 sec
     */
    public int getAge() {
        return age;
    }

    /**
     * @return The aging info in seconds
     */
    public int getAgeSeconds(){
        return age / Constants.FROM_QUARTER_OF_SEC_TO_SEC;
    }
}
