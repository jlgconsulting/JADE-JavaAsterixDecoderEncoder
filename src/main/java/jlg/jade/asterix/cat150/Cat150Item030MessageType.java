/**
 * Created by Dan Geabunea on 6/30/2016.
 */

package jlg.jade.asterix.cat150;

public enum Cat150Item030MessageType {
    UNKNOWN(-1),
    FLIGHT_PLAN_CREATION(1),
    FLIGHT_PLAN_MODIFICATION(2),
    FLIGHT_PLAN_REPETITION(3),
    MANUAL_FLIGHT_PLAN_DELETION(4),
    AUTOMATIC_FLIGHT_PLAN_DELETION(5),
    FLIGHT_BEYOND_EXTRACTION_AREA(6),
    STCA(251),
    CORRELATIONS(252),
    DECORRELATIONS(253),
    START_BACKGROUND_LOOP(254),
    END_BACKGROUND_LOOG(255);

    private int numericValue;

    Cat150Item030MessageType(int numericValue){
        this.numericValue = numericValue;
    }

    public int getNumericValue() {
        return numericValue;
    }
}
