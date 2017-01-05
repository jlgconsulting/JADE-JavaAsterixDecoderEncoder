/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Asterix Cat 062 Item 380 - Aircraft Derived Data
 */
public class Cat062Item380 extends FspecAsterixData {
    private Cat062Item380Subfield1 subfield1;
    private Cat062Item380Subfield2 subfield2;
    private Cat062Item380Subfield3 subfield3;
    private Cat062Item380Subfield4 subfield4;
    private Cat062Item380Subfield5 subfield5;
    private Cat062Item380Subfield6 subfield6;
    private Cat062Item380Subfield7 subfield7;
    private Cat062Item380Subfield8 subfield8;
    private Cat062Item380Subfield9 subfield9;
    private Cat062Item380Subfield10 subfield10;
    private Cat062Item380Subfield11 subfield11;
    private Cat062Item380Subfield12 subfield12;
    private Cat062Item380Subfield13 subfield13;
    private Cat062Item380Subfield14 subfield14;
    private Cat062Item380Subfield15 subfield15;
    private Cat062Item380Subfield16 subfield16;
    private Cat062Item380Subfield17 subfield17;
    private Cat062Item380Subfield18 subfield18;
    private Cat062Item380Subfield19 subfield19;
    private Cat062Item380Subfield20 subfield20;
    private Cat062Item380Subfield21 subfield21;
    private Cat062Item380Subfield22 subfield22;
    private Cat062Item380Subfield23 subfield23;
    private Cat062Item380Subfield24 subfield24;
    private Cat062Item380Subfield25 subfield25;
    private Cat062Item380Subfield26 subfield26;
    private Cat062Item380Subfield27 subfield27;
    private Cat062Item380Subfield28 subfield28;

