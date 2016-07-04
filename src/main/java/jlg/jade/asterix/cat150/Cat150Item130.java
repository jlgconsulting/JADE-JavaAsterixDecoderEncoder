/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item030 - Cleared FLight Level
 * Cleared flight level from the sector that has the aircraft
 * under control
 *
 * @implNote Unit of measure is FL (100 ft)
 */
public class Cat150Item130 extends FixedLengthAsterixData {
    private int clearedFLightLevel;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        String cflString = new String(input, offset, this.sizeInBytes);
        this.clearedFLightLevel = Integer.parseInt(cflString);
        appendItemDebugMsg("Cleared Flight Level", this.clearedFLightLevel);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item130 - Cleared Flight Level";
    }


    public int getClearedFLightLevel() {
        return clearedFLightLevel;
    }
}
