/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.VariableLengthAsterixData;

/**
 * Cat 062 Item 270 - Total size and orientation
 * Target size defined as length and width of the detected target,
 * and orientation.
 *
 * @implSpec Variable length Data Item comprising a first part of one octet,
 * followed by one-octet extents as necessary.
 */
public class Cat062Item270 extends VariableLengthAsterixData {
    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item270 - Total Size & Orientation";
    }
}
