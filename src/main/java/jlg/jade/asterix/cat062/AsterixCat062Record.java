/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.*;
import jlg.jade.asterix.cat062.item110.Cat062Item110;
import jlg.jade.asterix.cat062.item200.Cat062Item200;
import jlg.jade.asterix.cat062.item290.Cat062Item290;
import jlg.jade.asterix.cat062.item340.Cat062Item340;
import jlg.jade.asterix.cat062.item380.Cat062Item380;
import jlg.jade.asterix.cat062.item390.Cat062Item390;
import jlg.jade.asterix.cat062.item500.Cat062Item500;

/**
 * Represents a single Asterix entity which contains a number of data items
 */
public class AsterixCat062Record extends FspecAsterixData {
    private ReservedFieldFactory reservedFieldFactory;
    private Cat062Item010 item010;
    private Cat062Item015 item015;
    private Cat062Item070 item070;
    private Cat062Item105 item105;
    private Cat062Item100 item100;
    private Cat062Item185 item185;
    private Cat062Item210 item210;
    private Cat062Item060 item060;
    private Cat062Item245 item245;
    private Cat062Item380 item380;
    private Cat062Item040 item040;
    private Cat062Item080 item080;
    private Cat062Item290 item290;
    private Cat062Item200 item200;
    private Cat062Item295 item295;
    private Cat062Item136 item136;
    private Cat062Item130 item130;
    private Cat062Item135 item135;
    private Cat062Item220 item220;
    private Cat062Item390 item390;
    private Cat062Item270 item270;
    private Cat062Item300 item300;
    private Cat062Item110 item110;
    private Cat062Item120 item120;
    private Cat062Item510 item510;
    private Cat062Item500 item500;
    private Cat062Item340 item340;
    private ReservedAsterixField reservedExpansionField;
    private ReservedAsterixField specialPurposeField;


    /**
     * Default constructor, which assumes that the RE and SP fields are not present in the data sample.
     * Use this implementation only if these fields are missing. Otherwise, provide custom impl
     * for decoding and encoding of RE and SP
     */
    public AsterixCat062Record() {
        this.reservedFieldFactory = new DefaultReservedFieldFactory();
    }

    @Override
    protected String setDisplayName() {
        return "*** AsterixCat062Record ***";
    }

