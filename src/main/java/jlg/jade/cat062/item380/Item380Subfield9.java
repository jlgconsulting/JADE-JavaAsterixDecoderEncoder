/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.RepeatableAsterixData;

/**
 * Item 380 Subfield #9 - Trajectory Intent Data
 * Repetitive Data Item starting with a one-octet Field Repetition
 * Indicator (REP) followed by at least one Trajectory Intent Point
 * comprising fifteen octets
 */
public class Item380Subfield9 extends RepeatableAsterixData {
    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return 15;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }
}
