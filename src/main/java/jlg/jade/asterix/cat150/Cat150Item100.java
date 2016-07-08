/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.util.BitSet;

/**
 * Cat150 Item100 - Type flags
 */
public class Cat150Item100 extends FixedLengthAsterixData {
    private boolean gatFlag;
    private boolean oatFlag;
    private boolean cplFlag;
    private boolean spnFlag;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        final int GAT_BIT_POSITION = 7;
        this.gatFlag = bs.get(GAT_BIT_POSITION);

        final int OAT_BIT_POSITION = 6;
        this.oatFlag = bs.get(OAT_BIT_POSITION);

        final int CPL_BIT_POSITION = 2;
        this.cplFlag = bs.get(CPL_BIT_POSITION);

        final int SPN_BIT_POSITION = 1;
        this.spnFlag = bs.get(SPN_BIT_POSITION);

        appendItemDebugMsg("GAT", this.gatFlag);
        appendItemDebugMsg("OAT", this.oatFlag);
        appendItemDebugMsg("CPL", this.cplFlag);
        appendItemDebugMsg("SPN", this.spnFlag);

        if (!this.gatFlag && !this.oatFlag) {
            appendWarningMessage("GAT and OAT flags are both 0 (false). Unknown flight type.");
        }

        if (!this.cplFlag && !this.spnFlag) {
            appendWarningMessage("CPL and SPN flags are both 0 (false). Unknown plan type");
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item100 - Type Flags";
    }

    /**
     * @return True, if flight is GAT.
     */
    public boolean getGatFlag() {
        return gatFlag;
    }

    /**
     * @return True is flight is OAT.
     */
    public boolean getOatFlag() {
        return oatFlag;
    }

    /**
     * @return True if flight plan is complete.
     */
    public boolean getCplFlag() {
        return cplFlag;
    }

    /**
     * @return True, if flight plan is short
     */
    public boolean getSpnFlag() {
        return spnFlag;
    }
}
