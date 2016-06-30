/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat034Item041 - Antenna Rotation Speed
 * Antenna rotation period as measured between two consecutive North crossings or as averaged during a period of time.
 */
public class Cat034Item041 extends FixedLengthAsterixData{
    private int antennaRotationSpeed;

    @Override
    protected int setSizeInBytes() {
        return 2;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.antennaRotationSpeed = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);

        appendItemDebugMsg("Antenna Rotation Speed", this.antennaRotationSpeed);
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item041 - Antenna Rotation Speed";
    }

    public int getAntennaRotationSpeed() {
        return antennaRotationSpeed;
    }
}
