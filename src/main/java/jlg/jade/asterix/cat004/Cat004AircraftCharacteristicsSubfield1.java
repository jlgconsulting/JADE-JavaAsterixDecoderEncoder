package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat 004 - Item 170/171 - Subfield 1 - Aircraft Identifier
 *
 * @implSpec The aircraft identifier is always left adjusted. If needed, the
 * remaining characters are filled with space character
 */
public class Cat004AircraftCharacteristicsSubfield1 extends FixedLengthAsterixData {
    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    @DecodingNotImplemented(reason = "Item not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Subfield1 - Aircraft Identifier";
    }
}
