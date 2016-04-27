/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.AsterixSubfield;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Item 380 Subfield #2 - Target Identification
 * Characters 1-8 (coded on 6 bits each) defining a target
 * identification when flight plan is available or the registration
 * marking when no flight plan is available
 */
public class Item380Subfield2 extends AsterixSubfield {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SIX_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {

        /**
         * @implNote
         * This subfield is not decoded because it is not needed yet. 
         */

        return offset + this.setSizeInBytes();
    }

    @Override
    protected boolean validate() {
        return true;
    }
}
