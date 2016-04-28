/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Item 380 Subfield #4 - Indicated Air Speed / Mach No
 *
 * @implSpec Not usually used anymore
 */
public class Item380Subfield4 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        /**
         * @implNote
         * Despite there are now two subfields (#26 and #27) reporting,
         * respectively, the Indicated Airspeed track data and the Mach Number
         * track data, this former subfield is kept free in order to prevent a full
         * incompatibility with previous releases of ASTERIX Cat. 062 already
         * implemented.
         *
         * Will only increase offset.
         */

        appendNotImplementedMsg();
    }

    @Override
    protected boolean validate() {
        return true;
    }
}
