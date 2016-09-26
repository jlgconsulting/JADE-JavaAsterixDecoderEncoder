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
            case Version604:
                generateV604ARAList(item260);
                break;
            case Version70:
                generateV70ARAList(item260);
                break;
        }

        return araList;
    }

    private void generateV604ARAList(Cat048Item260 item260) {

        if (item260.getARABit41() == 1) {
            araList.add("CLIMB");
        }

        if (item260.getARABit42() == 1) {
            araList.add("DND1");
        }

        if (item260.getARABit43() == 1) {
            araList.add("DND2");
        }

        if (item260.getARABit44() == 1) {
            araList.add("DND3");
        }

        if (item260.getARABit45() == 1) {
            araList.add("DND4");
        }

        if (item260.getARABit46() == 1) {
            araList.add("DESCEND");
        }

        if (item260.getARABit47() == 1) {
            araList.add("DNC1");
        }

        if (item260.getARABit48() == 1) {
            araList.add("DNC2");
        }

        if (item260.getARABit49() == 1) {
            araList.add("DNC3");
        }

        if (item260.getARABit50() == 1) {
            araList.add("DNC4");
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
