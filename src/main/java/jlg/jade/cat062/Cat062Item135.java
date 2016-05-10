/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;

import java.util.BitSet;

/**
 * Cat 062 Item 135 - Barometric altitude - Opt
 * Calculated Barometric Altitude of the track, in two’s complement
 * form. This field also contains QNH info
 * Validation: -15FL < alt < 1500FL
 * Unit of measure: 25ft (1/4FL)
 */
public class Cat062Item135 extends FixedLengthAsterixData {
    private boolean qnhCorrectionApplied;
    private int barometricAltitude;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        //decode qnh
        BitSet firstOctetBits = BitSet.valueOf(new byte[]{input[offset]});
        final int QNH_BIT_INDEX = 7;
        this.qnhCorrectionApplied = firstOctetBits.get(QNH_BIT_INDEX);
        appendItemDebugMsg("QNH correction applied", this.qnhCorrectionApplied);

        //decode barometric alt
        byte firstOctetValueWithoutQnh = input[offset];
        if (qnhCorrectionApplied) {
            firstOctetValueWithoutQnh = (byte) (input[offset] - 128);
        }
        this.barometricAltitude = firstOctetValueWithoutQnh * 256 + Byte.toUnsignedInt(input[offset + 1]);
        appendItemDebugMsg("Barometric altitude", barometricAltitude);
        appendItemDebugMsg("Barometric altitude (ft)", getBarometricAltitudeFeet());
    }

    @Override
    protected boolean validate() {
        int minAllowedValue = -60;  // 4 * -15FL
        int maxAllowdValue = 6000;  // 4 * 1500FL

        if (barometricAltitude >= minAllowedValue && barometricAltitude <= maxAllowdValue) {
            return true;
        }
        appendDebugMsg("Barometric altitude is invalid. Must be between -60 and 6000.");
        appendNewLine();
        return false;
    }

    /**
     * QNH Indicator
     *
     * @return True, if QNG correction has been applied to this altitude, false otherwise
     */
    public boolean isQnhCorrectionApplied() {
        return qnhCorrectionApplied;
    }

    /**
     * @return The barometric altitude, expressed in 1/4FL (25 ft)
     */
    public int getBarometricAltitude() {
        return barometricAltitude;
    }

    /**
     * @return The barometric altitude, expressed in feet
     */
    public int getBarometricAltitudeFeet() {
        /**
         * @implNote 1 unit = 25 feet => we multiply by 25 to get feet
         */
        return barometricAltitude * 25;
    }

}
