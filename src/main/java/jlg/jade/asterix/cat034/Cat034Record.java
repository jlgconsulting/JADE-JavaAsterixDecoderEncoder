/**
 * Created by alexandru on 7/4/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.*;
import jlg.jade.asterix.cat034.item050.Cat034Item050;
import jlg.jade.asterix.cat034.item060.Cat034Item060;

/**
 * Asterix Category 034 - Radar Service Messages
 */
public class Cat034Record extends FspecAsterixData {
    private final ReservedFieldFactory reservedFieldFactory;
    private Cat034Item010 item010;
    private Cat034Item000 item000;
    private Cat034Item030 item030;
    private Cat034Item020 item020;
    private Cat034Item041 item041;
    private Cat034Item050 item050;
    private Cat034Item060 item060;
    private Cat034Item070 item070;
    private Cat034Item100 item100;
    private Cat034Item110 item110;
    private Cat034Item120 item120;
    private Cat034Item090 item090;
    private ReservedAsterixField reservedExpansionField;
    private ReservedAsterixField reservedSpecialPurposeField;


    public Cat034Record() {
        this.reservedFieldFactory = new DefaultReservedFieldFactory();
    }

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if(fspecDataAtIndex(FSPEC.I034_010)){
            this.item010 = new Cat034Item010();
            offset = item010.decode(input, offset, length);
            appendDebugMsg(this.item010.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_000)){
            this.item000 = new Cat034Item000();
            offset = item000.decode(input, offset, length);
            appendDebugMsg(this.item000.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_030)){
            this.item030 = new Cat034Item030();
            offset = item030.decode(input, offset, length);
            appendDebugMsg(this.item030.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_020)){
            this.item020 = new Cat034Item020();
            offset = item020.decode(input, offset, length);
            appendDebugMsg(this.item020.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_041)){
            this.item041 = new Cat034Item041();
            offset = item041.decode(input, offset, length);
            appendDebugMsg(this.item041.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_050)){
            this.item050 = new Cat034Item050();
            offset = item050.decode(input, offset, length);
            appendDebugMsg(this.item050.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_060)){
            this.item060 = new Cat034Item060();
            offset = item060.decode(input, offset, length);
            appendDebugMsg(this.item060.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_070)){
            this.item070 = new Cat034Item070();
            offset = item070.decode(input, offset, length);
            appendDebugMsg(this.item070.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_100)){
            this.item100 = new Cat034Item100();
            offset = item100.decode(input, offset, length);
            appendDebugMsg(this.item100.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_110)){
            this.item110 = new Cat034Item110();
            offset = item110.decode(input, offset, length);
            appendDebugMsg(this.item110.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_120)){
            this.item120 = new Cat034Item120();
            offset = item120.decode(input, offset, length);
            appendDebugMsg(this.item120.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_090)){
            this.item090 = new Cat034Item090();
            offset = item090.decode(input, offset, length);
            appendDebugMsg(this.item090.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_RE)){
            this.reservedExpansionField = this.reservedFieldFactory.createReField();
            offset = reservedExpansionField.decode(input, offset, length);
            appendDebugMsg(this.reservedExpansionField.getDebugString());
        }

        if(fspecDataAtIndex(FSPEC.I034_SP)){
            this.reservedSpecialPurposeField = this.reservedFieldFactory.createSpField();
            offset = reservedSpecialPurposeField.decode(input, offset, length);
            appendDebugMsg(this.reservedSpecialPurposeField.getDebugString());
        }

        appendDebugMsg("*** End of Category 034 Record ***");
        appendNewLine();
        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "*** Category 034 Record ***";
    }

    public Cat034Item010 getItem010() {
        return item010;
    }

    public Cat034Item000 getItem000() {
        return item000;
    }

    public Cat034Item030 getItem030() {
        return item030;
    }

    public Cat034Item020 getItem020() {
        return item020;
    }

    public Cat034Item041 getItem041() {
        return item041;
    }

    public Cat034Item050 getItem050() {
        return item050;
    }

    public Cat034Item060 getItem060() {
        return item060;
    }

    public Cat034Item070 getItem070() {
        return item070;
    }

    public Cat034Item100 getItem100() {
        return item100;
    }

    public Cat034Item110 getItem110() {
        return item110;
    }

    public Cat034Item120 getItem120() {
        return item120;
    }

    public Cat034Item090 getItem090() {
        return item090;
    }

    public ReservedAsterixField getReservedExpansionField() {
        return reservedExpansionField;
    }

    public ReservedAsterixField getReservedSpecialPurposeField() {
        return reservedSpecialPurposeField;
    }

    private static class FSPEC{
        // first octet
        public final static int I034_010 = 7;
        public final static int I034_000 = 6;
        public final static int I034_030 = 5;
        public final static int I034_020 = 4;
        public final static int I034_041 = 3;
        public final static int I034_050 = 2;
        public final static int I034_060 = 1;

        // second octet
        public final static int I034_070 = 15;
        public final static int I034_100 = 14;
        public final static int I034_110 = 13;
        public final static int I034_120 = 12;
        public final static int I034_090 = 11;
        public final static int I034_RE = 10;
        public final static int I034_SP = 9;
    }
}
