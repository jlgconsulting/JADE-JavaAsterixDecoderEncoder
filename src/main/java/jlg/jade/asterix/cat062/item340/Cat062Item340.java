/* 
* Created by dan-geabunea on 5/16/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item340;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat 062 Item 340 - Measured Information - Opt
 *
 * @implSpec All measured data related to the last report used to update the
 * track. These data are not used for ADS-B.
 */
public class Cat062Item340 extends FspecAsterixData {
    private Item340Subfield1 subfield1;
    private Item340Subfield2 subfield2;
    private Item340Subfield3 subfield3;
    private Item340Subfield4 subfield4;
    private Item340Subfield5 subfield5;
    private Item340Subfield6 subfield6;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Item340Subfield1();
            offset = subfield1.decode(input, offset, length);

            appendDebugMsg("Item340Subfield1 - Sensor Identification");
            appendNewLine();
            appendDebugMsg(subfield1.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Item340Subfield2();
            offset = subfield2.decode(input, offset, length);

            appendDebugMsg("Item340Subfield2 - Measured Position");
            appendNewLine();
            appendDebugMsg(subfield2.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_3)) {
            subfield3 = new Item340Subfield3();
            offset = subfield3.decode(input, offset, length);

            appendDebugMsg("Item340Subfield3 - Measured 3D Height");
            appendNewLine();
            appendDebugMsg(subfield3.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Item340Subfield4();
            offset = subfield4.decode(input, offset, length);

            appendDebugMsg("Item340Subfield4 - Measured Mode C Code");
            appendNewLine();
            appendDebugMsg(subfield4.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Item340Subfield5();
            offset = subfield5.decode(input, offset, length);

            appendDebugMsg("Item340Subfield5 - Measured Mode A Code");
            appendNewLine();
            appendDebugMsg(subfield5.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Item340Subfield6();
            offset = subfield6.decode(input, offset, length);

            appendDebugMsg("Item340Subfield6 - Report Type");
            appendNewLine();
            appendDebugMsg(subfield6.getDebugString());
        }

        return offset;
    }

    public Item340Subfield1 getSubfield1() {
        return subfield1;
    }

    public Item340Subfield2 getSubfield2() {
        return subfield2;
    }

    public Item340Subfield3 getSubfield3() {
        return subfield3;
    }

    public Item340Subfield4 getSubfield4() {
        return subfield4;
    }

    public Item340Subfield5 getSubfield5() {
        return subfield5;
    }

    public Item340Subfield6 getSubfield6() {
        return subfield6;
    }

    private static class Fspec {
        //first extent
        public static final int SUBFIELD_6 = 2;
        public static final int SUBFIELD_5 = 3;
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_3 = 5;
        public static final int SUBFIELD_2 = 6;
        public static final int SUBFIELD_1 = 7;
    }
}
