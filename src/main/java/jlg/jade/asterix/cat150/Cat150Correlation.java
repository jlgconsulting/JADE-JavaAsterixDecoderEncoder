/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

public class Cat150Correlation {
    private int planNumber;
    private int trackNumber;

    protected Cat150Correlation() {

    }

    public Cat150Correlation(int planNumber, int trackNumber) {
        this.planNumber = planNumber;
        this.trackNumber = trackNumber;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public int getPlanNumber() {
        return planNumber;
    }

    @Override
    public String toString() {
        return "{ PlanNb: " + this.planNumber + "; TrackNb: " + this.trackNumber + " }";
    }
}
