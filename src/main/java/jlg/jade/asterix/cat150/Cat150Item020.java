/**
 * Created by Dan Geabunea on 6/30/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat004 item150 - Source ID
 * Identification of the sending centre. The Source ID centre identifier will define the flight
 * plan source centre. The workstation identifier can be ignored
 */
public class Cat150Item020 extends FixedLengthAsterixData {
    private int centreId;
    private int workstationId;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.centreId = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        this.workstationId = UnsignedNumericDecoder.decodeFromOneByte(input, offset + 1);
        appendItemDebugMsg("Centre Identifier", this.centreId);
        appendItemDebugMsg("Workstation Identifier", this.workstationId);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item020 - Source ID";
    }

    public int getCentreId() {
        return centreId;
    }

    public int getWorkstationId() {
        return workstationId;
    }
}
