/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat065;

import jlg.jade.asterix.*;

/**
 * Asterix Category 065
 */
public class Cat065Record extends FspecAsterixData {
    private ReservedFieldFactory reservedFieldFactory;
    private Cat065Item010 item010;
    private Cat065Item000 item000;
    private Cat065Item015 item015;
    private Cat065Item030 item030;
    private Cat065Item020 item020;
    private Cat065Item040 item040;
    private Cat065Item050 item050;
    private ReservedAsterixField reservedExpansionField;
    private ReservedAsterixField specialPurposeField;

    /**
     * Default constructor, which assumes that the RE and SP fields are not present in the data sample.
     * Use this implementation only if these fields are missing. Otherwise, provide custom impl
     * for decoding and encoding of RE and SP
     */
    public Cat065Record() {
        this.reservedFieldFactory = new DefaultReservedFieldFactory();
    }

    /**
     * Custom constructor, which has custom impleemntations for RE and SP fields, according to the specific
     * use cases. Use this constructor when you need to provide custom impl to RE and SP fields.
     */
    public Cat065Record(ReservedFieldFactory reservedFieldFactory) {
        this.reservedFieldFactory = reservedFieldFactory;
    }


    @Override
    protected int setMaxFspecSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected int decodeFromByteArray(byte[] input, int offset, int length) {
        if (fspecDataAtIndex(FSPEC.I065_010)) {
            this.item010 = new Cat065Item010();
            offset = this.item010.decode(input, offset, length);
            appendDebugMsg(this.item010.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_000)) {
            this.item000 = new Cat065Item000();
            offset = this.item000.decode(input, offset, length);
            appendDebugMsg(this.item000.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_015)) {
            this.item015 = new Cat065Item015();
            offset = this.item015.decode(input, offset, length);
            appendDebugMsg(this.item015.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_030)) {
            this.item030 = new Cat065Item030();
            offset = this.item030.decode(input, offset, length);
            appendDebugMsg(this.item030.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_020)) {
            this.item020 = new Cat065Item020();
            offset = this.item020.decode(input, offset, length);
            appendDebugMsg(this.item020.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_040)) {
            this.item040 = new Cat065Item040();
            offset = this.item040.decode(input, offset, length);
            appendDebugMsg(this.item040.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_050)) {
            this.item050 = new Cat065Item050();
            offset = this.item050.decode(input, offset, length);
            appendDebugMsg(this.item050.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_RE)) {
            this.reservedExpansionField = this.reservedFieldFactory.createReField();
            offset = this.reservedExpansionField.decode(input, offset, length);
            appendDebugMsg(this.reservedExpansionField.getDebugString());
        }

        if (fspecDataAtIndex(FSPEC.I065_SP)) {
            this.specialPurposeField = this.reservedFieldFactory.createSpField();
            offset = this.specialPurposeField.decode(input, offset, length);
            appendDebugMsg(this.specialPurposeField.getDebugString());
        }

        appendDebugMsg("*** End of Category 065 Record ***");
        appendNewLine();

        return offset;
    }

    @Override
    protected String setDisplayName() {
        return "*** Category 065 Record ***";
    }

    public ReservedFieldFactory getReservedFieldFactory() {
        return reservedFieldFactory;
    }

    public Cat065Item010 getItem010() {
        return item010;
    }

    public Cat065Item000 getItem000() {
        return item000;
    }

    public Cat065Item015 getItem015() {
        return item015;
    }

    public Cat065Item030 getItem030() {
        return item030;
    }

    public Cat065Item020 getItem020() {
        return item020;
    }

    public Cat065Item040 getItem040() {
        return item040;
    }

    public Cat065Item050 getItem050() {
        return item050;
    }

    public ReservedAsterixField getReservedExpansionField() {
        return reservedExpansionField;
    }

    public ReservedAsterixField getSpecialPurposeField() {
        return specialPurposeField;
    }

    private static class FSPEC {
        //first octet
        public final static int I065_050 = 1;
        public final static int I065_040 = 2;
        public final static int I065_020 = 3;
        public final static int I065_030 = 4;
        public final static int I065_015 = 5;
        public final static int I065_000 = 6;
        public final static int I065_010 = 7;

        //second octet
        public final static int I065_RE = 10;
        public final static int I065_SP = 9;
    }
}
