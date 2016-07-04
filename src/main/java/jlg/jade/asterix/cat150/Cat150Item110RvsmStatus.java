/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.asterix.cat150;

public enum Cat150Item110RvsmStatus {
    UNKNOWN(-1),
    EQUIPPED(1),
    CAPABLE(2),
    EXEMPTED(3);

    private int numericValue;

    Cat150Item110RvsmStatus(int numericValue){
        this.numericValue = numericValue;
    }

    public int getNumericValue() {
        return numericValue;
    }
}
