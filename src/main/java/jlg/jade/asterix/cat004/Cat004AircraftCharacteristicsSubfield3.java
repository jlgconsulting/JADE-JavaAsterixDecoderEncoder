package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat 004 - Item 170/171 - Subfield 3 - Predicted Conflict Position WSG 84
 */
public class Cat004AircraftCharacteristicsSubfield3 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TEN_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Subfield3 - Predicted Conflict Position WSG-84";
    }
}
