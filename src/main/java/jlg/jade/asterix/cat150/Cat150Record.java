/**
 * Created by Dan Geabunea on 7/8/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat150 - FLight Plan Data
 */
public class Cat150Record extends FspecAsterixData {
    private Cat150Item010 item010;
    private Cat150Item020 item020;
    private Cat150Item030 item030;
    private Cat150Item040 item040;
    private Cat150Item050 item050;
    private Cat150Item060 item060;
    private Cat150Item070 item070;
    private Cat150Item080 item080;
    private Cat150Item090 item090;
    private Cat150Item100 item100;
    private Cat150Item110 item110;
    private Cat150Item120 item120;
    private Cat150Item130 item130;
    private Cat150Item140 item140;
    private Cat150Item150 item150;
    private Cat150Item160 item160;
    private Cat150Item170 item170;
    private Cat150Item180 item180;
    private Cat150Item190 item190;
    private Cat150Item200 item200;
    private Cat150Item210 item210;
    private Cat150Item220 item220;
    private Cat150Item230 item230;
    private Cat150Item240 item240;
    private Cat150Item250 item250;
    private Cat150Item251 item251;
    private Cat150Item171 item171;
    private Cat150Item151 item151;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(Fspec.I150_010)) {
            this.item010 = new Cat150Item010();
            offset = this.item010.decode(input, offset, length);
            appendDebugMsg(this.item010.getDebugString());
        }


        return 0;
    }

    @Override
    protected String setDisplayName() {
        return "*** Category 150 Record ***";
    }


    public Cat150Item010 getItem010() {
        return item010;
    }

    public Cat150Item020 getItem020() {
        return item020;
    }

    public Cat150Item030 getItem030() {
        return item030;
    }

    public Cat150Item040 getItem040() {
        return item040;
    }

    public Cat150Item050 getItem050() {
        return item050;
    }

    public Cat150Item060 getItem060() {
        return item060;
    }

    public Cat150Item070 getItem070() {
        return item070;
    }

    public Cat150Item080 getItem080() {
        return item080;
    }

    public Cat150Item090 getItem090() {
        return item090;
    }

    public Cat150Item100 getItem100() {
        return item100;
    }

    public Cat150Item110 getItem110() {
        return item110;
    }

    public Cat150Item120 getItem120() {
        return item120;
    }

    public Cat150Item130 getItem130() {
        return item130;
    }

    public Cat150Item140 getItem140() {
        return item140;
    }

    public Cat150Item150 getItem150() {
        return item150;
    }

    public Cat150Item160 getItem160() {
        return item160;
    }

    public Cat150Item170 getItem170() {
        return item170;
    }

    public Cat150Item180 getItem180() {
        return item180;
    }

    public Cat150Item190 getItem190() {
        return item190;
    }

    public Cat150Item200 getItem200() {
        return item200;
    }

    public Cat150Item210 getItem210() {
        return item210;
    }

    public Cat150Item220 getItem220() {
        return item220;
    }

    public Cat150Item230 getItem230() {
        return item230;
    }

    public Cat150Item240 getItem240() {
        return item240;
    }

    public Cat150Item250 getItem250() {
        return item250;
    }

    public Cat150Item251 getItem251() {
        return item251;
    }

    public Cat150Item171 getItem171() {
        return item171;
    }

    public Cat150Item151 getItem151() {
        return item151;
    }

    private static class Fspec {
        //first octet
        final static int I150_070 = 1;
        final static int I150_060 = 2;
        final static int I150_050 = 3;
        final static int I150_040 = 4;
        final static int I150_030 = 5;
        final static int I150_020 = 6;
        final static int I150_010 = 7;

        //second octet
        final static int I150_140 = 9;
        final static int I150_130 = 10;
        final static int I150_120 = 11;
        final static int I150_110 = 12;
        final static int I150_100 = 13;
        final static int I150_90 = 14;
        final static int I150_080 = 15;

        //third octet
        final static int I150_210 = 17;
        final static int I150_200 = 18;
        final static int I150_190 = 19;
        final static int I150_180 = 20;
        final static int I150_170 = 21;
        final static int I150_160 = 22;
        final static int I150_150 = 23;

        //fourth octet
        final static int I150_151 = 25;
        final static int I150_171 = 26;
        final static int I150_251 = 27;
        final static int I150_250 = 28;
        final static int I150_240 = 29;
        final static int I150_230 = 30;
        final static int I150_220 = 31;
    }
}
