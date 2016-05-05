/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.FspecAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Asterix Cat 062 Item 380 - Aircraft Derived Data
 */
public class Cat062Item380 extends FspecAsterixData {
    private Item380Subfield1 subfield1;
    private Item380Subfield2 subfield2;
    private Item380Subfield3 subfield3;
    private Item380Subfield4 subfield4;
    private Item380Subfield5 subfield5;
    private Item380Subfield6 subfield6;
    private Item380Subfield7 subfield7;
    private Item380Subfield8 subfield8;
    private Item380Subfield9 subfield9;
    private Item380Subfield10 subfield10;
    private Item380Subfield11 subfield11;
    private Item380Subfield12 subfield12;
    private Item380Subfield13 subfield13;
    private Item380Subfield14 subfield14;
    private Item380Subfield15 subfield15;
    private Item380Subfield16 subfield16;
    private Item380Subfield17 subfield17;
    private Item380Subfield18 subfield18;
    private Item380Subfield19 subfield19;
    private Item380Subfield20 subfield20;
    private Item380Subfield21 subfield21;
    private Item380Subfield22 subfield22;
    private Item380Subfield23 subfield23;
    private Item380Subfield24 subfield24;
    private Item380Subfield25 subfield25;
    private Item380Subfield26 subfield26;
    private Item380Subfield27 subfield27;
    private Item380Subfield28 subfield28;

