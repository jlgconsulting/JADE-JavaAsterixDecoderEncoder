/**
 * Created by alexandru on 8/2/16.
 */
package jlg.jade.asterix.cat048;

import java.util.ArrayList;
import java.util.List;

public class ARACalculator {
    private List<String> araList = new ArrayList<>();

    public List<String> getARAList(Cat048Item260 item260) {
        switch (item260.getDeterminedTCASVersion()) {
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
                araList.add("CORRECTIVE");
            } else {
                araList.add("PREVENTIVE");
            }

            if (item260.getARABit43() == 1) {
                araList.add("DOWN");
            } else {
                araList.add("UP");
            }

            if (item260.getARABit44() == 1) {
                araList.add("RATE1");
            } else {
                araList.add("RATE0");
            }

            if (item260.getARABit45() == 1) {
                araList.add("REVERSAL1");
            } else {
                araList.add("REVERSAL0");
            }

            if (item260.getARABit46() == 1) {
                araList.add("CROSSING1");
            } else {
                araList.add("CROSSING0");
            }

            if (item260.getARABit47() == 1) {
                araList.add("POSITIVE");
            } else {
                araList.add("SPEED");
            }

        }

        if (item260.getMultiThreatIndicator() == 1) {

            if (item260.getARABit42() == 1) {
                araList.add("CORR1");
            } else {
                araList.add("CORR0 ");
            }

            if (item260.getARABit43() == 1) {
                araList.add("CLIMB1");
            } else {
                araList.add("CLIMB0");
            }

            if (item260.getARABit44() == 1) {
                araList.add("DOWN1");
            } else {
                araList.add("DOWN0");
            }

            if (item260.getARABit45() == 1) {
                araList.add("DESCEND1");
            } else {
                araList.add("DESCEND0");
            }

            if (item260.getARABit46() == 1) {
                araList.add("RCROSSING1");
            } else {
                araList.add("RCROSSING0");
            }

            if (item260.getARABit47() == 1) {
                araList.add("RREVERSAL1");
            } else {
                araList.add("RREVERSAL0");
            }

        }

    }
}
