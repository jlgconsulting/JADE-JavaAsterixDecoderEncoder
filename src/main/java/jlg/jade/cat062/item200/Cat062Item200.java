/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062.item200;

import jlg.jade.abstraction.FixedLengthAsterixData;
import jlg.jade.asterix.AsterixItemLength;

import java.util.BitSet;

/**
 * Cat 062 Item 200 - Calculated mode of movement
 * Contains info about vertical rate, long acceleration, transversal acceleration and
 * altitude discrepency
 * @implNote The ADF, if set, indicates that a difference has been detected in the
 * altitude information derived from radar as compared to other technologies (such
 * as ADS-B).
 */
public class Cat062Item200 extends FixedLengthAsterixData {
    private boolean altitudeDiscrepencyFlag;
    private ModeOfMovementVerticalRate verticalRate;
    private ModeOfMovementLongAcceleration longitudinalAcceleration;
    private ModeOfMovementTransversalAcceleration transversalAcceleration;

    public Cat062Item200() {
        verticalRate = ModeOfMovementVerticalRate.Undetermined;
        longitudinalAcceleration = ModeOfMovementLongAcceleration.Undetermined;
        transversalAcceleration = ModeOfMovementTransversalAcceleration.Undetermined;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        final int ADF_FLAG_BIT_INDEX = 1;
        this.altitudeDiscrepencyFlag = bs.get(ADF_FLAG_BIT_INDEX);
        appendItemDebugMsg("ADF Flag", this.altitudeDiscrepencyFlag);

        this.verticalRate = parseVerticalRate(bs);
        appendItemDebugMsg("Vertical Rate", verticalRate);

        this.longitudinalAcceleration = parseLongitudinalAcceleration(bs);
        appendItemDebugMsg("Longitudinal acceleration", longitudinalAcceleration);

        this.transversalAcceleration = parseTransversalAcceleration(bs);
        appendItemDebugMsg("Transversal acceleration", transversalAcceleration);
    }

    /**
     * @return True, if aircraft has a calculated altitude discrepency, false othervise
     */
    public boolean hasAltitudeDiscrepency() {
        return altitudeDiscrepencyFlag;
    }

    /**
     * @return The vertical mode of movement for the aircraft
     * - level
     * - climb
     * - descend
     * - undetermined
     */
    public ModeOfMovementVerticalRate getVerticalRate() {
        return verticalRate;
    }

    /**
     * @return The longitudinal acceleration for the aircraft (ground speed)
     * - constant
     * - increasing speed
     * - decreasing speed
     * - undetermined
     */
    public ModeOfMovementLongAcceleration getLongitudinalAcceleration() {
        return longitudinalAcceleration;
    }

    /**
     * @return The transversal acceleration for the aircraft (course)
     * - constant course
     * - tigth turn
     * - left turn
     * - undetermined
     */
    public ModeOfMovementTransversalAcceleration getTransversalAcceleration() {
        return transversalAcceleration;
    }


    private ModeOfMovementVerticalRate parseVerticalRate(BitSet bs) {
        final int BIT_INDEX_MIN = 2;
        final int BIT_INDEX_MAX = 3;
        if (!bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementVerticalRate.Level;
        }
        if (bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementVerticalRate.Climb;
        }
        if (!bs.get(BIT_INDEX_MIN) && bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementVerticalRate.Descent;
        }
        return ModeOfMovementVerticalRate.Undetermined;
    }

    private ModeOfMovementLongAcceleration parseLongitudinalAcceleration(BitSet bs) {
        final int BIT_INDEX_MIN = 4;
        final int BIT_INDEX_MAX = 5;
        if (!bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementLongAcceleration.ConstantGroundSpeed;
        }
        if (bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementLongAcceleration.IncreasingGroundSpeed;
        }
        if (!bs.get(BIT_INDEX_MIN) && bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementLongAcceleration.DecreasingGroundSpeed;
        }
        return ModeOfMovementLongAcceleration.Undetermined;
    }

    private ModeOfMovementTransversalAcceleration parseTransversalAcceleration(BitSet bs) {
        final int BIT_INDEX_MIN = 6;
        final int BIT_INDEX_MAX = 7;
        if (!bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementTransversalAcceleration.ConstantCourse;
        }
        if (bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementTransversalAcceleration.RightTurn;
        }
        if (!bs.get(BIT_INDEX_MIN) && bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementTransversalAcceleration.LeftTurn;
        }
        return ModeOfMovementTransversalAcceleration.Undetermined;
    }
}