    /**
     * Custom constructor, which has custom impleemntations for RE and SP fields, according to the specific
     * use cases. Use this constructor when you need to provide custom impl to RE and SP fields.
     */
    public AsterixCat062Record(ReservedFieldFactory reservedFieldFactory) {
        this.reservedFieldFactory = reservedFieldFactory;
    }

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.FIVE_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.I062_010)) {
            this.item010 = new Cat062Item010();
            offset = this.item010.decode(input, offset, length);
            appendDebugMsg(this.item010.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_015)) {
            this.item015 = new Cat062Item015();
            offset = this.item015.decode(input, offset, length);
            appendDebugMsg(this.item015.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_070)) {
            this.item070 = new Cat062Item070();
            offset = this.item070.decode(input, offset, length);
            appendDebugMsg(this.item070.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_105)) {
            this.item105 = new Cat062Item105();
            offset = this.item105.decode(input, offset, length);
            appendDebugMsg(this.item105.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_100)) {
            this.item100 = new Cat062Item100();
            offset = this.item100.decode(input, offset, length);
            appendDebugMsg(this.item100.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_185)) {
            this.item185 = new Cat062Item185();
            offset = this.item185.decode(input, offset, length);
            appendDebugMsg(this.item185.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_210)) {
            this.item210 = new Cat062Item210();
            offset = this.item210.decode(input, offset, length);
            appendDebugMsg(this.item210.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_060)) {
            this.item060 = new Cat062Item060();
            offset = this.item060.decode(input, offset, length);
            appendDebugMsg(this.item060.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_245)) {
            this.item245 = new Cat062Item245();
            offset = this.item245.decode(input, offset, length);
            appendDebugMsg(this.item245.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_380)) {
            this.item380 = new Cat062Item380();
            offset = this.item380.decode(input, offset, length);
            appendDebugMsg(this.item380.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_040)) {
            this.item040 = new Cat062Item040();
            offset = this.item040.decode(input, offset, length);
            appendDebugMsg(this.item040.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_080)) {
            this.item080 = new Cat062Item080();
            offset = this.item080.decode(input, offset, length);
            appendDebugMsg(this.item080.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_290)) {
            this.item290 = new Cat062Item290();
            offset = this.item290.decode(input, offset, length);
            appendDebugMsg(this.item290.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_200)) {
            this.item200 = new Cat062Item200();
            offset = this.item200.decode(input, offset, length);
            appendDebugMsg(this.item200.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_295)) {
            this.item295 = new Cat062Item295();
            offset = this.item295.decode(input, offset, length);
            appendDebugMsg(this.item295.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_136)) {
            this.item136 = new Cat062Item136();
            offset = this.item136.decode(input, offset, length);
            appendDebugMsg(this.item136.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_130)) {
            this.item130 = new Cat062Item130();
            offset = this.item130.decode(input, offset, length);
            appendDebugMsg(this.item130.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_135)) {
            this.item135 = new Cat062Item135();
            offset = this.item135.decode(input, offset, length);
            appendDebugMsg(this.item135.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_220)) {
            this.item220 = new Cat062Item220();
            offset = this.item220.decode(input, offset, length);
            appendDebugMsg(this.item220.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_390)) {
            this.item390 = new Cat062Item390();
            offset = this.item390.decode(input, offset, length);
            appendDebugMsg(this.item390.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_270)) {
            this.item270 = new Cat062Item270();
            offset = this.item270.decode(input, offset, length);
            appendDebugMsg(this.item270.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_300)) {
            this.item300 = new Cat062Item300();
            offset = this.item300.decode(input, offset, length);
            appendDebugMsg(this.item300.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_110)) {
            this.item110 = new Cat062Item110();
            offset = this.item110.decode(input, offset, length);
            appendDebugMsg(this.item110.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_120)) {
            this.item120 = new Cat062Item120();
            offset = this.item120.decode(input, offset, length);
            appendDebugMsg(this.item120.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_510)) {
            this.item510 = new Cat062Item510();
            offset = this.item510.decode(input, offset, length);
            appendDebugMsg(this.item510.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_500)) {
            this.item500 = new Cat062Item500();
            offset = this.item500.decode(input, offset, length);
            appendDebugMsg(this.item500.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_340)) {
            this.item340 = new Cat062Item340();
            offset = this.item340.decode(input, offset, length);
            appendDebugMsg(this.item340.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_SP)) {
            this.specialPurposeField = this.reservedFieldFactory.createSpField();
            offset = this.specialPurposeField.decode(input, offset, length);
            appendDebugMsg(this.specialPurposeField.getDebugString());
        }

        if (fspecDataAtIndex(Fspec.I062_RE)) {
            this.reservedExpansionField = this.reservedFieldFactory.createReField();
            offset = this.reservedExpansionField.decode(input, offset, length);
            appendDebugMsg(this.reservedExpansionField.getDebugString());
        }
        appendDebugMsg("*** End of AsterixCat062Record ***");
        appendNewLine();

        return offset;
    }

    public Cat062Item010 getItem010() {
        return item010;
    }

    public Cat062Item015 getItem015() {
        return item015;
    }

    public Cat062Item070 getItem070() {
        return item070;
    }

    public Cat062Item105 getItem105() {
        return item105;
    }

    public Cat062Item100 getItem100() {
        return item100;
    }

    public Cat062Item185 getItem185() {
        return item185;
    }

    public Cat062Item210 getItem210() {
        return item210;
    }

    public Cat062Item060 getItem060() {
        return item060;
    }

    public Cat062Item245 getItem245() {
        return item245;
    }

    public Cat062Item380 getItem380() {
        return item380;
    }

    public Cat062Item040 getItem040() {
        return item040;
    }

    public Cat062Item080 getItem080() {
        return item080;
    }

    public Cat062Item290 getItem290() {
        return item290;
    }

    public Cat062Item200 getItem200() {
        return item200;
    }

    public Cat062Item295 getItem295() {
        return item295;
    }

    public Cat062Item136 getItem136() {
        return item136;
    }

    public Cat062Item130 getItem130() {
        return item130;
    }

    public Cat062Item135 getItem135() {
        return item135;
    }

    public Cat062Item220 getItem220() {
        return item220;
    }

    public Cat062Item390 getItem390() {
        return item390;
    }

    public Cat062Item270 getItem270() {
        return item270;
    }

    public Cat062Item300 getItem300() {
        return item300;
    }

    public Cat062Item110 getItem110() {
        return item110;
    }

    public Cat062Item120 getItem120() {
        return item120;
    }

    public Cat062Item510 getItem510() {
        return item510;
    }

    public Cat062Item500 getItem500() {
        return item500;
    }

    public Cat062Item340 getItem340() {
        return item340;
    }

    public ReservedAsterixField getReservedExpansionField() {
        return reservedExpansionField;
    }

    public ReservedAsterixField getSpecialPurposeField() {
        return specialPurposeField;
    }

    private static class Fspec {
        //first octet
        public final static int I062_185 = 1;
        public final static int I062_100 = 2;
        public final static int I062_105 = 3;
        public final static int I062_070 = 4;
        public final static int I062_015 = 5;
        public final static int I062_010 = 7;

        //second octet
        public final static int I062_290 = 9;
        public final static int I062_080 = 10;
        public final static int I062_040 = 11;
        public final static int I062_380 = 12;
        public final static int I062_245 = 13;
        public final static int I062_060 = 14;
        public final static int I062_210 = 15;

        //third octet
        public final static int I062_390 = 17;
        public final static int I062_220 = 18;
        public final static int I062_135 = 19;
        public final static int I062_130 = 20;
        public final static int I062_136 = 21;
        public final static int I062_295 = 22;
        public final static int I062_200 = 23;

        //forth extent
        public final static int I062_340 = 25;
        public final static int I062_500 = 26;
        public final static int I062_510 = 27;
        public final static int I062_120 = 28;
        public final static int I062_110 = 29;
        public final static int I062_300 = 30;
        public final static int I062_270 = 31;

        //fifth octet
        public final static int I062_SP = 33;
        public final static int I062_RE = 34;
    }
}
