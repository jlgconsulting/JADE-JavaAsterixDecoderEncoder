/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.asterix.cat048.item120;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat048Item120 - Radial Doppler Speed
 * Information on the Doppler Speed of the target report
 */
public class Cat048Item120 extends FspecAsterixData {
    Cat048Item120Subfield1 subfield1;
    Cat048Item120Subfield2 subfield2;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat048Item120Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Cat048Item120Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item120 - Radial Doppler Speed";
    }

    public Cat048Item120Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat048Item120Subfield2 getSubfield2() {
        return subfield2;
    }

    private class Fspec {
        public static final int SUBFIELD_1 = 7;
        public static final int SUBFIELD_2 = 6;
    }
}
