/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.util.BitSet;

/**
 * Cat048Item090 - Flight Level in Binary Representation
 * Flight Level converted into binary representation.
 */
public class Cat048Item090 extends FixedLengthAsterixData {
    private int flightLevel;
    private boolean flightLevelValidated;
    private boolean flightLevelGarbled;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet firstOctetBits = BitSet.valueOf(new byte[]{input[offset]});
        int firstOctetValue = Byte.toUnsignedInt(input[offset]);

        // determine flight level is validated
        final int FL_VALIDATED_BIT_VALUE = 7;
        if (firstOctetBits.get(FL_VALIDATED_BIT_VALUE)) {
            this.flightLevelValidated = false;
        } else {
            this.flightLevelValidated = true;
        }
        appendItemDebugMsg("Flight level validated", this.flightLevelValidated);

        // determine flight level is garbled
        final int FL_GARBLED_BIT_VALUE = 6;
        if (firstOctetBits.get(FL_GARBLED_BIT_VALUE)) {
            this.flightLevelGarbled = true;
        } else {
            this.flightLevelGarbled = false;
        }
        appendItemDebugMsg("Flight level garbled", this.flightLevelGarbled);

        // substract value for bits 7-6 if present
        if (firstOctetBits.get(7)) {
            firstOctetValue = firstOctetValue - 128;
        }
        if (firstOctetBits.get(6)) {
            firstOctetValue = firstOctetValue - 64;
        }

        // calculate flight level with remaining value for first byte and second byte
        this.flightLevel = firstOctetValue * 256 + Byte.toUnsignedInt(input[offset + 1]);
        appendItemDebugMsg("Flight level (ft)", this.getFlightLevelFeet());
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item090 - Flight Level in Binary Representation";
    }

    /**
     * @return calculates the flight level in ft by multiplying the stored flight level ( in 1/4FL ) with 25
     */
    public int getFlightLevelFeet() {
        return flightLevel * 25;
    }

    public boolean getFlightLevelValidated() {
        return flightLevelValidated;
    }

    public boolean getFlightLevelGarbled() {
        return flightLevelGarbled;
    }
}
