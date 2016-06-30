/**
 * Created by Dan Geabunea on 6/29/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat150 Item010 - Identification of the receiving center
 *
 * @implSpec The Destination ID is irrelevant in CAT150 messages since the flight plan messages
 * are sent to all centres. Hence, the centre identifier is set to broadcast.
 * The workstation identifier can be ignored
 */
public class Cat150Item010 extends FixedLengthAsterixData {
    private int centreId;
    private int workstationId;

    @Override
    protected int setSizeInBytes() {
        return 2;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.centreId = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        this.workstationId = UnsignedNumericDecoder.decodeFromOneByte(input, offset + 1);
        appendItemDebugMsg("Centre ID", this.centreId);
        appendItemDebugMsg("Workstation ID", this.workstationId);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item010 - Destination ID";
    }

    public int getCentreId() {
        return centreId;
    }

    public int getWorkstationId() {
        return workstationId;
    }
}
