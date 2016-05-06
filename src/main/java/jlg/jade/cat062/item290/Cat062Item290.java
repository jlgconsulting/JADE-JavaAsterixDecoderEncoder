/* 
* Created by dan-geabunea on 5/5/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item290;

import jlg.jade.abstraction.FspecAsterixData;

/**
 * Cat 062 Item 390 - System track update ages
 * Ages of the last plot/local track/target report update for each sensor type.
 * Compound Data Item, comprising a primary subfield of up to two
 * octets, followed by the indicated subfields.
 */
public class Cat062Item290 extends FspecAsterixData {
    @Override
    protected int setMaxFspecSizeInBytes() {
        return 0;
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        return 0;
    }
}
