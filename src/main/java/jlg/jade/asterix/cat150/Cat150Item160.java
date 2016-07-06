/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.RepeatableAsterixData;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat150 Item160 - Route Points, Time
 * Estimated times over route points
 */
public class Cat150Item160 extends RepeatableAsterixData {
    private List<Cat150RoutePointTime> routePoints;

    public Cat150Item160() {
        this.routePoints = new ArrayList<>();
    }

    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        for (int i = 0; i < this.getRepetitionFactor(); i++) {
            String hours = new String(input, offset + (i * 4), 2);
            String minutes = new String(input, (offset + (i * 4) + 2), 2);
            Cat150RoutePointTime cat150RoutePointTime = new Cat150RoutePointTime(hours, minutes);
            this.routePoints.add(cat150RoutePointTime);

            appendItemDebugMsg("Route Point " + i, cat150RoutePointTime.toString());
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item160 - Route Points, Time";
    }

    @Override
    protected boolean validate() {
        for (Cat150RoutePointTime rp : this.routePoints) {
            if (!rp.isValid()) {
                appendWarningMessage("Some route points are not valid. " + rp.toString());
                return false;
            }
        }
        return true;
    }

    public List<Cat150RoutePointTime> getRoutePoints() {
        return routePoints;
    }
}
