/**
 * Created by alexandru on 7/7/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.IA5Decoder;

/**
 * Cat048Item240 - Aircraft Identification
 * Aircraft identification (in 8 characters) obtained from an
 * aircraft equipped with a Mode S transponder.
 */
public class Cat048Item240 extends FixedLengthAsterixData {
    private String aircraftIdentification;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SIX_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.aircraftIdentification = IA5Decoder.decodeFromSixBytes(input, offset);

        appendItemDebugMsg("Aircraft Identification", this.aircraftIdentification);

    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item240 - Aircraft Identification";
    }

    public String getAircraftIdentification() {
        return aircraftIdentification;
    }
}
