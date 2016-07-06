/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat150 Item230 - Number of plans
 */
public class Cat150Item230 extends FixedLengthAsterixData {
    private int nbOfPlans;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.nbOfPlans = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset);
        this.appendItemDebugMsg("Nb of plans", this.nbOfPlans);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item230 - Number of plans";
    }

    public int getNbOfPlans() {
        return nbOfPlans;
    }
}
