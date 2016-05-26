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
 * Item 390 Subfield 9 - Runway Designation
 *
 * @implSpec Made up of two digits and a letter, that indicates the direction
 * of the runway
 */
public class Item390Subfield9 extends FixedLengthAsterixData {
    private String runwayDesignator;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            this.runwayDesignator = new String(input, offset, getSizeInBytes(), "UTF-8").replace(" ", "");
        } catch (UnsupportedEncodingException e) {
            appendErrorMessage("Unsupported encoding exception");
        }
    }

    /**
     * @return The runway designator, made of two digits and one letter
     */
    public String getRunwayDesignator() {
        return runwayDesignator;
    }

    @Override
    protected String setDisplayName() {
        return "Item390Subfield9 - Runway Designation";
    }
}
