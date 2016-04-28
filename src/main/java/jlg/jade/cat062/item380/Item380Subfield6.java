/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Item 380 Subfield #6 - Selected altitude
 * The short-term vertical intent as described by either the FMS
 * selected altitude, the Altitude Control Panel Selected Altitude
 * (FCU/MCP), or the current aircraft altitude according to the
 * aircraft's mode of flight.
 * @implNote This item is not currently needed, so it will not be decoded
 */
public class Item380Subfield6 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {

        /**
         * @implNote
         * This subfield is not decoded because it is not needed yet.
         * Will only increase offset.
         */

        appendDebugMsg("Subfield decoding not implemented. Skipping this subfield.");
    }

    @Override
    protected boolean validate() {
        return true;
    }
}
