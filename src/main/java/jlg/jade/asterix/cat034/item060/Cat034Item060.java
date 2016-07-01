/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.asterix.cat034.item060;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat034Item060 - System Processing Mode
 * Status concerning the processing options, in use during the last antenna revolution, for the various Sensors, composing the System.
 */
public class Cat034Item060 extends FspecAsterixData {
    private Cat034Item060Subfield1 subfield1;
    private Cat034Item060Subfield4 subfield4;
    private Cat034Item060Subfield5 subfield5;
    private Cat034Item060Subfield6 subfield6;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        // subfield1
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat034Item060Subfield1();
            offset = subfield1.decode(input, offset, length);

            appendDebugMsg(subfield1.getDebugString());
        }

        // subfield4
        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Cat034Item060Subfield4();
            offset = subfield4.decode(input, offset, length);

            appendDebugMsg(subfield4.getDebugString());
        }

        // subfield5
        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Cat034Item060Subfield5();
            offset = subfield5.decode(input, offset, length);

            appendDebugMsg(subfield5.getDebugString());
        }

        // subfield6
        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Cat034Item060Subfield6();
            offset = subfield6.decode(input, offset, length);

            appendDebugMsg(subfield6.getDebugString());
        }

        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item060 - System Processing Mode";
    }

    public Cat034Item060Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat034Item060Subfield4 getSubfield4() {
        return subfield4;
    }

    public Cat034Item060Subfield5 getSubfield5() {
        return subfield5;
    }

    public Cat034Item060Subfield6 getSubfield6() {
        return subfield6;
    }

    private static class Fspec {
        // first extent
        public static final int SUBFIELD_1 = 7;
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_5 = 3;
        public static final int SUBFIELD_6 = 2;
    }
}
