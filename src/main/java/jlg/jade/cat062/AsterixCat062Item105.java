/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.AsterixItem;
import jlg.jade.abstraction.DecodableFixedLength;
import jlg.jade.abstraction.EncodableFixedLength;
import jlg.jade.asterix.AsterixItemLength;

import static jlg.jade.common.Constants.LAT_LONG_WGS_PRECISION_CAT062;

/**
 * Cat 062 Item 105 - Calculated Position in WSG84 coordinates - Optional
 * Unit of measure for lat and lon is 180/pow(2,25). degrees
 */
public class AsterixCat062Item105 extends AsterixItem implements DecodableFixedLength, EncodableFixedLength {
    private int latitudeWsg84;
    private int longitudeWsg84;

    public AsterixCat062Item105() {
        this.sizeInBytes = AsterixItemLength.EIGHT_BYTES.getValue();
    }

    @Override
    public void reset() {
        this.latitudeWsg84 = 0;
        this.longitudeWsg84 = 0;
    }

    @Override
    public int decode(byte[] input, int offset) {
        reset();
        checkLength(input, offset, this.sizeInBytes);

        this.latitudeWsg84 =
                        Byte.toUnsignedInt(input[offset]) * 256 * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 1]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 2]) * 256 +
                        Byte.toUnsignedInt(input[offset + 3]);

        this.longitudeWsg84 =
                Byte.toUnsignedInt(input[offset+4]) * 256 * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 5]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 6]) * 256 +
                        Byte.toUnsignedInt(input[offset + 7]);

        return offset + this.getSizeInBytes();
    }

    @Override
    public int encode(byte[] dest, int offset) {
        return 0;
    }

    @Override
    protected void validate() {
        if(getLatitudeDecimalWsg84() < -90 || getLatitudeDecimalWsg84() > 90){
            appendDebugMsg("Latitude not valid according to specifications (between -90 and 90). Latitude: " + this.getLatitudeDecimalWsg84());
        }
        if(getLongitudeDecimalWsg84() < -180 || getLongitudeDecimalWsg84() > 180){
            appendDebugMsg("Longitude not valid according to specifications (between -180 and 180). Longitude: " + this.getLongitudeWsg84());
        }
        this.isValid = false;
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
