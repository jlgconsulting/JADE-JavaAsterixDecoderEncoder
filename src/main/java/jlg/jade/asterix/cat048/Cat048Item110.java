/**
 * Created by alexandru on 7/8/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Cat048Item110 - Height Measured by a 3D Radar
 * Height of a target as measured by a 3D radar. The height shall
 * use mean sea level as the zero reference level.
 */
public class Cat048Item110 extends FixedLengthAsterixData{
    private int measuredHeight3DRadar;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.measuredHeight3DRadar = TwoComplementDecoder.decodeFromTwoBytes(input, offset);

        appendItemDebugMsg("3D Height", this.measuredHeight3DRadar);
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item110 - Height Measured by a 3D Radar";
    }

    /**
     * @return 3D height, in binary notation.
     * Negative values are expressed in two’s complement
     * Value is represented in LSB = 25 ft
     */
    public int getMeasuredHeight3DRadar() {
        return measuredHeight3DRadar;
    }
}
