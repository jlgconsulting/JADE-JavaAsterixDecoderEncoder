/**
 * Created by Dan Geabunea on 7/5/2016.
 */

package jlg.jade.asterix.cat150;

public class Cat150RoutePointCoordinate {
    private int x;
    private int y;

    public Cat150RoutePointCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{X: " + this.x + "; Y: " + this.y + " }";
    }
}
