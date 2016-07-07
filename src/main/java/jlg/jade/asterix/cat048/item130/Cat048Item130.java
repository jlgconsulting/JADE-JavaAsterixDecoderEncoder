/**
 * Created by alexandru on 7/7/16.
 */
package jlg.jade.asterix.cat048.item130;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat048Item130 - Radar Plot Characteristics
 * Additional information on the quality of the target report.
 */
public class Cat048Item130 extends FspecAsterixData{
    private Cat048Item130Subfield1 subfield1;
    private Cat048Item130Subfield2 subfield2;
    private Cat048Item130Subfield3 subfield3;
    private Cat048Item130Subfield4 subfield4;
    private Cat048Item130Subfield5 subfield5;
    private Cat048Item130Subfield6 subfield6;
    private Cat048Item130Subfield7 subfield7;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        // subfield 1
        if(fspecDataAtIndex(Fspec.SUBFIELD_1)){
            this.subfield1 = new Cat048Item130Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        // subfield 2
        if(fspecDataAtIndex(Fspec.SUBFIELD_2)){
            this.subfield2 = new Cat048Item130Subfield2();
            offset = subfield2.decode(input, offset, length);
            appendDebugMsg(subfield2.getDebugString());
        }

        // subfield 3
        if(fspecDataAtIndex(Fspec.SUBFIELD_3)){
            this.subfield3 = new Cat048Item130Subfield3();
            offset = subfield3.decode(input, offset, length);
            appendDebugMsg(subfield3.getDebugString());
        }

        // subfield 4
        if(fspecDataAtIndex(Fspec.SUBFIELD_4)){
            this.subfield4 = new Cat048Item130Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        // subfield 5
        if(fspecDataAtIndex(Fspec.SUBFIELD_5)){
            this.subfield5 = new Cat048Item130Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        // subfield 6
        if(fspecDataAtIndex(Fspec.SUBFIELD_6)){
            this.subfield6 = new Cat048Item130Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }

        // subfield 7
        if(fspecDataAtIndex(Fspec.SUBFIELD_7)){
            this.subfield7 = new Cat048Item130Subfield7();
            offset = subfield7.decode(input, offset, length);
            appendDebugMsg(subfield7.getDebugString());
        }

        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item130 - Radar Plot Characteristics";
    }

    public Cat048Item130Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat048Item130Subfield2 getSubfield2() {
        return subfield2;
    }

    public Cat048Item130Subfield3 getSubfield3() {
        return subfield3;
    }

    public Cat048Item130Subfield4 getSubfield4() {
        return subfield4;
    }

    public Cat048Item130Subfield5 getSubfield5() {
        return subfield5;
    }

    public Cat048Item130Subfield6 getSubfield6() {
        return subfield6;
    }

    public Cat048Item130Subfield7 getSubfield7() {
        return subfield7;
    }

    private class Fspec {
        public static final int SUBFIELD_1 = 7;
        public static final int SUBFIELD_2 = 6;
        public static final int SUBFIELD_3 = 5;
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_5 = 3;
        public static final int SUBFIELD_6 = 2;
        public static final int SUBFIELD_7 = 1;
    }
}
