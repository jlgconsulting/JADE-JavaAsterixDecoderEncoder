/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004;

import jlg.jade.asterix.*;
import jlg.jade.asterix.cat004.item070.Cat004Item070;
import jlg.jade.asterix.cat004.item100.Cat004Item100;
import jlg.jade.asterix.cat004.item120.Cat004Item120;

/**
 * Asterix Category 004 - Safety Nets
 */
public class Cat004Record extends FspecAsterixData {
    private final ReservedFieldFactory reservedFieldFactory;
    private Cat004Item010 item010;
    private Cat004Item000 item000;
    private Cat004Item015 item015;
    private Cat004Item020 item020;
    private Cat004Item040 item040;
    private Cat004Item045 item045;
    private Cat004Item060 item060;
    private Cat004Item030 item030;
    private Cat004Item170 item170;
    private Cat004Item120 item120;
    private Cat004Item070 item070;
    private Cat004Item076 item076;
    private Cat004Item074 item074;
    private Cat004Item075 item075;
    private Cat004Item100 item100;
    private Cat004Item035 item035;
    private Cat004Item171 item171;
    private Cat004Item110 item110;
    private ReservedAsterixField reservedExpansionField;
    private ReservedAsterixField specialPurposeField;

    /**
     * Default constructor, which assumes that the RE and SP fields are not present in the data
     * sample.
     * Use this implementation only if these fields are missing. Otherwise, provide custom impl
     * for decoding and encoding of RE and SP
     */
    public Cat004Record() {
        this.reservedFieldFactory = new DefaultReservedFieldFactory();
    }

    @Override
    protected String setDisplayName() {
        return "*** Category 004 Record ***";
    }

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.I004_010)) {
            this.item010 = new Cat004Item010();
            offset = this.item010.decode(input, offset, length);
            appendDebugMsg(this.item010.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_000)) {
            this.item000 = new Cat004Item000();
            offset = this.item000.decode(input, offset, length);
            appendDebugMsg(this.item000.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_015)) {
            this.item015 = new Cat004Item015();
            offset = this.item015.decode(input, offset, length);
            appendDebugMsg(this.item015.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_020)) {
            this.item020 = new Cat004Item020();
            offset = this.item020.decode(input, offset, length);
            appendDebugMsg(this.item020.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_040)) {
            this.item040 = new Cat004Item040();
            offset = this.item040.decode(input, offset, length);
            appendDebugMsg(this.item040.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_045)) {
            this.item045 = new Cat004Item045();
            offset = this.item045.decode(input, offset, length);
            appendDebugMsg(this.item045.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_060)) {
            this.item060 = new Cat004Item060();
            offset = this.item060.decode(input, offset, length);
            appendDebugMsg(this.item060.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_030)) {
            this.item030 = new Cat004Item030();
            offset = this.item030.decode(input, offset, length);
            appendDebugMsg(this.item030.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_170)) {
            this.item170 = new Cat004Item170();
            offset = this.item170.decode(input, offset, length);
            appendDebugMsg(this.item170.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_120)) {
            this.item120 = new Cat004Item120();
            offset = this.item120.decode(input, offset, length);
            appendDebugMsg(this.item120.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_070)) {
            this.item070 = new Cat004Item070();
            offset = this.item070.decode(input, offset, length);
            appendDebugMsg(this.item070.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_076)) {
            this.item076 = new Cat004Item076();
            offset = this.item076.decode(input, offset, length);
            appendDebugMsg(this.item076.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_074)) {
            this.item074 = new Cat004Item074();
            offset = this.item074.decode(input, offset, length);
            appendDebugMsg(this.item074.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_075)) {
            this.item075 = new Cat004Item075();
            offset = this.item075.decode(input, offset, length);
            appendDebugMsg(this.item075.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_100)) {
            this.item100 = new Cat004Item100();
            offset = this.item100.decode(input, offset, length);
            appendDebugMsg(this.item100.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_035)) {
            this.item035 = new Cat004Item035();
            offset = this.item035.decode(input, offset, length);
            appendDebugMsg(this.item035.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_171)) {
            this.item171 = new Cat004Item171();
            offset = this.item171.decode(input, offset, length);
            appendDebugMsg(this.item171.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_110)) {
            this.item110 = new Cat004Item110();
            offset = this.item110.decode(input, offset, length);
            appendDebugMsg(this.item110.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_RE)) {
            this.reservedExpansionField = this.reservedFieldFactory.createReField();
            offset = this.reservedExpansionField.decode(input, offset, length);
            appendDebugMsg(this.reservedExpansionField.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I004_SP)) {
            this.specialPurposeField = this.reservedFieldFactory.createSpField();
            offset = this.specialPurposeField.decode(input, offset, length);
            appendDebugMsg(this.specialPurposeField.getDebugString());
        }

        appendDebugMsg("*** End of Category 004 Record ***");
        appendNewLine();

        return offset;
    }

    /**
     * Custom constructor, which has custom impleemntations for RE and SP fields, according to
     * the specific
     * use cases. Use this constructor when you need to provide custom impl to RE and SP fields.
     */
    public Cat004Record(ReservedFieldFactory reservedFieldFactory) {
        this.reservedFieldFactory = reservedFieldFactory;
    }

    public ReservedFieldFactory getReservedFieldFactory() {
        return reservedFieldFactory;
    }

    public Cat004Item010 getItem010() {
        return item010;
    }

    public Cat004Item000 getItem000() {
        return item000;
    }

    public Cat004Item015 getItem015() {
        return item015;
    }

    public Cat004Item020 getItem020() {
        return item020;
    }

    public Cat004Item040 getItem040() {
        return item040;
    }

    public Cat004Item045 getItem045() {
        return item045;
    }

    public Cat004Item060 getItem060() {
        return item060;
    }

    public Cat004Item030 getItem030() {
        return item030;
    }

    public Cat004Item170 getItem170() {
        return item170;
    }

    public Cat004Item120 getItem120() {
        return item120;
    }

    public Cat004Item070 getItem070() {
        return item070;
    }

    public Cat004Item076 getItem076() {
        return item076;
    }

    public Cat004Item074 getItem074() {
        return item074;
    }

    public Cat004Item075 getItem075() {
        return item075;
    }

    public Cat004Item100 getItem100() {
        return item100;
    }

    public Cat004Item035 getItem035() {
        return item035;
    }

    public Cat004Item171 getItem171() {
        return item171;
    }

    public Cat004Item110 getItem110() {
        return item110;
    }

    public ReservedAsterixField getReservedExpansionField() {
        return reservedExpansionField;
    }

    public ReservedAsterixField getSpecialPurposeField() {
        return specialPurposeField;
    }

    private class Fspec {
        //first octet
        final static int I004_060 = 1;
        final static int I004_045 = 2;
        final static int I004_040 = 3;
        final static int I004_020 = 4;
        final static int I004_015 = 5;
        final static int I004_000 = 6;
        final static int I004_010 = 7;

        //second octet
        final static int I004_075 = 9;
        final static int I004_074 = 10;
        final static int I004_076 = 11;
        final static int I004_070 = 12;
        final static int I004_120 = 13;
        final static int I004_170 = 14;
        final static int I004_030 = 15;

        //third octet
        final static int I004_SP = 17;
        final static int I004_RE = 18;
        final static int I004_110 = 20;
        final static int I004_171 = 21;
        final static int I004_035 = 22;
        final static int I004_100 = 23;
    }
}
