/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.asterix.cat034.item050;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FspecAsterixData;

/**
 * Cat034Item050 - System Configuration and Status
 * Information concerning the configuration and status of a System.
 */
public class Cat034Item050 extends FspecAsterixData {
    private Cat034Item050Subfield1 subfield1;
    private Cat034Item050Subfield4 subfield4;
    private Cat034Item050Subfield5 subfield5;
    private Cat034Item050Subfield6 subfield6;

    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        // subfield 1
        if(fspecDataAtIndex(Fspec.SUBFIELD_1)) {
            subfield1 = new Cat034Item050Subfield1();
            offset = subfield1.decode(input, offset, length);
            appendDebugMsg(subfield1.getDebugString());
        }

        // subfield 4
        if(fspecDataAtIndex(Fspec.SUBFIELD_4)) {
            subfield4 = new Cat034Item050Subfield4();
            offset = subfield4.decode(input, offset, length);
            appendDebugMsg(subfield4.getDebugString());
        }

        //subfield 5
        if(fspecDataAtIndex(Fspec.SUBFIELD_5)) {
            subfield5 = new Cat034Item050Subfield5();
            offset = subfield5.decode(input, offset, length);
            appendDebugMsg(subfield5.getDebugString());
        }

        //subfield 6
        if(fspecDataAtIndex(Fspec.SUBFIELD_6)) {
            subfield6 = new Cat034Item050Subfield6();
            offset = subfield6.decode(input, offset, length);
            appendDebugMsg(subfield6.getDebugString());
        }

        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item050 - System Configuration and Status";
    }

    public Cat034Item050Subfield1 getSubfield1() {
        return subfield1;
    }

    public Cat034Item050Subfield4 getSubfield4() {
        return subfield4;
    }

    public Cat034Item050Subfield5 getSubfield5() {
        return subfield5;
    }

    public Cat034Item050Subfield6 getSubfield6() {
        return subfield6;
    }

    private static class Fspec {
        // first extent
        public static final int SUBFIELD_1 = 7;
        public static final int SUBFIELD_4 = 4;
        public static final int SUBFIELD_5 = 3;
        public static final int SUBFIELD_6 = 2;
    }
}
