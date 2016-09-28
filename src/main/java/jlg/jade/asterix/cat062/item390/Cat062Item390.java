/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat 062 Item 390 - Mini Flight Plan Information
 * All flight plan related information, provided by ground-based
 * systems.
 */
public class Cat062Item390 extends FspecAsterixData {
    private Cat062Item390Subfield1 subfield1;
    private Cat062Item390Subfield2 subfield2;
    private Cat062Item390Subfield3 subfield3;
    private Cat062Item390Subfield4 subfield4;
    private Cat062Item390Subfield5 subfield5;
    private Cat062Item390Subfield6 subfield6;
    private Cat062Item390Subfield7 subfield7;
    private Cat062Item390Subfield8 subfield8;
    private Cat062Item390Subfield9 subfield9;
    private Cat062Item390Subfield10 subfield10;
    private Cat062Item390Subfield11 subfield11;
    private Cat062Item390Subfield12 subfield12;
    private Cat062Item390Subfield13 subfield13;
    private Cat062Item390Subfield14 subfield14;
    private Cat062Item390Subfield15 subfield15;
    private Cat062Item390Subfield16 subfield16;
    private Cat062Item390Subfield17 subfield17;
    private Cat062Item390Subfield18 subfield18;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat062Item390Subfield1();
            offset = getSubfield1().decode(input, offset, length);
            appendDebugMsg(getSubfield1().getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Cat062Item390Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_3)) {
            subfield3 = new Cat062Item390Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Cat062Item390Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Cat062Item390Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Cat062Item390Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_7)) {
            subfield7 = new Cat062Item390Subfield7();
            offset = subfield7.decode(input, offset, length);
            appendDebugMsg(subfield7.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_8)) {
            subfield8 = new Cat062Item390Subfield8();
            offset = subfield8.decode(input, offset, length);
            appendDebugMsg(subfield8.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_9)) {
            subfield9 = new Cat062Item390Subfield9();
            offset = subfield9.decode(input, offset, length);
            appendNewLine();
            appendDebugMsg(subfield9.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_10)) {
            subfield10 = new Cat062Item390Subfield10();
            offset = subfield10.decode(input, offset, length);
            appendDebugMsg(subfield10.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_11)) {
            subfield11 = new Cat062Item390Subfield11();
            offset = subfield11.decode(input, offset, length);
            appendDebugMsg(subfield11.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_12)) {
            subfield12 = new Cat062Item390Subfield12();
            offset = subfield12.decode(input, offset, length);
            appendDebugMsg(subfield12.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_13)) {
            subfield13 = new Cat062Item390Subfield13();
            offset = subfield13.decode(input, offset, length);
            appendDebugMsg(subfield13.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_14)) {
            subfield14 = new Cat062Item390Subfield14();
            offset = subfield14.decode(input, offset, length);
            appendDebugMsg(subfield14.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_15)) {
            subfield15 = new Cat062Item390Subfield15();
            offset = subfield15.decode(input, offset, length);
            appendDebugMsg(subfield15.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_16)) {
            subfield16 = new Cat062Item390Subfield16();
            offset = subfield16.decode(input, offset, length);
            appendDebugMsg(subfield16.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_17)) {
            subfield17 = new Cat062Item390Subfield17();
            offset = subfield17.decode(input, offset, length);
            appendDebugMsg(subfield17.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_18)) {
            subfield18 = new Cat062Item390Subfield18();
            offset = subfield18.decode(input, offset, length);
            appendDebugMsg(subfield18.getDebugString());
        }

        return offset;
    }

    public Cat062Item390Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat062Item390Subfield2 getSubfield2() {
        return subfield2;
    }

    public Cat062Item390Subfield3 getSubfield3() {
        return subfield3;
    }

    public Cat062Item390Subfield4 getSubfield4() {
        return subfield4;
    }

    public Cat062Item390Subfield5 getSubfield5() {
        return subfield5;
    }

    public Cat062Item390Subfield6 getSubfield6() {
        return subfield6;
    }

    public Cat062Item390Subfield7 getSubfield7() {
        return subfield7;
    }

    public Cat062Item390Subfield8 getSubfield8() {
        return subfield8;
    }

    public Cat062Item390Subfield9 getSubfield9() {
        return subfield9;
    }

    public Cat062Item390Subfield10 getSubfield10() {
        return subfield10;
    }

    public Cat062Item390Subfield11 getSubfield11() {
        return subfield11;
    }

    public Cat062Item390Subfield12 getSubfield12() {
        return subfield12;
    }

    public Cat062Item390Subfield13 getSubfield13() {
        return subfield13;
    }

    public Cat062Item390Subfield14 getSubfield14() {
        return subfield14;
    }

    public Cat062Item390Subfield15 getSubfield15() {
        return subfield15;
    }

    public Cat062Item390Subfield16 getSubfield16() {
        return subfield16;
    }

    public Cat062Item390Subfield17 getSubfield17() {
        return subfield17;
    }

    public Cat062Item390Subfield18 getSubfield18() {
        return subfield18;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item390 - Mini FLight Plan Information";
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
        static final int SUBFIELD_14 = 9;
        static final int SUBFIELD_13 = 10;
        static final int SUBFIELD_12 = 11;
        static final int SUBFIELD_11 = 12;
        static final int SUBFIELD_10 = 13;
        static final int SUBFIELD_9 = 14;
        static final int SUBFIELD_8 = 15;

        //third extent
        static final int SUBFIELD_18 = 20;
        static final int SUBFIELD_17 = 21;
        static final int SUBFIELD_16 = 22;
        static final int SUBFIELD_15 = 23;
    }
}
