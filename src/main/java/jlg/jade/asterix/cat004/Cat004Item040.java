/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat 004 - Item 040 - Alert Identifier
 *
 * @implSpec This number shall be assigned, by the Safety Net Server, incrementally
 * to every new alert and restart on zero after reaching the maximum value
 * (65535)
 */
public class Cat004Item040 extends FixedLengthAsterixData {
    private int alertIdentifier;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.alertIdentifier = UnsignedNumericDecoder.decodeFromTwoBytes(input,offset);
        appendItemDebugMsg("Alert Identifier", this.alertIdentifier);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item040 - Alert Identifier";
    }

    /**
     * @return The alert number fot the current safety nets message
     */
    public int getAlertIdentifier() {
        return alertIdentifier;
    }

    public void setAlertIdentifier(int alertIdentifier) {
        this.alertIdentifier = alertIdentifier;
    }
}
