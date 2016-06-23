package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat 004 - Item 170/171 - Subfield 6 - Distance to Treshold for Aircraft
 * Distance from threshold for Aircraft involved in a RIMCA
 *
 * @implSpec Unit of measure is 0.5m
 */
public class Cat004AircraftCharacteristicsSubfield6 extends FixedLengthAsterixData {
    private int distanceToThreshhold;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.distanceToThreshhold = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Distance in half meters", this.distanceToThreshhold);
    }

    @Override
    protected String setDisplayName() {
        return "Subfield6 - Distance to Threshold";
    }

    /**
     * @return Distance of aircraft to threshold in half meters.
     */
    public int getDistanceToThreshhold() {
        return distanceToThreshhold;
    }
}
