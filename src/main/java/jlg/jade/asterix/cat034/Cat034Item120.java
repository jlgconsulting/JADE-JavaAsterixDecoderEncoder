/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.TwoComplementDecoder;

import static jlg.jade.common.Constants.LAT_LONG_WGS_PRECISION_CAT034;

/**
 * Cat034Item120 - 3D-Position Of Data Source
 * 3D-Position of Data Source in WGS 84 Co-ordinates.
 */
public class Cat034Item120 extends FixedLengthAsterixData{
    private int heightWgs84;
    private int latitudeWgs84;
    private int longitudeWgs84;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.EIGHT_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.heightWgs84 = TwoComplementDecoder.decodeFromTwoBytes(input, offset);
        this.latitudeWgs84 = TwoComplementDecoder.decodeFromThreeBytes(input, offset+2);
        this.longitudeWgs84 = TwoComplementDecoder.decodeFromThreeBytes(input, offset+5);

        appendItemDebugMsg("Height in WGS 84", this.heightWgs84);
        appendItemDebugMsg("Latitude in WGS 84", this.latitudeWgs84);
        appendItemDebugMsg("Longitude in WGS 84", this.longitudeWgs84);
    }

    @Override
    protected boolean validate() {
        if(getLatitudeDecimalWgs84() < -90 || getLatitudeDecimalWgs84() > 90){
            appendDebugMsg("Item is not valid. Latitude is not within -90,90 range. Latitude: " + getLatitudeDecimalWgs84());
            return false;
        }

        if(getLongitutdeDecimalWgs84() < -180 || getLongitutdeDecimalWgs84() > 180){
            appendDebugMsg("Item is not valid. Latitude is not within -180,180 range. Longitude: " + getLongitutdeDecimalWgs84());
            return false;
        }

        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item120 - 3D-Position Of Data Source";
    }

    public int getHeightWgs84() {
        return heightWgs84;
    }

    public int getLatitudeWgs84() {
        return latitudeWgs84;
    }

    public int getLongitudeWgs84() {
        return longitudeWgs84;
    }

    /**
     * Calculate the decimal value of the WSG84 latitude according the Asterix specification
     */
    public double getLatitudeDecimalWgs84() {
        return this.latitudeWgs84 * LAT_LONG_WGS_PRECISION_CAT034;
    }

    /**
     * Calculate the decimal value of WSG84 longitude according the Asterix specification
     */
    public double getLongitutdeDecimalWgs84() {
        return this.longitudeWgs84 * LAT_LONG_WGS_PRECISION_CAT034;
    }
}
