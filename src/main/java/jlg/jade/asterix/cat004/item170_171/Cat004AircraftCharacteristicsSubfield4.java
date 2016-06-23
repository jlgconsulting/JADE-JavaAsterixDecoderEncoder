package jlg.jade.asterix.cat004.item170_171;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat 004 - Item 170/171 - Subfield 4 - Predicted Conflict Position Cartesian
 */
public class Cat004AircraftCharacteristicsSubfield4 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.EIGHT_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Subfield4 - Predicted Conflict Position Cartesian";
    }
}
