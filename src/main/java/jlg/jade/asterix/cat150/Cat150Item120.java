/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item120 - Aircraft Type
 * FLight information details
 */
public class Cat150Item120 extends FixedLengthAsterixData {
    private String numberOfAircraft;
    private String typeOfAircraft;
    private String wakeTurbulence;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.numberOfAircraft = new String(input, offset, 2);
        this.typeOfAircraft = new String(input, offset + 2, 4);
        this.wakeTurbulence = new String(input, offset + 6, 1);

        appendItemDebugMsg("Nb. of aircraft", this.numberOfAircraft);
        appendItemDebugMsg("Type of aircraft", this.typeOfAircraft);
        appendItemDebugMsg("Wake turbulence category", this.wakeTurbulence);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item120 - Aircraft Type";
    }

    public String getNumberOfAircraft() {
        return numberOfAircraft;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    /**
     * @return The wake turbulence category
     * @implNote Allowed values are A,B,C,D,E,F
     */
    public String getWakeTurbulence() {
        return wakeTurbulence;
    }
}
