/**
 * Created by Dan Geabunea on 7/5/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.RepeatableAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat150 Item140 - Route point descriptions
 *
 * @implNote For all route point items (140..180) present in a single message, the count values
 * are equal. Coordinate(1), description(1), etc.
 */
public class Cat150Item140 extends RepeatableAsterixData {
    private List<Cat150RoutePointDescription> routePoints;

    public Cat150Item140() {
        this.routePoints = new ArrayList<>();
    }

    @Override
    protected int setRepeatableBlockSizeInBytes() {
        return AsterixItemLength.TWELVE_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        for (int i = 0; i < this.getRepetitionFactor(); i++) {
            int type = UnsignedNumericDecoder.decodeFromOneByte(input, offset + (i * 12));
            String description = new String(input, offset + ((i * 12) + 1), 11).replace(" ", "");
            Cat150RoutePointDescription routePoint = new Cat150RoutePointDescription(type, description);
            routePoints.add(routePoint);

            appendItemDebugMsg("Route point " + i, routePoint.toString());
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item140 - Route Point Descriptions";
    }

    /**
     * @return The route point descriptions
     */
    public List<Cat150RoutePointDescription> getRoutePoints() {
        return routePoints;
    }
}
