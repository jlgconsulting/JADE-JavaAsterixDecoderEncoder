/**
 * Created by alexandru on 7/7/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat048Item220 - Aircraft Address
 * Aircraft address (24-bits Mode S address) assigned uniquely to each aircraft.
 */
public class Cat048Item220 extends FixedLengthAsterixData{
    private int aircraftAddress;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.aircraftAddress = UnsignedNumericDecoder.decodeFromThreeBytes(input, offset);

        appendItemDebugMsg("Aircraft Address", this.aircraftAddress);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item220 - Aircraft Address";
    }

    public int getAircraftAddress() {
        return aircraftAddress;
    }
}
