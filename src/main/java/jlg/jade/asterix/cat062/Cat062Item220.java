/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

import java.nio.ByteBuffer;

/**
 * Cat 062 Item220 - ROCD - Opt
 * Calculated rate of Climb/Descent of an aircraft in two’s
 * complement form.
 *
 * @implSpec A positive value indicates a climb, whereas a negative value
 * indicates a descent
 */
public class Cat062Item220 extends FixedLengthAsterixData {
    private int rocd;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.rocd = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("ROCD", this.rocd);
    }

    @Override
    public byte[] encode() {
        byte[] itemAsByteArray = ByteBuffer.allocate(2).putShort((short) this.rocd).array();

        return itemAsByteArray;
    }

    /**
     * @return The rate of climb/descent for the aircraft expressed in 6.25 ft / min
     */
    public int getRocd() {
        return rocd;
    }

    /**
     * Set the rate of climb and descent. A positive value means that the aircraft
     * is climbing. A negative one means that the aircraft is descending.
     * Unit of measure: 6.25 ft/min
     *
     * @param rocd
     */
    public void setRocd(int rocd) {
        this.rocd = rocd;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item220 - ROCD (Rate of Climb / Descend)";
    }
}
