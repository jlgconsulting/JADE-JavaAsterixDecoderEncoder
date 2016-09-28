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
    private Cat062Item340Subfield1 subfield1;
    private Cat062Item340Subfield2 subfield2;
    private Cat062Item340Subfield3 subfield3;
    private Cat062Item340Subfield4 subfield4;
    private Cat062Item340Subfield5 subfield5;
    private Cat062Item340Subfield6 subfield6;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat062Item340Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_2)) {
            subfield2 = new Cat062Item340Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_3)) {
            subfield3 = new Cat062Item340Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Cat062Item340Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Cat062Item340Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Cat062Item340Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendNewLine();
            appendDebugMsg(subfield6.getDebugString());
        }

        return offset;
    }

    public Cat062Item340Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat062Item340Subfield2 getSubfield2() {
        return subfield2;
    }

    public Cat062Item340Subfield3 getSubfield3() {
        return subfield3;
    }

    public Cat062Item340Subfield4 getSubfield4() {
        return subfield4;
    }

    public Cat062Item340Subfield5 getSubfield5() {
        return subfield5;
    }

    public Cat062Item340Subfield6 getSubfield6() {
        return subfield6;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item340 - Measured Information";
    }

    private static class Fspec {
        //first extent
        static final int SUBFIELD_6 = 2;
        static final int SUBFIELD_5 = 3;
        static final int SUBFIELD_4 = 4;
        static final int SUBFIELD_3 = 5;
        static final int SUBFIELD_2 = 6;
        static final int SUBFIELD_1 = 7;
    }
}
