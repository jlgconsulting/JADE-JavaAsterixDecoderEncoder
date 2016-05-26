/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.io.UnsupportedEncodingException;

/**
 * Item 390 Subfield 6 - Wake Turbulence Category
 * ASCII character with one of the following values:
 * - L = Light
 * - M = Medium
 * - H = Heavy
 * - J = Super
 */
public class Item390Subfield6 extends FixedLengthAsterixData {
    private String wakeTurbulenceCategory;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            this.wakeTurbulenceCategory = new String(input, offset, getSizeInBytes(), "UTF-8");
            appendItemDebugMsg("Wake turbulence category", this.wakeTurbulenceCategory);
        } catch (UnsupportedEncodingException e) {
            appendErrorMessage("Unsupported encoding exception");
        }
    }

    /**
     * @return The wake turbulence category as a capital letter.
     * - L stands for Light
     * - M stands for Medium
     * - H stands for Heavy
     * - J stands for Super
     */
    public String getWakeTurbulenceCategory() {
        return wakeTurbulenceCategory;
    }

    @Override
    protected String setDisplayName() {
        return "Item390Subfield6 - Wake Turbulence Category";
    }
}
