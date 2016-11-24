/* 
* Created by dan-geabunea on 5/9/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item200;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.nio.ByteBuffer;
import java.util.BitSet;

/**
 * Cat 062 Item 200 - Calculated mode of movement
 * Contains info about vertical rate, long acceleration, transversal acceleration and
 * altitude discrepency
 *
 * @implNote The ADF, if set, indicates that a difference has been detected in the
 * altitude information derived from radar as compared to other technologies (such
 * as ADS-B).
 */
public class Cat062Item200 extends FixedLengthAsterixData {
    private boolean altitudeDiscrepencyFlag;
    private int verticalRate;
    private int longitudinalAcceleration;
    private int transversalAcceleration;

    public Cat062Item200() {
        final int UNDETERMINED_VALUE = 3;

        verticalRate = UNDETERMINED_VALUE;
        longitudinalAcceleration = UNDETERMINED_VALUE;
        transversalAcceleration = UNDETERMINED_VALUE;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item200 - Calculated Mode of Movement";
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

    @Override
    public byte[] encode() {
        /*
        We need to calculate the corresponding byte values for all the components of this item. Then, we can sum them
        up to get the item byte value, which can be represented as a byte array of one element. The byte value of
        the components depends upn their position in the item octet representation.
         */
        byte asfAsByteValue = 0;
        if (this.hasAltitudeDiscrepency()) {
            asfAsByteValue = 2;
        }
        byte verticalRateAsByteValue = getVerticalRateAsComponentByteValue();
        byte longitudinalAccelerationAsByteValue = getLongitudinalAccelerationAsComponentByteValue();
        byte transversalAccelerationAsByteValue = getTransversalAccelerationAsComponentByteValue();

        byte itemAsByteValue = (byte) (asfAsByteValue +
                        verticalRateAsByteValue +
                        longitudinalAccelerationAsByteValue +
                        transversalAccelerationAsByteValue);

        byte[] itemAsByteArray = ByteBuffer.allocate(this.sizeInBytes)
                .put(itemAsByteValue)
                .array();

        return itemAsByteArray;
    }

    /**
     * @return True, if aircraft has a calculated altitude discrepency, false othervise
     */
    public boolean hasAltitudeDiscrepency() {
        return altitudeDiscrepencyFlag;
    }

    public void setAltitudeDiscrepencyFlag(boolean altitudeDiscrepencyFlag) {
        this.altitudeDiscrepencyFlag = altitudeDiscrepencyFlag;
    }

    /**
     * @return The vertical mode of movement for the aircraft
     * - level = 0
     * - climb = 1
     * - descend = 2
     * - undetermined = 3
     */
    public int getVerticalRate() {
        return verticalRate;
    }

    /**
     * Set the vertical rate. Allowed values are:
     * - level = 0
     * - climb = 1
     * - descend = 2
     * - undetermined = 3
     *
     * @param verticalRate
     */
    public void setVerticalRate(int verticalRate) {
        this.verticalRate = verticalRate;
    }

    /**
     * @return The longitudinal acceleration for the aircraft (ground speed)
     * - constant = 0
     * - increasing speed = 1
     * - decreasing speed = 2
     * - undetermined =3
     */
    public int getLongitudinalAcceleration() {
        return longitudinalAcceleration;
    }

    /**
     * Set the longitudinal acceleration
     * - constant = 0
     * - increasing speed = 1
     * - decreasing speed = 2
     * - undetermined =3
     *
     * @param longitudinalAcceleration
     */
    public void setLongitudinalAcceleration(int longitudinalAcceleration) {
        this.longitudinalAcceleration = longitudinalAcceleration;
    }

    /**
     * @return The transversal acceleration for the aircraft (course)
     * - constant course = 0
     * - tigth turn = 1
     * - left turn = 2
     * - undetermined = 3
     */
    public int getTransversalAcceleration() {
        return transversalAcceleration;
    }

    /**
     * Set the transversal acceleraiton
     * - constant course = 0
     * - tigth turn = 1
     * - left turn = 2
     * - undetermined = 3
     *
     * @param transversalAcceleration
     */
    public void setTransversalAcceleration(int transversalAcceleration) {
        this.transversalAcceleration = transversalAcceleration;
    }

    private int parseVerticalRate(BitSet bs) {
        final int BIT_INDEX_MIN = 2;
        final int BIT_INDEX_MAX = 3;
        if (!bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementVerticalRate.Level.getValue();
        }
        if (bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementVerticalRate.Climb.getValue();
        }
        if (!bs.get(BIT_INDEX_MIN) && bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementVerticalRate.Descent.getValue();
        }
        return ModeOfMovementVerticalRate.Undetermined.getValue();
    }

    private int parseLongitudinalAcceleration(BitSet bs) {
        final int BIT_INDEX_MIN = 4;
        final int BIT_INDEX_MAX = 5;
        if (!bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementLongAcceleration.ConstantGroundSpeed.getValue();
        }
        if (bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementLongAcceleration.IncreasingGroundSpeed.getValue();
        }
        if (!bs.get(BIT_INDEX_MIN) && bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementLongAcceleration.DecreasingGroundSpeed.getValue();
        }
        return ModeOfMovementLongAcceleration.Undetermined.getValue();
    }

    private int parseTransversalAcceleration(BitSet bs) {
        final int BIT_INDEX_MIN = 6;
        final int BIT_INDEX_MAX = 7;
        if (!bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementTransversalAcceleration.ConstantCourse.getValue();
        }
        if (bs.get(BIT_INDEX_MIN) && !bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementTransversalAcceleration.RightTurn.getValue();
        }
        if (!bs.get(BIT_INDEX_MIN) && bs.get(BIT_INDEX_MAX)) {
            return ModeOfMovementTransversalAcceleration.LeftTurn.getValue();
        }
        return ModeOfMovementTransversalAcceleration.Undetermined.getValue();
    }


    private byte getTransversalAccelerationAsComponentByteValue() {
        byte transversalAccelerationAsByteValue = 0;
        switch (this.transversalAcceleration){
            case 0: {
                break;
            }
            case 1: {
                transversalAccelerationAsByteValue = 64;
                break;
            }
            case 2: {
                transversalAccelerationAsByteValue = (byte) 128;
                break;
            }
            case 3: {
                transversalAccelerationAsByteValue = (byte) 192;
                break;
            }
            default: {
                throw new RuntimeException("Encoding failed because transversal acc was invalid." +
                        this.getClass().getName() + ". Transversal acc: " + this.transversalAcceleration);
            }
        }

        return transversalAccelerationAsByteValue;
    }

    private byte getLongitudinalAccelerationAsComponentByteValue() {
        byte longitudinalAccelerationAsByteValue = 0;
        switch (this.longitudinalAcceleration) {
            case 0: {
                break;
            }
            case 1: {
                longitudinalAccelerationAsByteValue = 16;
                break;
            }
            case 2: {
                longitudinalAccelerationAsByteValue = 32;
                break;
            }
            case 3: {
                longitudinalAccelerationAsByteValue = 48;
                break;
            }
            default: {
                throw new RuntimeException("Encoding failed because longitudinal acc was invalid." +
                        this.getClass().getName() + ". Long acc: " + this.longitudinalAcceleration);
            }
        }

        return longitudinalAccelerationAsByteValue;
    }

    private byte getVerticalRateAsComponentByteValue() {
        byte verticalRateAsByteValue = 0;
        switch (this.verticalRate){
            case 0:{
                break;
            }
            case 1:{
                verticalRateAsByteValue = 4;
                break;
            }
            case 2:{
                verticalRateAsByteValue = 8;
                break;
            }
            case 3:{
                verticalRateAsByteValue = 12;
                break;
            }
            default:{
                throw new RuntimeException("Encoding failed because vertical rate value was invalid." +
                        this.getClass().getName() + ". Vertical rate: " + this.verticalRate);
            }
        }

        return verticalRateAsByteValue;
    }
}
