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
 * Item 390 Subfield 13 - Aircraft Stand (on the taxiway)
 *
 * @implSpec Each one of the six Octets contains an ASCII Character. The Aircraft
 * Stand identification is always left adjusted. It contains up to six uppercase
 * alphanumeric characters, the remaining character positions (if
 * any) are padded with space characters.
 */
public class Item390Subfield13 extends FixedLengthAsterixData {
    private String aircraftStand;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SIX_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            this.aircraftStand = new String(input, offset, getSizeInBytes(), "UTF-8").replace(" ", "");
        } catch (UnsupportedEncodingException e) {
            appendErrorMessage("Unsupported encoding exception");
        }
    }

    /**
     * @return The aircraft stand
     */
    public String getAircraftStand() {
        return aircraftStand;
    }

    @Override
    protected String setDisplayName() {
        return "Item390Subfield13 - Aircraft Stand";
    }
}
