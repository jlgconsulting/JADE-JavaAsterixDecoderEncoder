/**
 * Created by alexandru on 7/4/16.
 */
package jlg.jade.asterix.cat034;

public enum Cat034Item000MessageType {
    UNKNOWN(-1),
    NORTH_MARKER_MESSAGE(1),
    SECTOR_CROSSING_MESSAGE(2),
    GEOGRAPHICAL_FILTERING_MESSAGE(3),
    JAMMING_STROBE_MESSAGE(4);

    private int value;

    Cat034Item000MessageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
