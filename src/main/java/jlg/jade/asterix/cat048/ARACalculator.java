/**
 * Created by alexandru on 8/2/16.
 */
package jlg.jade.asterix.cat048;

import java.util.ArrayList;
import java.util.List;

public class ARACalculator {
    private List<String> araList = new ArrayList<>();

    public List<String> getARAList(Cat048Item260 item260, TCASVersion version) {
        switch (version) {
            case VERSION_604:
                generateV604ARAList(item260);
                break;
            case VERSION_70:
                generateV70ARAList(item260);
                break;
        }

        return araList;
    }

    private void generateV604ARAList(Cat048Item260 item260) {

        if (item260.getARABit41() == 1) {
            araList.add("Climb");
        }

        if (item260.getARABit42() == 1) {
            araList.add("Don’t descend");
        }

        if (item260.getARABit43() == 1) {
            araList.add("Don’t descend faster than 500 fpm");
        }

        if (item260.getARABit44() == 1) {
            araList.add("Don’t descend faster than 1000 fpm");
        }

        if (item260.getARABit45() == 1) {
            araList.add("Don’t descend faster than 2000 fpm");
        }

        if (item260.getARABit46() == 1) {
            araList.add("Descend");
        }

        if (item260.getARABit47() == 1) {
            araList.add("Don’t climb");
        }

        if (item260.getARABit48() == 1) {
            araList.add("Don’t climb faster than 500 fpm");
        }

        if (item260.getARABit49() == 1) {
            araList.add("Don’t climb faster than 1000 fpm");
        }

        if (item260.getARABit50() == 1) {
            araList.add("Don’t climb faster than 2000 fpm");
        }
    }

    private void generateV70ARAList(Cat048Item260 item260) {

        if (item260.getARABit41() == 1 && item260.getMultiThreatIndicator() == 0) {

            if (item260.getARABit42() == 1) {
                araList.add("RA is corrective");
            } else {
                araList.add("RA is preventive");
            }

            if (item260.getARABit43() == 1) {
                araList.add("Downward sense RA has been generated");
            } else {
                araList.add("Upward sense RA has been generated");
            }

            if (item260.getARABit44() == 1) {
                araList.add("RA is increased rate");
            } else {
                araList.add("RA is not increased rate");
            }

            if (item260.getARABit45() == 1) {
                araList.add("RA is a sense reversal");
            } else {
                araList.add("RA is not a sense reversal");
            }

            if (item260.getARABit46() == 1) {
                araList.add("RA is altitude crossing");
            } else {
                araList.add("RA is not altitude crossing");
            }

            if (item260.getARABit47() == 1) {
                araList.add("RA is positive");
            } else {
                araList.add("RA is vertical speed limit");
            }

        }

        if (item260.getMultiThreatIndicator() == 1) {

            if (item260.getARABit42() == 1) {
                araList.add("RA requires a correction in the upward sense");
            } else {
                araList.add("RA does not require a correction in the upward sense ");
            }

            if (item260.getARABit43() == 1) {
                araList.add("RA requires a positive climb");
            } else {
                araList.add("RA does not require a positive climb");
            }

            if (item260.getARABit44() == 1) {
                araList.add("RA requires a correction in the downward sense");
            } else {
                araList.add("RA does not require a correction in the downward sense");
            }

            if (item260.getARABit45() == 1) {
                araList.add("RA requires a positive descend");
            } else {
                araList.add("RA does not require a positive descend");
            }

            if (item260.getARABit46() == 1) {
                araList.add("RA requires a crossing");
            } else {
                araList.add("RA does not require a crossing");
            }

            if (item260.getARABit47() == 1) {
                araList.add("RA is a sense reversal");
            } else {
                araList.add("RA is not a sense reversal");
            }

        }

    }
}
