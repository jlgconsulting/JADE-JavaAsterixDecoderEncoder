/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.asterix.cat004.item120;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat004 Item 120 - Conflict Characteristics
 * Compound Data Item, comprising a primary subfield of one octet,
 * followed by the indicated subfields.
 */
public class Cat004Item120 extends FspecAsterixData {
    private Cat004Item120Subfield1 subfield1;
    private Cat004Item120Subfield2 subfield2;
    private Cat004Item120Subfield3 subfield3;
    private Cat004Item120Subfield4 subfield4;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        return 0;
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item120 - Conflict Characteristics";
    }

    public Cat004Item120Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat004Item120Subfield2 getSubfield2() {
        return subfield2;
    }

    public Cat004Item120Subfield3 getSubfield3() {
        return subfield3;
    }

    public Cat004Item120Subfield4 getSubfield4() {
        return subfield4;
    }

    private static class FSPEC {
        //first extent
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_3 = 5;
        public static final int SUBFIELD_2 = 6;
        public static final int SUBFIELD_1 = 7;
    }
}
