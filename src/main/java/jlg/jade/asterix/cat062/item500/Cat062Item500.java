/* 
* Created by dan-geabunea on 5/13/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item500;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat 062 Item 500 - Overview of all important accuracies - Opt
 * Compound Data Item, comprising a primary subfield of up to two
 * octets, followed by the indicated subfields.
 */
public class Cat062Item500 extends FspecAsterixData {
    private Cat062Item500Subfield1 subfield1;
    private Cat062Item500Subfield2 subfield2;
    private Cat062Item500Subfield3 subfield3;
    private Cat062Item500Subfield4 subfield4;
    private Cat062Item500Subfield5 subfield5;
    private Cat062Item500Subfield6 subfield6;
    private Cat062Item500Subfield7 subfield7;
    private Cat062Item500Subfield8 subfield8;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        //subfield 1
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat062Item500Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        //subfield 2
        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Cat062Item500Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        //subfield 3
        if (fspecDataAtIndex(Fspec.SUBFIELD_3)) {
            subfield3 = new Cat062Item500Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }

        //subfield 4
        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Cat062Item500Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        //subfield 5
        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Cat062Item500Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        //subfield 6
        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Cat062Item500Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }

        //subfield 7
        if (fspecDataAtIndex(Fspec.SUBFIELD_7)) {
            subfield7 = new Cat062Item500Subfield7();
            offset = subfield7.decode(input, offset, length);
            appendDebugMsg(subfield7.getDebugString());
        }

        //subfield 8
        if (fspecDataAtIndex(Fspec.SUBFIELD_8)) {
            subfield8 = new Cat062Item500Subfield8();
            offset = subfield8.decode(input, offset, length);
            appendDebugMsg(subfield8.getDebugString());
        }

        return offset;
    }

    public Cat062Item500Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat062Item500Subfield2 getSubfield2() {
        return subfield2;
    }

    public Cat062Item500Subfield3 getSubfield3() {
        return subfield3;
    }

    public Cat062Item500Subfield4 getSubfield4() {
        return subfield4;
    }

    public Cat062Item500Subfield5 getSubfield5() {
        return subfield5;
    }

    public Cat062Item500Subfield6 getSubfield6() {
        return subfield6;
    }

    public Cat062Item500Subfield7 getSubfield7() {
        return subfield7;
    }

    public Cat062Item500Subfield8 getSubfield8() {
        return subfield8;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item500 - Estimated Accuracies";
    }

    private static class Fspec {
        //first extent
        public static final int SUBFIELD_7 = 1;
        public static final int SUBFIELD_6 = 2;
        public static final int SUBFIELD_5 = 3;
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_3 = 5;
        public static final int SUBFIELD_2 = 6;
        public static final int SUBFIELD_1 = 7;

        //second extent
        public static final int SUBFIELD_8 = 15;
    }
}
