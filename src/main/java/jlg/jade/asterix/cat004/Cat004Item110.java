/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.RepeatableAsterixData;

/**
 * Cat004 Item110 - FDPS Sector Control Identification
 * Identification of a list of FDPS Sector Control Positions in
 * charge of the involved targets, as provided by the FDPS
 */
public class Cat004Item110 extends RepeatableAsterixData {
    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item110 - FDPS Sector Control Identification";
    }
}
