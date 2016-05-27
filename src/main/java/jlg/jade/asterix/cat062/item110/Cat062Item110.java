/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item110;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat062 Item 110 - Mode 5 Data reports & Extended Mode 1 Code - Optional
 */
public class Cat062Item110 extends FspecAsterixData {
    private Item110Subfield1 subfield1;
    private Item110Subfield2 subfield2;
    private Item110Subfield3 subfield3;
    private Item110Subfield4 subfield4;
    private Item110Subfield5 subfield5;
    private Item110Subfield6 subfield6;
    private Item110Subfield7 subfield7;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Item110Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Item110Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_3)) {
            subfield3 = new Item110Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendNewLine();
            appendDebugMsg(subfield3.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Item110Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendNewLine();
            appendDebugMsg(subfield4.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Item110Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendNewLine();
            appendDebugMsg(subfield5.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Item110Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendNewLine();
            appendDebugMsg(subfield6.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_7)) {
            subfield7 = new Item110Subfield7();
            offset = subfield7.decode(input, offset, length);
            appendNewLine();
            appendDebugMsg(subfield7.getDebugString());
        }

        return offset;
    }

    public Item110Subfield1 getSubfield1() {
        return subfield1;
    }

    public Item110Subfield2 getSubfield2() {
        return subfield2;
    }

    public Item110Subfield3 getSubfield3() {
        return subfield3;
    }

    public Item110Subfield4 getSubfield4() {
        return subfield4;
    }

    public Item110Subfield5 getSubfield5() {
        return subfield5;
    }

    public Item110Subfield6 getSubfield6() {
        return subfield6;
    }

    public Item110Subfield7 getSubfield7() {
        return subfield7;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item110 - Mode 5 Data reports & Extended Mode 1 Code";
    }

    private static class Fspec {
        static final int SUBFIELD_7 = 1;
        static final int SUBFIELD_6 = 2;
        static final int SUBFIELD_5 = 3;
        static final int SUBFIELD_4 = 4;
        static final int SUBFIELD_3 = 5;
        static final int SUBFIELD_2 = 6;
        static final int SUBFIELD_1 = 7;
    }
}
