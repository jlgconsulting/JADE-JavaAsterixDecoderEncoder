/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat048Item042 - Calculated Position in Cartesian Co-ordinates
 */
public class Cat048Item042 extends FixedLengthAsterixData {
    private int x;
    private int y;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.x = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        this.y = TwoComplementDecoder.decodeFromTwoBytes(input, offset + 2);

        appendItemDebugMsg("X", this.x);
        appendItemDebugMsg("Y", this.y);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item042 - Calculated Position in Cartesian Co-ordinates";
    }

    /**
     * @return the X-Component expressed as 1/128 NM
     */
    public int getX() {
        return x;
    }

    /**
     * @return the Y-Component expressed as 1/128 NM
     */
    public int getY() {
        return y;
    }
}
