/**
 * Created by alexandru on 8/8/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.*;
import jlg.jade.asterix.cat048.item120.Cat048Item120;
import jlg.jade.asterix.cat048.item130.Cat048Item130;

public class Cat048Record extends FspecAsterixData {
    private final ReservedFieldFactory reservedFieldFactory;

    private Cat048Item010 item010;

    private Cat048Item140 item140;
    private Cat048Item020 item020;
    private Cat048Item040 item040;
    private Cat048Item070 item070;
    private Cat048Item090 item090;
    private Cat048Item130 item130;
    private Cat048Item220 item220;
    private Cat048Item240 item240;
    private Cat048Item250 item250;
    private Cat048Item161 item161;
    private Cat048Item042 item042;
    private Cat048Item200 item200;
    private Cat048Item170 item170;
    private Cat048Item210 item210;
    private Cat048Item030 item030;
    private Cat048Item080 item080;
    private Cat048Item100 item100;
    private Cat048Item110 item110;
    private Cat048Item120 item120;
    private Cat048Item230 item230;
    private Cat048Item260 item260;
    private Cat048Item055 item055;
    private Cat048Item050 item050;
    private Cat048Item065 item065;
    private Cat048Item060 item060;

    private ReservedAsterixField reservedSpecialPurposeField;
    private ReservedAsterixField reservedExpansionField;

    public Cat048Record() {
        this.reservedFieldFactory = new DefaultReservedFieldFactory();
    }

    @Override
    protected String setDisplayName() {
        return "*** Category 048 Record ***";
    }

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {

        if (fspecDataAtIndex(FSPEC.I048_010)) {
            this.item010 = new Cat048Item010();
            offset = item010.decode(input, offset, length);
            appendDebugMsg(item010.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_140)) {
            this.item140 = new Cat048Item140();
            offset = item140.decode(input, offset, length);
            appendDebugMsg(item140.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_020)) {
            this.item020 = new Cat048Item020();
            offset = item020.decode(input, offset, length);
            appendDebugMsg(item020.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_040)) {
            this.item040 = new Cat048Item040();
            offset = item040.decode(input, offset, length);
            appendDebugMsg(item040.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_070)) {
            this.item070 = new Cat048Item070();
            offset = item070.decode(input, offset, length);
            appendDebugMsg(item070.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_090)) {
            this.item090 = new Cat048Item090();
            offset = item090.decode(input, offset, length);
            appendDebugMsg(item090.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_130)) {
            this.item130 = new Cat048Item130();
            offset = item130.decode(input, offset, length);
            appendDebugMsg(item130.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_220)) {
            this.item220 = new Cat048Item220();
            offset = item220.decode(input, offset, length);
            appendDebugMsg(item220.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_240)) {
            this.item240 = new Cat048Item240();
            offset = item240.decode(input, offset, length);
            appendDebugMsg(item240.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_250)) {
            this.item250 = new Cat048Item250();
            offset = item250.decode(input, offset, length);
            appendDebugMsg(item250.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_161)) {
            this.item161 = new Cat048Item161();
            offset = item161.decode(input, offset, length);
            appendDebugMsg(item161.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_042)) {
            this.item042 = new Cat048Item042();
            offset = item042.decode(input, offset, length);
            appendDebugMsg(item042.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_200)) {
            this.item200 = new Cat048Item200();
            offset = item200.decode(input, offset, length);
            appendDebugMsg(item200.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_170)) {
            this.item170 = new Cat048Item170();
            offset = item170.decode(input, offset, length);
            appendDebugMsg(item170.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_210)) {
            this.item210 = new Cat048Item210();
            offset = item210.decode(input, offset, length);
            appendDebugMsg(item210.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_030)) {
            this.item030 = new Cat048Item030();
            offset = item030.decode(input, offset, length);
            appendDebugMsg(item030.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_080)) {
            this.item080 = new Cat048Item080();
            offset = item080.decode(input, offset, length);
            appendDebugMsg(item080.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_100)) {
            this.item100 = new Cat048Item100();
            offset = item100.decode(input, offset, length);
            appendDebugMsg(item100.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_110)) {
            this.item110 = new Cat048Item110();
            offset = item110.decode(input, offset, length);
            appendDebugMsg(item110.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_120)) {
            this.item120 = new Cat048Item120();
            offset = item120.decode(input, offset, length);
            appendDebugMsg(item120.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_230)) {
            this.item230 = new Cat048Item230();
            offset = item230.decode(input, offset, length);
            appendDebugMsg(item230.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_260)) {
            this.item260 = new Cat048Item260();
            offset = item260.decode(input, offset, length);
            appendDebugMsg(item260.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_055)) {
            this.item055 = new Cat048Item055();
            offset = item055.decode(input, offset, length);
            appendDebugMsg(item055.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_050)) {
            this.item050 = new Cat048Item050();
            offset = item050.decode(input, offset, length);
            appendDebugMsg(item050.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_065)) {
            this.item065 = new Cat048Item065();
            offset = item065.decode(input, offset, length);
            appendDebugMsg(item065.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I048_060)) {
            this.item060 = new Cat048Item060();
            offset = item060.decode(input, offset, length);
            appendDebugMsg(item060.getDebugString());
        }

        // SP
        if (fspecDataAtIndex(FSPEC.I048_SP)) {
            this.reservedSpecialPurposeField = this.reservedFieldFactory.createSpField();
            offset = reservedSpecialPurposeField.decode(input, offset, length);
            appendDebugMsg(this.reservedSpecialPurposeField.getDebugString());
        }

        // RE
        if (fspecDataAtIndex(FSPEC.I048_RE)) {
            this.reservedExpansionField = this.reservedFieldFactory.createReField();
            offset = reservedExpansionField.decode(input, offset, length);
            appendDebugMsg(this.reservedExpansionField.getDebugString());
        }

        appendDebugMsg("*** End of Category 048 Record ***");
        appendNewLine();

        return offset;
    }

    private static class FSPEC {

        // first octet
        public final static int I048_010 = 7;

        public final static int I048_140 = 6;
        public final static int I048_020 = 5;
        public final static int I048_040 = 4;
        public final static int I048_070 = 3;
        public final static int I048_090 = 2;
        public final static int I048_130 = 1;
        // second octet
        public final static int I048_220 = 15;
        public final static int I048_240 = 14;

        public final static int I048_250 = 13;
        public final static int I048_161 = 12;
        public final static int I048_042 = 11;
        public final static int I048_200 = 10;
        public final static int I048_170 = 9;
        // third octet
        public final static int I048_210 = 23;
        public final static int I048_030 = 22;

        public final static int I048_080 = 21;
        public final static int I048_100 = 20;
        public final static int I048_110 = 19;
        public final static int I048_120 = 18;
        public final static int I048_230 = 17;
        // fourth octet
        public final static int I048_260 = 31;
        public final static int I048_055 = 30;

        public final static int I048_050 = 29;
        public final static int I048_065 = 28;
        public final static int I048_060 = 27;
        public final static int I048_SP = 26;
        public final static int I048_RE = 25;
    }
    public Cat048Item010 getItem010() {
        return item010;
    }

    public Cat048Item140 getItem140() {
        return item140;
    }

    public Cat048Item020 getItem020() {
        return item020;
    }

    public Cat048Item040 getItem040() {
        return item040;
    }

    public Cat048Item070 getItem070() {
        return item070;
    }

    public Cat048Item090 getItem090() {
        return item090;
    }

    public Cat048Item130 getItem130() {
        return item130;
    }

    public Cat048Item220 getItem220() {
        return item220;
    }

    public Cat048Item240 getItem240() {
        return item240;
    }

    public Cat048Item250 getItem250() {
        return item250;
    }

    public Cat048Item161 getItem161() {
        return item161;
    }

    public Cat048Item042 getItem042() {
        return item042;
    }

    public Cat048Item200 getItem200() {
        return item200;
    }

    public Cat048Item170 getItem170() {
        return item170;
    }

    public Cat048Item210 getItem210() {
        return item210;
    }

    public Cat048Item030 getItem030() {
        return item030;
    }

    public Cat048Item080 getItem080() {
        return item080;
    }

    public Cat048Item100 getItem100() {
        return item100;
    }

    public Cat048Item110 getItem110() {
        return item110;
    }

    public Cat048Item120 getItem120() {
        return item120;
    }

    public Cat048Item230 getItem230() {
        return item230;
    }

    public Cat048Item260 getItem260() {
        return item260;
    }

    public Cat048Item055 getItem055() {
        return item055;
    }

    public Cat048Item050 getItem050() {
        return item050;
    }

    public Cat048Item065 getItem065() {
        return item065;
    }

    public Cat048Item060 getItem060() {
        return item060;
    }

    public ReservedAsterixField getReservedSpecialPurposeField() {
        return reservedSpecialPurposeField;
    }

    public ReservedAsterixField getReservedExpansionField() {
        return reservedExpansionField;
    }
}
