/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

public class Cat150RoutePointFlightLevel {
    private int flightLevel;

    public Cat150RoutePointFlightLevel(int flightLevel) {
        this.flightLevel = flightLevel;
    }


    public int getFlightLevel() {
        return flightLevel;
    }

    @Override
    public String toString() {
        return "{Flight Level: " + this.flightLevel + " }";
    }
}
