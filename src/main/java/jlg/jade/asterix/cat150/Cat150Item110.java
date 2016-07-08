/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.util.BitSet;

/**
 * Cat150 Item110 - Status Flags
 * Status of the flight
 */
public class Cat150Item110 extends FixedLengthAsterixData {
    private boolean holdFlag;
    private Cat150Item110RvsmStatus rvsmStatus;

    public Cat150Item110() {
        this.rvsmStatus = Cat150Item110RvsmStatus.UNKNOWN;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        final int HLD_BIT_POSITION = 6;
        this.holdFlag = bs.get(HLD_BIT_POSITION);

        //if all rvsm bits are 0 => UNKNOWN RVSM
        final int RVQ_BIT_POS = 5;
        if (bs.get(RVQ_BIT_POS)) {
            this.rvsmStatus = Cat150Item110RvsmStatus.EQUIPPED;
        }
        final int RVC_BIT_POS = 4;
        if (bs.get(RVC_BIT_POS)) {
            this.rvsmStatus = Cat150Item110RvsmStatus.CAPABLE;
        }
        final int RVX_BIT_POS = 3;
        if (bs.get(RVX_BIT_POS)) {
            this.rvsmStatus = Cat150Item110RvsmStatus.EXEMPTED;
        }

        appendItemDebugMsg("HLD", this.getHoldFlag());
        appendItemDebugMsg("RVSM", this.getRvsmStatus());
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item110 - Status Flags";
    }

    public boolean getHoldFlag() {
        return holdFlag;
    }

    /**
     * @return The RVSM status or UNKNOWN is all RVSM flags are set to 0
     */
    public Cat150Item110RvsmStatus getRvsmStatus() {
        return rvsmStatus;
    }
}
