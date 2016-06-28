/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004.item100;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat 004 Item 100 - Area Definitions
 */
public class Cat004Item100 extends FspecAsterixData {
    private Cat004Item100Subfield1 subfield1;
    private Cat004Item100Subfield2 subfield2;
    private Cat004Item100Subfield3 subfield3;
    private Cat004Item100Subfield4 subfield4;
    private Cat004Item100Subfield5 subfield5;
    private Cat004Item100Subfield6 subfield6;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        //subfield 1
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat004Item100Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        //subfield 2
        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Cat004Item100Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        //subfield 3
        if (fspecDataAtIndex(Fspec.SUBFIELD_3)) {
            subfield3 = new Cat004Item100Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }

        //subfield 4
        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Cat004Item100Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        //subfield 5
        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Cat004Item100Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        //subfield 6
        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Cat004Item100Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }

        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item100 - Area Definitions";
    }

    public Cat004Item100Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat004Item100Subfield2 getSubfield2() {
        return subfield2;
    }

    public Cat004Item100Subfield3 getSubfield3() {
        return subfield3;
    }

    public Cat004Item100Subfield4 getSubfield4() {
        return subfield4;
    }

    public Cat004Item100Subfield5 getSubfield5() {
        return subfield5;
    }

    public Cat004Item100Subfield6 getSubfield6() {
        return subfield6;
    }

    private class Fspec {
        //first extent
        public static final int SUBFIELD_6 = 2;
        public static final int SUBFIELD_5 = 3;
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_3 = 5;
        public static final int SUBFIELD_2 = 6;
        public static final int SUBFIELD_1 = 7;
    }
}
