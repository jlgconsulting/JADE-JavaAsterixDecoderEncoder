/* 
* Created by dan-geabunea on 4/28/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.VariableLengthAsterixData;
import jlg.jade.asterix.DecodingNotImplemented;

/**
 * Item 380 Subfield #8 - Trajectory Intent Status
 * @implSpec The FX is currently always 0, but this item is variable because it might get
 * updated in the future.
 * @implNote Not implemented yet
 */
public class Item380Subfield8 extends VariableLengthAsterixData {
    @Override
    @DecodingNotImplemented(reason = "Not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected boolean validate() {
        return true;
    }
}
