/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat150 Item190 - Controller ID
 * Current control position in charge of the aircraft
 *
 * @implSpec Single character controller ids are sent with a leading space character. This can be
 * interpreted as a right aligned value
 */
public class Cat150Item190 extends FixedLengthAsterixData {
    private String controllerId;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.controllerId = new String(input, offset, 2).replace(" ", "");
        this.appendItemDebugMsg("Controller ID", this.controllerId);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item190 - ControllerID";
    }

    /**
     * @return THe controller ID. ingle character controller ids are sent with a
     * leading space character that is trimmed.
     */
    public String getControllerId() {
        return controllerId;
    }
}
