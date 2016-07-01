/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat034Item110 - Data Filter
 * Data Filter, which allows suppression of individual data types.
 */
public class Cat034Item110 extends FixedLengthAsterixData{
    private int dataFilter;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.dataFilter = UnsignedNumericDecoder.decodeFromOneByte(input, offset);

        appendItemDebugMsg("Data Filter", this.dataFilter);
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item110 - Data Filter";
    }

    public int getDataFilter() {
        return dataFilter;
    }
}
