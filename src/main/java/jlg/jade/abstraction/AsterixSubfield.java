/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

import jlg.jade.common.AsterixDecodingException;

/**
 * Represents a fixed length Asterix subfield that is used to make up
 * complex Asterix items like I062/380 or I062/290.
 */
public abstract class AsterixSubfield extends FixedLengthAsterixItem implements Decodable {
    private boolean present;

    protected AsterixSubfield(){
        this.sizeInBytes = setSizeInBytes();
        this.present = true;
    }

    @Override
    public int decode(byte[] input, int offset, int inputLength){
        if(!present){
            throw new AsterixDecodingException.DecodingOfAbsentFieldAttempted(this.getClass().getSimpleName());
        }

        checkLength(input, offset, inputLength);
        int newOffset = decodeFromByteArray(input, offset);
        valid = validate();

        return newOffset;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
