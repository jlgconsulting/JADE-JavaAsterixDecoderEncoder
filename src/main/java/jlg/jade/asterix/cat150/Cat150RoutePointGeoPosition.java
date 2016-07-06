/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.common.Constants;

public class Cat150RoutePointGeoPosition {
    private int latitude;
    private int longitude;

    public Cat150RoutePointGeoPosition(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    /**
     * @return Latitude expressed as WSG 84 double
     */
    public double getLatitudeWsg84() {
        return latitude * Constants.LAT_LONG_WGS_PRECISION_CAT034_CAT048;
    }

    /**
     * @return Longitude expressed as WSG 84 double
     */
    public double getLongitudeWsg84() {
        return longitude * Constants.LAT_LONG_WGS_PRECISION_CAT034_CAT048;
    }

    @Override
    public String toString() {
        return "{ Lat: " + this.latitude + "; Lon: " + this.longitude + "; Lat WSG84: " +
                getLatitudeWsg84() + "; Lon WSG84: " + getLongitudeWsg84() + " }";
    }
}
