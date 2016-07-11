/**
 * Created by Dan Geabunea on 7/8/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat150 - Full FLight Plan Data
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
        if (fspecDataAtIndex(Fspec.I150_020)) {
            this.item020 = new Cat150Item020();
            offset = this.item020.decode(input, offset, length);
            appendDebugMsg(this.item020.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_030)) {
            this.item030 = new Cat150Item030();
            offset = this.item030.decode(input, offset, length);
            appendDebugMsg(this.item030.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_040)) {
            this.item040 = new Cat150Item040();
            offset = this.item040.decode(input, offset, length);
            appendDebugMsg(this.item040.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_050)) {
            this.item050 = new Cat150Item050();
            offset = this.item050.decode(input, offset, length);
            appendDebugMsg(this.item050.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_060)) {
            this.item060 = new Cat150Item060();
            offset = this.item060.decode(input, offset, length);
            appendDebugMsg(this.item060.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_070)) {
            this.item070 = new Cat150Item070();
            offset = this.item070.decode(input, offset, length);
            appendDebugMsg(this.item070.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_080)) {
            this.item080 = new Cat150Item080();
            offset = this.item080.decode(input, offset, length);
            appendDebugMsg(this.item080.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_090)) {
            this.item090 = new Cat150Item090();
            offset = this.item090.decode(input, offset, length);
            appendDebugMsg(this.item090.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_100)) {
            this.item100 = new Cat150Item100();
            offset = this.item100.decode(input, offset, length);
            appendDebugMsg(this.item100.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_110)) {
            this.item110 = new Cat150Item110();
            offset = this.item110.decode(input, offset, length);
            appendDebugMsg(this.item110.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_120)) {
            this.item120 = new Cat150Item120();
            offset = this.item120.decode(input, offset, length);
            appendDebugMsg(this.item120.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_130)) {
            this.item130 = new Cat150Item130();
            offset = this.item130.decode(input, offset, length);
            appendDebugMsg(this.item130.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_140)) {
            this.item140 = new Cat150Item140();
            offset = this.item140.decode(input, offset, length);
            appendDebugMsg(this.item140.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_150)) {
            this.item150 = new Cat150Item150();
            offset = this.item150.decode(input, offset, length);
            appendDebugMsg(this.item150.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_160)) {
            this.item160 = new Cat150Item160();
            offset = this.item160.decode(input, offset, length);
            appendDebugMsg(this.item160.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_170)) {
            this.item170 = new Cat150Item170();
            offset = this.item170.decode(input, offset, length);
            appendDebugMsg(this.item170.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_180)) {
            this.item180 = new Cat150Item180();
            offset = this.item180.decode(input, offset, length);
            appendDebugMsg(this.item180.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_190)) {
            this.item190 = new Cat150Item190();
            offset = this.item190.decode(input, offset, length);
            appendDebugMsg(this.item190.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_200)) {
            this.item200 = new Cat150Item200();
            offset = this.item200.decode(input, offset, length);
            appendDebugMsg(this.item200.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_210)) {
            this.item210 = new Cat150Item210();
            offset = this.item210.decode(input, offset, length);
            appendDebugMsg(this.item210.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_171)) {
            this.item171 = new Cat150Item171();
            offset = this.item171.decode(input, offset, length);
            appendDebugMsg(this.item171.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_151)) {
            this.item151 = new Cat150Item151();
            offset = this.item151.decode(input, offset, length);
            appendDebugMsg(this.item151.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_220)) {
            this.item220 = new Cat150Item220();
            offset = this.item220.decode(input, offset, length);
            appendDebugMsg(this.item220.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_230)) {
            this.item230 = new Cat150Item230();
            offset = this.item230.decode(input, offset, length);
            appendDebugMsg(this.item230.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_240)) {
            this.item240 = new Cat150Item240();
            offset = this.item240.decode(input, offset, length);
            appendDebugMsg(this.item240.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_250)) {
            this.item250 = new Cat150Item250();
            offset = this.item250.decode(input, offset, length);
            appendDebugMsg(this.item250.getDebugString());
        }
        if (fspecDataAtIndex(Fspec.I150_251)) {
            this.item251 = new Cat150Item251();
            offset = this.item251.decode(input, offset, length);
            appendDebugMsg(this.item251.getDebugString());
        }

        return offset;
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
        final static int I150_090 = 14;
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
