/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat034 Item020 - Sector Number
 * Eight most significant bits of the antenna azimuth defining a particular azimuth sector.
 */
public class Cat034Item020 extends FixedLengthAsterixData {
    private int sectorNumber;

    @Override
    protected int setSizeInBytes() {
        return 1;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.sectorNumber = UnsignedNumericDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Sector Number", this.sectorNumber);
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item020 - Sector Number";
    }

    public int getSectorNumber() {
        return sectorNumber;
    }
}
