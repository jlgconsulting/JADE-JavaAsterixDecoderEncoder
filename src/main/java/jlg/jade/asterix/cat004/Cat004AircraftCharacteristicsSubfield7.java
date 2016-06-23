/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.asterix.cat004;

import jlg.jade.asterix.DecodingNotImplemented;
import jlg.jade.asterix.VariableLengthAsterixData;

/**
 * Cat 004 - Item 170/171 - Aircraft Characteristics for Aircraft (1,2)
 */
public class Cat004AircraftCharacteristicsSubfield7 extends VariableLengthAsterixData {
    @Override
    @DecodingNotImplemented(reason = "This item is not needed yet")
    protected void decodeFromByteArray(byte[] input, int offset) {
        appendNotImplementedMsg();
    }

    @Override
    protected String setDisplayName() {
        return "Subfield7 - Aircraft Characteristics";
    }
}
