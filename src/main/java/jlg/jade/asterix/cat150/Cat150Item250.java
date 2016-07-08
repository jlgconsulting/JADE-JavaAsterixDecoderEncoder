/**
 * Created by Dan Geabunea on 7/8/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.RepeatableAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat150 Item250 - Newly de-correlated plans
 * Array of de-correlated plans
 */
public class Cat150Item250 extends RepeatableAsterixData {
    private List<Integer> decorrelatedPlans;

    public Cat150Item250() {
        this.decorrelatedPlans = new ArrayList<>();
    }

    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        for (int i = 0; i < this.getRepetitionFactor(); i++) {
            int planNumber = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + (i * 2));
            this.decorrelatedPlans.add(planNumber);
            appendItemDebugMsg("Flight plan decorrelated", planNumber);
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item250 - Newly de-correlated plans";
    }

    /**
     * @return Array of plan numbers that have been de-correlated
     */
    public List<Integer> getDecorrelatedPlans() {
        return decorrelatedPlans;
    }
}
