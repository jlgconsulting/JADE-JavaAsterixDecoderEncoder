/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004.item100;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Base class containg the implementation for RIMCA designator data
 * (subfields 3,4,5,6,7 of cat004 item 100)
 */
public abstract class Cat004Item100RimcaDesignatorData extends FixedLengthAsterixData {
    private String designator;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.SEVEN_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.designator = new String(input, offset, this.sizeInBytes).replace(" ", "");
        appendItemDebugMsg("Designator", this.designator);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item100RimcaDesignatorData";
    }

    /**
     * @return RIMCA designator as string. If last characters are white spaces,
     * then they shall be trimmed
     */
    public String getDesignator() {
        return designator;
    }
}
