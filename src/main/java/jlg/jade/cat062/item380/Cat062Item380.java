/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item380;

import jlg.jade.abstraction.FspecAsterixData;
import jlg.jade.abstraction.VariableLengthAsterixData;
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
    protected int decodeFromByteArray(byte[] input, int offset) {
        return 0;
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
