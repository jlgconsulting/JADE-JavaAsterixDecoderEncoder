/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004.item100;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat004 Item100 Subfield2 - Crossing Area Name
 * Name of Crossing Area Involved in a RIMCA. Each octet is an ASCII character defining the
 * name of the crossing area involved in a
 * runway/taxiway crossing alert (message type 013)
 */
public class Cat004Item100Subfield2 extends FixedLengthAsterixData {
    private String crossingAreaName;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.crossingAreaName = new String(input, offset, this.sizeInBytes).replace(" ", "");
        appendItemDebugMsg("Crossing Area Name", this.crossingAreaName);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item100Subfield2 - Crossing Area Name";
    }

    /**
     * @return Name of crossing area involved in RIMCA. If the name contains white spaces at the
     * end, they shall be trimmed
     */
    public String getCrossingAreaName() {
        return crossingAreaName;
    }
}
