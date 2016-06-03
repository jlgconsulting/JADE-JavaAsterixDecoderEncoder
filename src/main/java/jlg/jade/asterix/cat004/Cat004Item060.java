/* 
* Created by dan-geabunea on 6/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat004;

import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.VariableLengthAsterixData;

/**
 * Cat 004 - Item 060 - Safety Net Functions & System Status
 */
public class Cat004Item060 extends VariableLengthAsterixData {

    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item060 - Safety Net Function & System Status";
    }
}
