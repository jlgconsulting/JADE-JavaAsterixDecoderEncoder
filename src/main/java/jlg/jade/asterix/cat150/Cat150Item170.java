/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.RepeatableAsterixData;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat150 Item170 - Route Points, FLight Level
 * Planned flight level over route point
 */
public class Cat150Item170 extends RepeatableAsterixData {

    private List<Cat150RoutePointFlightLevel> routePoints;

    public Cat150Item170() {
        this.routePoints = new ArrayList<>();
    }

    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        for (int i = 0; i < getRepetitionFactor(); i++) {
            String flightLevelString = new String(input, offset + (i * 3), 3);
            //try parse FL to integer value
            int flightLevel;
            try {
                flightLevel = Integer.parseInt(flightLevelString);
            } catch (NumberFormatException e) {
                flightLevel = -1;
            }
            Cat150RoutePointFlightLevel routePointFlightLevel = new Cat150RoutePointFlightLevel(
                    flightLevel);
            this.routePoints.add(routePointFlightLevel);

            appendItemDebugMsg("Route point " + i, routePointFlightLevel.toString());
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item170 - Route Points, FL";
    }

    @Override
    protected boolean validate() {
        for (Cat150RoutePointFlightLevel rp : this.getRoutePoints()) {
            if (rp.getFlightLevel() == -1) {
                appendWarningMessage("Some route points are not valid. " + rp.toString());
                return false;
            }
        }
        return true;
    }

    public List<Cat150RoutePointFlightLevel> getRoutePoints() {
        return routePoints;
    }
}
