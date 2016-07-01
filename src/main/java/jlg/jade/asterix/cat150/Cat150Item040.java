/**
 * Created by Dan Geabunea on 7/1/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat150 Item040 - Plan reference number
 * Identification of the flight plan
 *
 * @implSpec The currently defined range for plan reference numbers used in MADAP is 0 .. 1999.
 * Client systems should allow for a range of 0 .. 2047
 */
public class Cat150Item040 extends FixedLengthAsterixData {
    private int planNumber;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.planNumber = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Plan Number", this.planNumber);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item040 - Plan Reference Number";
    }

    public int getPlanNumber() {
        return planNumber;
    }
}
