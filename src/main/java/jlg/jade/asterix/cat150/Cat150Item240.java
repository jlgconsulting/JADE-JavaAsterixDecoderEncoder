/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.RepeatableAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat150 Item240 - Newly Correlated flight plans
 * Array of correlated plan/track combinations
 */
public class Cat150Item240 extends RepeatableAsterixData {
    private List<Cat150Correlation> correlations;

    public Cat150Item240() {
        this.correlations = new ArrayList<>();
    }

    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        for (int i = 0; i < this.getRepetitionFactor(); i++) {
            int planNb = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + (i * 4));
            int trackNb = UnsignedNumericDecoder.decodeFromTwoBytes(input, offset + ((i * 4) + 2));
            Cat150Correlation correlation = new Cat150Correlation(planNb, trackNb);
            this.correlations.add(correlation);

            appendItemDebugMsg("Correlation " + i, correlation.toString());
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item240 - Newly Correlated FLight Plans";
    }

    public List<Cat150Correlation> getCorrelations() {
        return correlations;
    }
}
