/**
 * Created by Dan Geabunea on 7/5/2016.
 */

package jlg.jade.asterix.cat150;

public class Cat150Item140RoutePoint {
    private int type;
    private String description;

    public Cat150Item140RoutePoint(int type, String description) {
        this.type = type;
        this.description = description;
    }

    protected Cat150Item140RoutePoint() {
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Type: " + this.getType() + "; Description: " + this.getDescription();
    }
}
