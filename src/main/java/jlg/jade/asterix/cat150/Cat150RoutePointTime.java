/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

public class Cat150RoutePointTime {
    private String hoursString;
    private String minutesString;
    private int hours;
    private int minutes;

    public Cat150RoutePointTime(String hoursString, String minutesString) {
        this.hoursString = hoursString;
        this.minutesString = minutesString;
        try {
            this.hours = Integer.parseInt(hoursString);
            this.minutes = Integer.parseInt(minutesString);
        } catch (NumberFormatException e) {
            this.hours = -1;
            this.minutes = -1;
        }

    }

    public String getHoursString() {
        return hoursString;
    }

    public String getMinutesString() {
        return minutesString;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isValid() {
        if (this.hoursString.length() != 2 || this.minutesString.length() != 2) {
            return false;
        }
        if (this.hours > 24 || this.hours < 0) {
            return false;
        }
        if (this.minutes > 59 || this.minutes < 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{ Hours: " + this.hoursString + "; Minutes: " + this.minutesString + " }";
    }
}
