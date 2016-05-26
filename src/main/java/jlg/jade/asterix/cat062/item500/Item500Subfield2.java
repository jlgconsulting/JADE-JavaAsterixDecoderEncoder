/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item500;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

/**
 * Item 500 Subfield 2 - XY covariance component
 * XY covariance component = sign {Cov(X,Y)} * sqrt {abs [Cov (X,Y)]}
 */
public class Item500Subfield2 extends FixedLengthAsterixData {
    private int covariance;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.covariance = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        appendItemDebugMsg("Covariance for XY", this.covariance);
    }

    /**
     * @return The XY covariance component, expressed in half meters.
     */
    public int getCovariance() {
        return covariance;
    }

    @Override
    protected String setDisplayName() {
        return "Item500Subfield2 - XY Covariance";
    }
}
