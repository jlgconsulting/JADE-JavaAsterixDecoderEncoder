/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item295;

import jlg.jade.abstraction.Cat062AsterixAgingDataField;
import jlg.jade.abstraction.FspecAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 295 - Track Data Ages - Optional
 */
public class Cat062Item295 extends FspecAsterixData {
    private Cat062AsterixAgingDataField subfield1;
    private Cat062AsterixAgingDataField subfield2;
    private Cat062AsterixAgingDataField subfield3;
    private Cat062AsterixAgingDataField subfield4;
    private Cat062AsterixAgingDataField subfield5;
    private Cat062AsterixAgingDataField subfield6;
    private Cat062AsterixAgingDataField subfield7;
    private Cat062AsterixAgingDataField subfield8;
    private Cat062AsterixAgingDataField subfield9;
    private Cat062AsterixAgingDataField subfield10;
    private Cat062AsterixAgingDataField subfield11;
    private Cat062AsterixAgingDataField subfield12;
    private Cat062AsterixAgingDataField subfield13;
    private Cat062AsterixAgingDataField subfield14;
    private Cat062AsterixAgingDataField subfield15;
    private Cat062AsterixAgingDataField subfield16;
    private Cat062AsterixAgingDataField subfield17;
    private Cat062AsterixAgingDataField subfield18;
    private Cat062AsterixAgingDataField subfield19;
    private Cat062AsterixAgingDataField subfield20;
    private Cat062AsterixAgingDataField subfield21;
    private Cat062AsterixAgingDataField subfield22;
    private Cat062AsterixAgingDataField subfield23;
    private Cat062AsterixAgingDataField subfield24;
    private Cat062AsterixAgingDataField subfield25;
    private Cat062AsterixAgingDataField subfield26;
    private Cat062AsterixAgingDataField subfield27;
    private Cat062AsterixAgingDataField subfield28;
    private Cat062AsterixAgingDataField subfield29;
    private Cat062AsterixAgingDataField subfield30;
    private Cat062AsterixAgingDataField subfield31;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.FIVE_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_1)) {
            subfield1 = new Cat062AsterixAgingDataField();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg("Item295Subfield1 - MFL age");
            appendNewLine();
            appendDebugMsg(subfield1.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_2)) {
            subfield2 = new Cat062AsterixAgingDataField();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg("Item295Subfield2 - Mode1 age");
            appendNewLine();
            appendDebugMsg(subfield2.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_3)) {
            subfield3 = new Cat062AsterixAgingDataField();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg("Item295Subfield3 - Mode2 age");
            appendNewLine();
            appendDebugMsg(subfield3.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_4)) {
            subfield4 = new Cat062AsterixAgingDataField();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg("Item295Subfield4 - Mode 3/A age");
            appendNewLine();
            appendDebugMsg(subfield4.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_5)) {
            subfield5 = new Cat062AsterixAgingDataField();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg("Item295Subfield5 - Mode 4 age");
            appendNewLine();
            appendDebugMsg(subfield5.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_6)) {
            subfield6 = new Cat062AsterixAgingDataField();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg("Item295Subfield6 - Mode5 age");
            appendNewLine();
            appendDebugMsg(subfield6.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_7)) {
            subfield7 = new Cat062AsterixAgingDataField();
            offset = subfield7.decode(input, offset, length);
            appendDebugMsg("Item295Subfield7 - MGH age");
            appendNewLine();
            appendDebugMsg(subfield7.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_8)) {
            subfield8 = new Cat062AsterixAgingDataField();
            offset = subfield8.decode(input, offset, length);
            appendDebugMsg("Item295Subfield8 - IAS/Mach age");
            appendNewLine();
            appendDebugMsg(subfield8.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_9)) {
            subfield9 = new Cat062AsterixAgingDataField();
            offset = subfield9.decode(input, offset, length);
            appendDebugMsg("Item295Subfield9 - True airspeed age");
            appendNewLine();
            appendDebugMsg(subfield9.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_10)) {
            subfield10 = new Cat062AsterixAgingDataField();
            offset = subfield10.decode(input, offset, length);
            appendDebugMsg("Item295Subfield10 - Selected altitude age");
            appendNewLine();
            appendDebugMsg(subfield10.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_11)) {
            subfield11 = new Cat062AsterixAgingDataField();
            offset = subfield11.decode(input, offset, length);
            appendDebugMsg("Item295Subfield11 - Final state selected altitude age");
            appendNewLine();
            appendDebugMsg(subfield11.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_12)) {
            subfield12 = new Cat062AsterixAgingDataField();
            offset = subfield12.decode(input, offset, length);
            appendDebugMsg("Item295Subfield12 - Trajectory intent age");
            appendNewLine();
            appendDebugMsg(subfield12.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_13)) {
            subfield13 = new Cat062AsterixAgingDataField();
            offset = subfield13.decode(input, offset, length);
            appendDebugMsg("Item295Subfield13 - Comm/ACAS age");
            appendNewLine();
            appendDebugMsg(subfield13.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_14)) {
            subfield14 = new Cat062AsterixAgingDataField();
            offset = subfield14.decode(input, offset, length);
            appendDebugMsg("Item295Subfield14 - ADSB");
            appendNewLine();
            appendDebugMsg(subfield14.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_15)) {
            subfield15 = new Cat062AsterixAgingDataField();
            offset = subfield15.decode(input, offset, length);
            appendDebugMsg("Item295Subfield15 - RA Report age");
            appendNewLine();
            appendDebugMsg(subfield15.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_16)) {
            subfield16 = new Cat062AsterixAgingDataField();
            offset = subfield16.decode(input, offset, length);
            appendDebugMsg("Item295Subfield16 - Barometric vertical age");
            appendNewLine();
            appendDebugMsg(subfield16.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_17)) {
            subfield17 = new Cat062AsterixAgingDataField();
            offset = subfield17.decode(input, offset, length);
            appendDebugMsg("Item295Subfield17 - Geometric vertical age");
            appendNewLine();
            appendDebugMsg(subfield17.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_18)) {
            subfield18 = new Cat062AsterixAgingDataField();
            offset = subfield18.decode(input, offset, length);
            appendDebugMsg("Item295Subfield18 - Roll angle age");
            appendNewLine();
            appendDebugMsg(subfield18.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_19)) {
            subfield19 = new Cat062AsterixAgingDataField();
            offset = subfield19.decode(input, offset, length);
            appendDebugMsg("Item295Subfield19 - Track angle rate age");
            appendNewLine();
            appendDebugMsg(subfield19.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_20)) {
            subfield20 = new Cat062AsterixAgingDataField();
            offset = subfield20.decode(input, offset, length);
            appendDebugMsg("Item295Subfield20 - Track angle age");
            appendNewLine();
            appendDebugMsg(subfield20.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_21)) {
            subfield21 = new Cat062AsterixAgingDataField();
            offset = subfield21.decode(input, offset, length);
            appendDebugMsg("Item295Subfield21 - Ground speed age");
            appendNewLine();
            appendDebugMsg(subfield21.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_22)) {
            subfield22 = new Cat062AsterixAgingDataField();
            offset = subfield22.decode(input, offset, length);
            appendDebugMsg("Item295Subfield22 - Velocity uncertainty age");
            appendNewLine();
            appendDebugMsg(subfield22.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_23)) {
            subfield23 = new Cat062AsterixAgingDataField();
            offset = subfield23.decode(input, offset, length);
            appendDebugMsg("Item295Subfield23 - MET age");
            appendNewLine();
            appendDebugMsg(subfield23.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_24)) {
            subfield24 = new Cat062AsterixAgingDataField();
            offset = subfield24.decode(input, offset, length);
            appendDebugMsg("Item295Subfield24 - Emmiter category age");
            appendNewLine();
            appendDebugMsg(subfield24.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_25)) {
            subfield25 = new Cat062AsterixAgingDataField();
            offset = subfield25.decode(input, offset, length);
            appendDebugMsg("Item295Subfield25 - Pos age");
            appendNewLine();
            appendDebugMsg(subfield25.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_26)) {
            subfield26 = new Cat062AsterixAgingDataField();
            offset = subfield26.decode(input, offset, length);
            appendDebugMsg("Item295Subfield26 - Geometric altitude age");
            appendNewLine();
            appendDebugMsg(subfield26.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_27)) {
            subfield27 = new Cat062AsterixAgingDataField();
            offset = subfield27.decode(input, offset, length);
            appendDebugMsg("Item295Subfield27 - Pos uncertainty age");
            appendNewLine();
            appendDebugMsg(subfield27.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_28)) {
            subfield28 = new Cat062AsterixAgingDataField();
            offset = subfield28.decode(input, offset, length);
            appendDebugMsg("Item295Subfield28 - Mode S MB data age");
            appendNewLine();
            appendDebugMsg(subfield28.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_29)) {
            subfield29 = new Cat062AsterixAgingDataField();
            offset = subfield29.decode(input, offset, length);
            appendDebugMsg("Item295Subfield29 - Indicated airspeed data age");
            appendNewLine();
            appendDebugMsg(subfield29.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_30)) {
            subfield30 = new Cat062AsterixAgingDataField();
            offset = subfield30.decode(input, offset, length);
            appendDebugMsg("Item295Subfield30 - Mach number data age");
            appendNewLine();
            appendDebugMsg(subfield30.getDebugString());
        }

        if (isDataPresent(Cat062Item295Fspec.SUBFIELD_31)) {
            subfield31 = new Cat062AsterixAgingDataField();
            offset = subfield31.decode(input, offset, length);
            appendDebugMsg("Item295Subfield31 - Barometric pressure setting data age");
            appendNewLine();
            appendDebugMsg(subfield31.getDebugString());
        }


        return offset;
    }

    public Cat062AsterixAgingDataField getSubfield1() {
        return subfield1;
    }

    public Cat062AsterixAgingDataField getSubfield2() {
        return subfield2;
    }

    public Cat062AsterixAgingDataField getSubfield3() {
        return subfield3;
    }

    public Cat062AsterixAgingDataField getSubfield4() {
        return subfield4;
    }

    public Cat062AsterixAgingDataField getSubfield5() {
        return subfield5;
    }

    public Cat062AsterixAgingDataField getSubfield6() {
        return subfield6;
    }

    public Cat062AsterixAgingDataField getSubfield7() {
        return subfield7;
    }

    public Cat062AsterixAgingDataField getSubfield8() {
        return subfield8;
    }

    public Cat062AsterixAgingDataField getSubfield9() {
        return subfield9;
    }

    public Cat062AsterixAgingDataField getSubfield10() {
        return subfield10;
    }

    public Cat062AsterixAgingDataField getSubfield11() {
        return subfield11;
    }

    public Cat062AsterixAgingDataField getSubfield12() {
        return subfield12;
    }

    public Cat062AsterixAgingDataField getSubfield13() {
        return subfield13;
    }

    public Cat062AsterixAgingDataField getSubfield14() {
        return subfield14;
    }

    public Cat062AsterixAgingDataField getSubfield15() {
        return subfield15;
    }

    public Cat062AsterixAgingDataField getSubfield16() {
        return subfield16;
    }

    public Cat062AsterixAgingDataField getSubfield17() {
        return subfield17;
    }

    public Cat062AsterixAgingDataField getSubfield18() {
        return subfield18;
    }

    public Cat062AsterixAgingDataField getSubfield19() {
        return subfield19;
    }

    public Cat062AsterixAgingDataField getSubfield20() {
        return subfield20;
    }

    public Cat062AsterixAgingDataField getSubfield21() {
        return subfield21;
    }

    public Cat062AsterixAgingDataField getSubfield22() {
        return subfield22;
    }

    public Cat062AsterixAgingDataField getSubfield23() {
        return subfield23;
    }

    public Cat062AsterixAgingDataField getSubfield24() {
        return subfield24;
    }

    public Cat062AsterixAgingDataField getSubfield25() {
        return subfield25;
    }

    public Cat062AsterixAgingDataField getSubfield26() {
        return subfield26;
    }

    public Cat062AsterixAgingDataField getSubfield27() {
        return subfield27;
    }

    public Cat062AsterixAgingDataField getSubfield28() {
        return subfield28;
    }

    public Cat062AsterixAgingDataField getSubfield29() {
        return subfield29;
    }

    public Cat062AsterixAgingDataField getSubfield30() {
        return subfield30;
    }

    public Cat062AsterixAgingDataField getSubfield31() {
        return subfield31;
    }
}