    public Cat062Item380(){
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item380 - Aircraft Derived Data";
    }

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        //subfield 1
        if(fspecDataAtIndex(Fspec.SUBFIELD_1)){
            subfield1 = new Cat062Item380Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        //subfield 2
        if(fspecDataAtIndex(Fspec.SUBFIELD_2)){
            subfield2 = new Cat062Item380Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        //subfield 3
        if(fspecDataAtIndex(Fspec.SUBFIELD_3)){
            subfield3 = new Cat062Item380Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }

        //subfield 4
        if(fspecDataAtIndex(Fspec.SUBFIELD_4)){
            subfield4 = new Cat062Item380Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        //subfield 5
        if(fspecDataAtIndex(Fspec.SUBFIELD_5)){
            subfield5 = new Cat062Item380Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        //subfield 6
        if(fspecDataAtIndex(Fspec.SUBFIELD_6)){
            subfield6 = new Cat062Item380Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }

        //subfield 7
        if(fspecDataAtIndex(Fspec.SUBFIELD_7)){
            subfield7 = new Cat062Item380Subfield7();
            offset = subfield7.decode(input, offset, length);
            appendDebugMsg(subfield7.getDebugString());
        }

        //subfield 8
        if(fspecDataAtIndex(Fspec.SUBFIELD_8)){
            subfield8 = new Cat062Item380Subfield8();
            offset = subfield8.decode(input, offset, length);
            appendDebugMsg(subfield8.getDebugString());
        }

        //subfield 9
        if(fspecDataAtIndex(Fspec.SUBFIELD_9)){
            subfield9 = new Cat062Item380Subfield9();
            offset = subfield9.decode(input, offset, length);
            appendDebugMsg(subfield9.getDebugString());
        }

        //subfield 10
        if(fspecDataAtIndex(Fspec.SUBFIELD_10)){
            subfield10 = new Cat062Item380Subfield10();
            offset = subfield10.decode(input, offset, length);
            appendDebugMsg(subfield10.getDebugString());
        }

        //subfield 11
        if(fspecDataAtIndex(Fspec.SUBFIELD_11)){
            subfield11 = new Cat062Item380Subfield11();
            offset = subfield11.decode(input, offset, length);
            appendDebugMsg(subfield11.getDebugString());
        }

        //subfield 12
        if(fspecDataAtIndex(Fspec.SUBFIELD_12)){
            subfield12 = new Cat062Item380Subfield12();
            offset = subfield12.decode(input, offset, length);
            appendDebugMsg(subfield12.getDebugString());
        }

        //subfield 13
        if(fspecDataAtIndex(Fspec.SUBFIELD_13)){
            subfield13 = new Cat062Item380Subfield13();
            offset = subfield13.decode(input, offset, length);
            appendDebugMsg(subfield13.getDebugString());
        }

        //subfield 14
        if(fspecDataAtIndex(Fspec.SUBFIELD_14)){
            subfield14 = new Cat062Item380Subfield14();
            offset = subfield14.decode(input, offset, length);
            appendDebugMsg(subfield14.getDebugString());
        }

        //subfield 15
        if(fspecDataAtIndex(Fspec.SUBFIELD_15)){
            subfield15 = new Cat062Item380Subfield15();
            offset = subfield15.decode(input, offset, length);
            appendDebugMsg(subfield15.getDebugString());
        }

        //subfield 16
        if(fspecDataAtIndex(Fspec.SUBFIELD_16)){
            subfield16 = new Cat062Item380Subfield16();
            offset = subfield16.decode(input, offset, length);
            appendDebugMsg(subfield16.getDebugString());
        }

        //subfield 17
        if(fspecDataAtIndex(Fspec.SUBFIELD_17)){
            subfield17 = new Cat062Item380Subfield17();
            offset = subfield17.decode(input, offset, length);
            appendDebugMsg(subfield17.getDebugString());
        }

        //subfield 18
        if(fspecDataAtIndex(Fspec.SUBFIELD_18)){
            subfield18 = new Cat062Item380Subfield18();
            offset = subfield18.decode(input, offset, length);
            appendDebugMsg(subfield18.getDebugString());
        }

        //subfield 19
        if(fspecDataAtIndex(Fspec.SUBFIELD_19)){
            subfield19 = new Cat062Item380Subfield19();
            offset = subfield19.decode(input, offset, length);
            appendDebugMsg(subfield19.getDebugString());
        }

        //subfield 20
        if(fspecDataAtIndex(Fspec.SUBFIELD_20)){
            subfield20 = new Cat062Item380Subfield20();
            offset = subfield20.decode(input, offset, length);
            appendDebugMsg(subfield20.getDebugString());
        }

        //subfield 21
        if(fspecDataAtIndex(Fspec.SUBFIELD_21)){
            subfield21 = new Cat062Item380Subfield21();
            offset = subfield21.decode(input, offset, length);
            appendDebugMsg(subfield21.getDebugString());
        }

        //subfield 22
        if(fspecDataAtIndex(Fspec.SUBFIELD_22)){
            subfield22 = new Cat062Item380Subfield22();
            offset = subfield22.decode(input, offset, length);
            appendDebugMsg(subfield22.getDebugString());
        }

        //subfield 23
        if(fspecDataAtIndex(Fspec.SUBFIELD_23)){
            subfield23 = new Cat062Item380Subfield23();
            offset = subfield23.decode(input, offset, length);
            appendDebugMsg(subfield23.getDebugString());
        }

        //subfield 24
        if(fspecDataAtIndex(Fspec.SUBFIELD_24)){
            subfield24 = new Cat062Item380Subfield24();
            offset = subfield24.decode(input, offset, length);
            appendDebugMsg(subfield24.getDebugString());
        }

        //subfield 25
        if(fspecDataAtIndex(Fspec.SUBFIELD_25)){
            subfield25 = new Cat062Item380Subfield25();
            offset = subfield25.decode(input, offset, length);
            appendDebugMsg(subfield25.getDebugString());
        }

        //subfield 26
        if(fspecDataAtIndex(Fspec.SUBFIELD_26)){
            subfield26 = new Cat062Item380Subfield26();
            offset = subfield26.decode(input, offset, length);
            appendDebugMsg(subfield26.getDebugString());
        }

        //subfield 27
        if(fspecDataAtIndex(Fspec.SUBFIELD_27)){
            subfield27 = new Cat062Item380Subfield27();
            offset = subfield27.decode(input, offset, length);
            appendDebugMsg(subfield27.getDebugString());
        }

        //subfield 28
        if(fspecDataAtIndex(Fspec.SUBFIELD_28)){
            subfield28 = new Cat062Item380Subfield28();
            offset = subfield28.decode(input, offset, length);
            appendDebugMsg(subfield28.getDebugString());
        }

        return offset;
    }

    public Cat062Item380Subfield1 getSubfield1() {
        return subfield1;
    }

    public void setSubfield1(Cat062Item380Subfield1 subfield1) {
        this.subfield1 = subfield1;
    }

    public Cat062Item380Subfield2 getSubfield2() {
        return subfield2;
    }

    public void setSubfield2(Cat062Item380Subfield2 subfield2) {
        this.subfield2 = subfield2;
    }

    public Cat062Item380Subfield3 getSubfield3() {
        return subfield3;
    }

    public void setSubfield3(Cat062Item380Subfield3 subfield3) {
        this.subfield3 = subfield3;
    }

    public Cat062Item380Subfield4 getSubfield4() {
        return subfield4;
    }

    public void setSubfield4(Cat062Item380Subfield4 subfield4) {
        this.subfield4 = subfield4;
    }

    public Cat062Item380Subfield5 getSubfield5() {
        return subfield5;
    }

    public void setSubfield5(Cat062Item380Subfield5 subfield5) {
        this.subfield5 = subfield5;
    }

    public Cat062Item380Subfield6 getSubfield6() {
        return subfield6;
    }

    public void setSubfield6(Cat062Item380Subfield6 subfield6) {
        this.subfield6 = subfield6;
    }

    public Cat062Item380Subfield7 getSubfield7() {
        return subfield7;
    }

    public void setSubfield7(Cat062Item380Subfield7 subfield7) {
        this.subfield7 = subfield7;
    }

    public Cat062Item380Subfield8 getSubfield8() {
        return subfield8;
    }

    public void setSubfield8(Cat062Item380Subfield8 subfield8) {
        this.subfield8 = subfield8;
    }

    public Cat062Item380Subfield9 getSubfield9() {
        return subfield9;
    }

    public void setSubfield9(Cat062Item380Subfield9 subfield9) {
        this.subfield9 = subfield9;
    }

    public Cat062Item380Subfield10 getSubfield10() {
        return subfield10;
    }

    public void setSubfield10(Cat062Item380Subfield10 subfield10) {
        this.subfield10 = subfield10;
    }

    public Cat062Item380Subfield11 getSubfield11() {
        return subfield11;
    }

    public void setSubfield11(Cat062Item380Subfield11 subfield11) {
        this.subfield11 = subfield11;
    }

    public Cat062Item380Subfield12 getSubfield12() {
        return subfield12;
    }

    public void setSubfield12(Cat062Item380Subfield12 subfield12) {
        this.subfield12 = subfield12;
    }

    public Cat062Item380Subfield13 getSubfield13() {
        return subfield13;
    }

    public void setSubfield13(Cat062Item380Subfield13 subfield13) {
        this.subfield13 = subfield13;
    }

    public Cat062Item380Subfield14 getSubfield14() {
        return subfield14;
    }

    public void setSubfield14(Cat062Item380Subfield14 subfield14) {
        this.subfield14 = subfield14;
    }

    public Cat062Item380Subfield15 getSubfield15() {
        return subfield15;
    }

    public void setSubfield15(Cat062Item380Subfield15 subfield15) {
        this.subfield15 = subfield15;
    }

    public Cat062Item380Subfield16 getSubfield16() {
        return subfield16;
    }

    public void setSubfield16(Cat062Item380Subfield16 subfield16) {
        this.subfield16 = subfield16;
    }

    public Cat062Item380Subfield17 getSubfield17() {
        return subfield17;
    }

    public void setSubfield17(Cat062Item380Subfield17 subfield17) {
        this.subfield17 = subfield17;
    }

    public Cat062Item380Subfield18 getSubfield18() {
        return subfield18;
    }

    public void setSubfield18(Cat062Item380Subfield18 subfield18) {
        this.subfield18 = subfield18;
    }

    public Cat062Item380Subfield19 getSubfield19() {
        return subfield19;
    }

    public void setSubfield19(Cat062Item380Subfield19 subfield19) {
        this.subfield19 = subfield19;
    }

    public Cat062Item380Subfield20 getSubfield20() {
        return subfield20;
    }

    public void setSubfield20(Cat062Item380Subfield20 subfield20) {
        this.subfield20 = subfield20;
    }

    public Cat062Item380Subfield21 getSubfield21() {
        return subfield21;
    }

    public void setSubfield21(Cat062Item380Subfield21 subfield21) {
        this.subfield21 = subfield21;
    }

    public Cat062Item380Subfield22 getSubfield22() {
        return subfield22;
    }

    public void setSubfield22(Cat062Item380Subfield22 subfield22) {
        this.subfield22 = subfield22;
    }

    public Cat062Item380Subfield23 getSubfield23() {
        return subfield23;
    }

    public void setSubfield23(Cat062Item380Subfield23 subfield23) {
        this.subfield23 = subfield23;
    }

    public Cat062Item380Subfield24 getSubfield24() {
        return subfield24;
    }

    public void setSubfield24(Cat062Item380Subfield24 subfield24) {
        this.subfield24 = subfield24;
    }

    public Cat062Item380Subfield25 getSubfield25() {
        return subfield25;
    }

    public void setSubfield25(Cat062Item380Subfield25 subfield25) {
        this.subfield25 = subfield25;
    }

    public Cat062Item380Subfield26 getSubfield26() {
        return subfield26;
    }

    public void setSubfield26(Cat062Item380Subfield26 subfield26) {
        this.subfield26 = subfield26;
    }

    public Cat062Item380Subfield27 getSubfield27() {
        return subfield27;
    }

    public void setSubfield27(Cat062Item380Subfield27 subfield27) {
        this.subfield27 = subfield27;
    }

    public Cat062Item380Subfield28 getSubfield28() {
        return subfield28;
    }

    public void setSubfield28(Cat062Item380Subfield28 subfield28) {
        this.subfield28 = subfield28;
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
        static final int SUBFIELD_21 = 17;
        static final int SUBFIELD_20 = 18;
        static final int SUBFIELD_19 = 19;
        static final int SUBFIELD_18 = 20;
        static final int SUBFIELD_17 = 21;
        static final int SUBFIELD_16 = 22;
        static final int SUBFIELD_15 = 23;

        //forth extent
        static final int SUBFIELD_28 = 25;
        static final int SUBFIELD_27 = 26;
        static final int SUBFIELD_26 = 27;
        static final int SUBFIELD_25 = 28;
        static final int SUBFIELD_24 = 29;
        static final int SUBFIELD_23 = 30;
        static final int SUBFIELD_22 = 31;
    }
}