    public Cat062Item380(){
    }

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        //subfield 1
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_1)){
            subfield1 = new Item380Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }
        else{
            appendDebugMsg(subfield1.getClass().getSimpleName() + ": Not present in data");
            appendNewLine();
        }

        //subfield 2
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_2)){
            subfield2 = new Item380Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 2 is not present in data");
            appendNewLine();
        }

        //subfield 3
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_3)){
            subfield3 = new Item380Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 3 is not present in data");
            appendNewLine();
        }

        //subfield 4
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_4)){
            subfield4 = new Item380Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 4 is not present in data");
            appendNewLine();
        }

        //subfield 5
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_5)){
            subfield5 = new Item380Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 5 is not present in data");
            appendNewLine();
        }

        //subfield 6
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_6)){
            subfield6 = new Item380Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 6 is not present in data");
            appendNewLine();
        }

        //subfield 7
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_7)){
            subfield7 = new Item380Subfield7();
            offset = subfield7.decode(input, offset, length);
            appendDebugMsg(subfield7.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 7 is not present in data");
            appendNewLine();
        }

        //subfield 8
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_8)){
            subfield8 = new Item380Subfield8();
            offset = subfield8.decode(input, offset, length);
            appendDebugMsg(subfield8.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 8 is not present in data");
            appendNewLine();
        }

        //subfield 9
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_9)){
            subfield9 = new Item380Subfield9();
            offset = subfield9.decode(input, offset, length);
            appendDebugMsg(subfield9.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 9 is not present in data");
            appendNewLine();
        }

        //subfield 10
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_10)){
            subfield10 = new Item380Subfield10();
            offset = subfield10.decode(input, offset, length);
            appendDebugMsg(subfield10.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 10 is not present in data");
            appendNewLine();
        }

        //subfield 11
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_11)){
            subfield11 = new Item380Subfield11();
            offset = subfield11.decode(input, offset, length);
            appendDebugMsg(subfield11.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 11 is not present in data");
            appendNewLine();
        }

        //subfield 12
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_12)){
            subfield12 = new Item380Subfield12();
            offset = subfield12.decode(input, offset, length);
            appendDebugMsg(subfield12.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 12 is not present in data");
            appendNewLine();
        }

        //subfield 13
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_13)){
            subfield13 = new Item380Subfield13();
            offset = subfield13.decode(input, offset, length);
            appendDebugMsg(subfield13.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 13 is not present in data");
            appendNewLine();
        }

        //subfield 14
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_14)){
            subfield14 = new Item380Subfield14();
            offset = subfield14.decode(input, offset, length);
            appendDebugMsg(subfield14.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 14 is not present in data");
            appendNewLine();
        }

        //subfield 15
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_15)){
            subfield15 = new Item380Subfield15();
            offset = subfield15.decode(input, offset, length);
            appendDebugMsg(subfield15.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 15 is not present in data");
            appendNewLine();
        }

        //subfield 16
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_16)){
            subfield16 = new Item380Subfield16();
            offset = subfield16.decode(input, offset, length);
            appendDebugMsg(subfield16.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 16 is not present in data");
            appendNewLine();
        }

        //subfield 17
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_17)){
            subfield17 = new Item380Subfield17();
            offset = subfield17.decode(input, offset, length);
            appendDebugMsg(subfield17.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 17 is not present in data");
            appendNewLine();
        }

        //subfield 18
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_18)){
            subfield18 = new Item380Subfield18();
            offset = subfield18.decode(input, offset, length);
            appendDebugMsg(subfield18.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 18 is not present in data");
            appendNewLine();
        }

        //subfield 19
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_19)){
            subfield19 = new Item380Subfield19();
            offset = subfield19.decode(input, offset, length);
            appendDebugMsg(subfield19.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 19 is not present in data");
            appendNewLine();
        }

        //subfield 20
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_20)){
            subfield20 = new Item380Subfield20();
            offset = subfield20.decode(input, offset, length);
            appendDebugMsg(subfield20.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 20 is not present in data");
            appendNewLine();
        }

        //subfield 21
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_21)){
            subfield21 = new Item380Subfield21();
            offset = subfield21.decode(input, offset, length);
            appendDebugMsg(subfield21.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 21 is not present in data");
            appendNewLine();
        }

        //subfield 22
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_22)){
            subfield22 = new Item380Subfield22();
            offset = subfield22.decode(input, offset, length);
            appendDebugMsg(subfield22.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 22 is not present in data");
            appendNewLine();
        }

        //subfield 23
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_23)){
            subfield23 = new Item380Subfield23();
            offset = subfield23.decode(input, offset, length);
            appendDebugMsg(subfield23.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 23 is not present in data");
            appendNewLine();
        }

        //subfield 24
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_24)){
            subfield24 = new Item380Subfield24();
            offset = subfield24.decode(input, offset, length);
            appendDebugMsg(subfield24.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 24 is not present in data");
            appendNewLine();
        }

        //subfield 25
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_25)){
            subfield25 = new Item380Subfield25();
            offset = subfield25.decode(input, offset, length);
            appendDebugMsg(subfield25.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 25 is not present in data");
            appendNewLine();
        }

        //subfield 26
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_26)){
            subfield26 = new Item380Subfield26();
            offset = subfield26.decode(input, offset, length);
            appendDebugMsg(subfield26.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 26 is not present in data");
            appendNewLine();
        }

        //subfield 27
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_27)){
            subfield27 = new Item380Subfield27();
            offset = subfield27.decode(input, offset, length);
            appendDebugMsg(subfield27.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 27 is not present in data");
            appendNewLine();
        }

        //subfield 28
        if(isDataPresent(Cat062Item380Fspec.SUBFIELD_28)){
            subfield28 = new Item380Subfield28();
            offset = subfield28.decode(input, offset, length);
            appendDebugMsg(subfield28.getDebugString());
        }
        else{
            appendDebugMsg("Item380Subfield 28 is not present in data");
            appendNewLine();
        }

        return offset;
    }

    public Item380Subfield1 getSubfield1() {
        return subfield1;
    }

    public Item380Subfield2 getSubfield2() {
        return subfield2;
    }

    public Item380Subfield3 getSubfield3() {
        return subfield3;
    }

    public Item380Subfield4 getSubfield4() {
        return subfield4;
    }

    public Item380Subfield5 getSubfield5() {
        return subfield5;
    }

    public Item380Subfield6 getSubfield6() {
        return subfield6;
    }

    public Item380Subfield7 getSubfield7() {
        return subfield7;
    }

    public Item380Subfield8 getSubfield8() {
        return subfield8;
    }

    public Item380Subfield9 getSubfield9() {
        return subfield9;
    }

    public Item380Subfield10 getSubfield10() {
        return subfield10;
    }

    public Item380Subfield11 getSubfield11() {
        return subfield11;
    }

    public Item380Subfield12 getSubfield12() {
        return subfield12;
    }

    public Item380Subfield13 getSubfield13() {
        return subfield13;
    }

    public Item380Subfield14 getSubfield14() {
        return subfield14;
    }

    public Item380Subfield15 getSubfield15() {
        return subfield15;
    }

    public Item380Subfield16 getSubfield16() {
        return subfield16;
    }

    public Item380Subfield17 getSubfield17() {
        return subfield17;
    }

    public Item380Subfield18 getSubfield18() {
        return subfield18;
    }

    public Item380Subfield19 getSubfield19() {
        return subfield19;
    }

    public Item380Subfield20 getSubfield20() {
        return subfield20;
    }

    public Item380Subfield21 getSubfield21() {
        return subfield21;
    }

    public Item380Subfield22 getSubfield22() {
        return subfield22;
    }

    public Item380Subfield23 getSubfield23() {
        return subfield23;
    }

    public Item380Subfield24 getSubfield24() {
        return subfield24;
    }

    public Item380Subfield25 getSubfield25() {
        return subfield25;
    }

    public Item380Subfield26 getSubfield26() {
        return subfield26;
    }

    public Item380Subfield27 getSubfield27() {
        return subfield27;
    }

    public Item380Subfield28 getSubfield28() {
        return subfield28;
    }
}
