/* 
* Created by dan-geabunea on 5/12/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat 062 Item 300 - Vehicle Fleet Identification - Opt
 */
public class Cat062Item300 extends FixedLengthAsterixData {
    private int vehicleFleetId;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.vehicleFleetId = input[offset];
        appendItemDebugMsg("VFI (check Asterix ICD for meaning of this ID)", this.vehicleFleetId);
    }

    /**
     * @return The vehicle fleet identification
     */
    public int getVehicleFleetId() {
        return vehicleFleetId;
    }

    @Override
    protected boolean validate() {
        if (vehicleFleetId >= 0 && vehicleFleetId <= 16) {
            return true;
        }
        appendDebugMsg("Invalid VFI (Should be between 0 and 16)");
        appendNewLine();
        return false;
    }
}
