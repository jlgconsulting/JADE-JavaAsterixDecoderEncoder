/**
 * Created by Dan Geabunea on 7/5/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.RepeatableAsterixData;
import jlg.jade.common.TwoComplementDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat150 Item150 - Route point coordinates (carteisan)
 */
public class Cat150Item150 extends RepeatableAsterixData {
    private List<Cat150RoutePointCoordinate> routePoints;

    public Cat150Item150() {
        this.routePoints = new ArrayList<>();
    }


    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        for (int i = 0; i < this.getRepetitionFactor(); i++) {
            int x = TwoComplementDecoder.decodeFromTwoBytes(input, offset + (i * 4));
            int y = TwoComplementDecoder.decodeFromTwoBytes(input, offset + (i * 4) + 2);
            Cat150RoutePointCoordinate routePointCoordinate = new Cat150RoutePointCoordinate(x, y);
            this.routePoints.add(routePointCoordinate);

            appendItemDebugMsg("Route point coordinate " + i, routePointCoordinate.toString());
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item150 - Route point coordinates";
    }

    public List<Cat150RoutePointCoordinate> getRoutePoints() {
        return routePoints;
    }
}
