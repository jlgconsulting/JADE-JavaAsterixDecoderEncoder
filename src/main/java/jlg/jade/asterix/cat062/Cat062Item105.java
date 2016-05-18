/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import static jlg.jade.common.Constants.LAT_LONG_WGS_PRECISION_CAT062;

/**
 * Cat 062 Item 105 - Calculated Position in WSG84 coordinates - Optional
 * Unit of measure for lat and lon is 180/pow(2,25). degrees
 */
public class Cat062Item105 extends FixedLengthAsterixData {
    private int latitudeWsg84;
    private int longitudeWsg84;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        //MSB must be interpreted as signed, so we do not covert it to unsigned value

        this.latitudeWsg84 =
                        input[offset] * 256 * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 1]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 2]) * 256 +
                        Byte.toUnsignedInt(input[offset + 3]);

        this.longitudeWsg84 =
                        input[offset+4] * 256 * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 5]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 6]) * 256 +
                        Byte.toUnsignedInt(input[offset + 7]);

        appendItemDebugMsg("Latitude in Asterix", latitudeWsg84);
        appendItemDebugMsg("Latitude in WSG84", getLatitudeDecimalWsg84());
        appendItemDebugMsg("Longitude in Asterix", longitudeWsg84);
        appendItemDebugMsg("Longitude in WSG84", getLongitudeDecimalWsg84());
    }

    @Override
    protected boolean validate() {
        if(getLatitudeDecimalWsg84() < -90 || getLatitudeDecimalWsg84() > 90){
            appendDebugMsg("Item is not valid. Latitude is not within -90,90 range. Latitude: " + getLatitudeDecimalWsg84());
            return false;
        }
        if(getLongitudeDecimalWsg84() < -180 || getLongitudeDecimalWsg84() > 180){
            appendDebugMsg("Item is not valid. Longitude is not within -180,180 range. Longitude: " + getLongitudeWsg84());
            return false;
        }

        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.EIGHT_BYTES.getValue();
    }

    public int getLatitudeWsg84() {
        return latitudeWsg84;
    }

    public int getLongitudeWsg84() {
        return longitudeWsg84;
    }

    /**
     * Calculates the decimal value of the WSG84 latitude from the Asterix unit of measure
     */
    public double getLatitudeDecimalWsg84(){
        return this.latitudeWsg84 * LAT_LONG_WGS_PRECISION_CAT062;
    }

    /**
     * Calculates the decimal value of the WSG84 longitude from the Asterix unit of measure
     */
    public double getLongitudeDecimalWsg84(){
        return this.longitudeWsg84 * LAT_LONG_WGS_PRECISION_CAT062;
    }
}
