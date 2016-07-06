/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.RepeatableAsterixData;
import jlg.jade.common.TwoComplementDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat150 Item151 - Route Points, Geographical Position
 * Route point positions in WSG 84 (latitude, longitude)
 */
public class Cat150Item151 extends RepeatableAsterixData {
    private List<RoutePointGeoPosition> routePoints;

    public Cat150Item151() {
        this.routePoints = new ArrayList<>();
    }

    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.SIX_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        for (int i = 0; i < getRepetitionFactor(); i++) {
            int latitude = TwoComplementDecoder.decodeFromThreeBytes(input,
                    offset + ((i * 6)));
            int longitude = TwoComplementDecoder.decodeFromThreeBytes(input,
                    offset + ((i * 6) + 3));
            RoutePointGeoPosition routePointGeoPosition = new RoutePointGeoPosition(latitude,
                    longitude);
            this.routePoints.add(routePointGeoPosition);

            appendItemDebugMsg("Route Point " + i, routePointGeoPosition.toString());
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item151 - Route Points, Geographical Pos";
    }

    public List<RoutePointGeoPosition> getRoutePoints() {
        return routePoints;
    }
}
