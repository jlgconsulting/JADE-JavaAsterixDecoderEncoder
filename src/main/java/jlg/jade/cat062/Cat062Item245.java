/* 
* Created by dan-geabunea on 4/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 245 - Target (aircraft or vehicle) identification in 8 characters.
 * @implSpec  Item is not used any more according to Asterix ICD
 */
public class Cat062Item245 extends FixedLengthAsterixData {


    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        /**
         * @implNote
         * This item is not used anymore according to Asterix ICD (pg 39 v1.12). So, if it is present in the data,
         * we shall just increment the offset, without decoding.
         */

        appendNotImplementedMsg();
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }
}
