/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.asterix.cat004.item170_171;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat004 - Item170/171 - Subfield 10 - Cleared Flight Level for aircraft
 */
public class Cat004AircraftCharacteristicsSubfield10 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Subfield10 - Cleared Flight Level";
    }
}
