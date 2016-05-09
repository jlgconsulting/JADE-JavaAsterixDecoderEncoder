/* 
* Created by dan-geabunea on 5/5/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item290;

import jlg.jade.abstraction.Cat062AsterixAgingDataField;
import jlg.jade.abstraction.FspecAsterixData;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 390 - System track update ages
 * Ages of the last plot/local track/target report update for each sensor type.
 * Compound Data Item, comprising a primary subfield of up to two
 * octets, followed by the indicated subfields.
 */
public class Cat062Item290 extends FspecAsterixData {
    private Cat062AsterixAgingDataField subfield1;
    private Cat062AsterixAgingDataField subfield2;
    private Cat062AsterixAgingDataField subfield3;
    private Cat062AsterixAgingDataField subfield4;
    private Item290Subfield5 subfield5;
    private Cat062AsterixAgingDataField subfield6;
    private Cat062AsterixAgingDataField subfield7;
    private Cat062AsterixAgingDataField subfield8;
    private Cat062AsterixAgingDataField subfield9;
    private Cat062AsterixAgingDataField subfield10;


    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if(fspecDataAtIndex(Fspec.SUBFIELD_1)){
            subfield1 = new Cat062AsterixAgingDataField();
            offset = subfield1.decode(input,offset,length);

            appendDebugMsg("Item290Subfield1 - Track age");
            appendNewLine();
            appendDebugMsg(subfield1.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_2)){
            subfield2 = new Cat062AsterixAgingDataField();
            offset = subfield2.decode(input,offset,length);

            appendDebugMsg("Item290Subfield2 - PSR age");
            appendNewLine();
            appendDebugMsg(subfield2.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_3)){
            subfield3 = new Cat062AsterixAgingDataField();
            offset = subfield3.decode(input,offset,length);

            appendDebugMsg("Item290Subfield3 - SSR age");
            appendNewLine();
            appendDebugMsg(subfield3.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_4)){
            subfield4 = new Cat062AsterixAgingDataField();
            offset = subfield4.decode(input,offset,length);

            appendDebugMsg("Item290Subfield4 - Mode S age");
            appendNewLine();
            appendDebugMsg(subfield4.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_5)){
            subfield5 = new Item290Subfield5();
            offset = subfield5.decode(input,offset,length);

            appendDebugMsg("Item290Subfield5 - ADSC age");
            appendNewLine();
            appendDebugMsg(subfield5.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_6)){
            subfield6 = new Cat062AsterixAgingDataField();
            offset = subfield6.decode(input,offset,length);

            appendDebugMsg("Item290Subfield6 - ADSB age");
            appendNewLine();
            appendDebugMsg(subfield6.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_7)){
            subfield7 = new Cat062AsterixAgingDataField();
            offset = subfield7.decode(input,offset,length);

            appendDebugMsg("Item290Subfield7 - ADSB VDL age");
            appendNewLine();
            appendDebugMsg(subfield7.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_8)) {
            subfield8 = new Cat062AsterixAgingDataField();
            offset = subfield8.decode(input, offset, length);

            appendDebugMsg("Item290Subfield8 - ADSB UAT age");
            appendNewLine();
            appendDebugMsg(subfield8.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_9)){
            subfield9 = new Cat062AsterixAgingDataField();
            offset = subfield9.decode(input,offset,length);

            appendDebugMsg("Item290Subfield9 - Loop age");
            appendNewLine();
            appendDebugMsg(subfield9.getDebugString());
        }

        if(fspecDataAtIndex(Fspec.SUBFIELD_10)){
            subfield10 = new Cat062AsterixAgingDataField();
            offset = subfield10.decode(input,offset,length);

            appendDebugMsg("Item290Subfield10 - Multilateration age");
            appendNewLine();
            appendDebugMsg(subfield10.getDebugString());
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

    public Item290Subfield5 getSubfield5() {
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
    
    private static class Fspec{
        //first extent
        public static final int SUBFIELD_7 = 1;
        public static final int SUBFIELD_6 = 2;
        public static final int SUBFIELD_5 = 3;
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_3 = 5;
        public static final int SUBFIELD_2 = 6;
        public static final int SUBFIELD_1 = 7;

        //second extent (4 spare bits)
        public static final int SUBFIELD_10 = 13;
        public static final int SUBFIELD_9 = 14;
        public static final int SUBFIELD_8 = 15;
    }
}
