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
 * Cat 065 Item 020 - Batch Number
 * A number indicating the completion of a service for that batch of
 * track data, from 0 to N-1, N being the number of batches used to
 * make one complete processing cycle
 */
public class Cat065Item020 extends FixedLengthAsterixData {
    private int batchNumber;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.batchNumber = UnsignedNumericDecoder.decodeFromOneByte(input,offset);
        appendItemDebugMsg("Batch Number", this.batchNumber);
    }

    @Override
    protected String setDisplayName() {
        return "Cat065Item020 - Batch Number";
    }

    public int getBatchNumber() {
        return batchNumber;
    }
}
