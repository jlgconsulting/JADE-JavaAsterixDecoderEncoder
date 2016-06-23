/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.asterix.cat004.item170_171;

import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat004 - Base Aircraft Identification and Characteristics
 * This is the base class that will be inherited by Cat004Item170 and Cat004Item171 because these
 * two items are identical.
 */
public class Cat004AircraftCharacteristicsBase extends FspecAsterixData {
    private Cat004AircraftCharacteristicsSubfield1 subfield1;
    private Cat004AircraftCharacteristicsSubfield2 subfield2;
    private Cat004AircraftCharacteristicsSubfield3 subfield3;
    private Cat004AircraftCharacteristicsSubfield4 subfield4;
    private Cat004AircraftCharacteristicsSubfield5 subfield5;
    private Cat004AircraftCharacteristicsSubfield6 subfield6;
    private Cat004AircraftCharacteristicsSubfield7 subfield7;
    private Cat004AircraftCharacteristicsSubfield8 subfield8;
    private Cat004AircraftCharacteristicsSubfield9 subfield9;
    private Cat004AircraftCharacteristicsSubfield10 subfield10;


    @Override
    protected int setMaxFspecSizeInBytes() {
        return 2;
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat004AircraftCharacteristicsSubfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Cat004AircraftCharacteristicsSubfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_3)) {
            subfield3 = new Cat004AircraftCharacteristicsSubfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Cat004AircraftCharacteristicsSubfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Cat004AircraftCharacteristicsSubfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Cat004AircraftCharacteristicsSubfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_7)) {
            subfield7 = new Cat004AircraftCharacteristicsSubfield7();
            offset = subfield7.decode(input, offset, length);
            appendDebugMsg(subfield7.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_8)) {
            subfield8 = new Cat004AircraftCharacteristicsSubfield8();
            offset = subfield8.decode(input, offset, length);
            appendDebugMsg(subfield8.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_9)) {
            subfield9 = new Cat004AircraftCharacteristicsSubfield9();
            offset = subfield9.decode(input, offset, length);
            appendDebugMsg(subfield9.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_10)) {
            subfield10 = new Cat004AircraftCharacteristicsSubfield10();
            offset = subfield10.decode(input, offset, length);
            appendDebugMsg(subfield10.getDebugString());
        }

        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "Cat004AircraftCharacteristicsBase";
    }

    public Cat004AircraftCharacteristicsSubfield1 getSubfield1() {
        return subfield1;
    }

    public Cat004AircraftCharacteristicsSubfield2 getSubfield2() {
        return subfield2;
    }

    public Cat004AircraftCharacteristicsSubfield3 getSubfield3() {
        return subfield3;
    }

    public Cat004AircraftCharacteristicsSubfield4 getSubfield4() {
        return subfield4;
    }

    public Cat004AircraftCharacteristicsSubfield5 getSubfield5() {
        return subfield5;
    }

    public Cat004AircraftCharacteristicsSubfield6 getSubfield6() {
        return subfield6;
    }

    public Cat004AircraftCharacteristicsSubfield7 getSubfield7() {
        return subfield7;
    }

    public Cat004AircraftCharacteristicsSubfield8 getSubfield8() {
        return subfield8;
    }

    public Cat004AircraftCharacteristicsSubfield9 getSubfield9() {
        return subfield9;
    }

    public Cat004AircraftCharacteristicsSubfield10 getSubfield10() {
        return subfield10;
    }

    private static class Fspec {
        //first extent
        static final int SUBFIELD_7 = 1;
        static final int SUBFIELD_6 = 2;
        static final int SUBFIELD_5 = 3;
        static final int SUBFIELD_4 = 4;
        static final int SUBFIELD_3 = 5;
        static final int SUBFIELD_2 = 6;
        static final int SUBFIELD_1 = 7;

        //second extent
        public static final int SUBFIELD_10 = 13;
        public static final int SUBFIELD_9 = 14;
        public static final int SUBFIELD_8 = 15;
    }
}
