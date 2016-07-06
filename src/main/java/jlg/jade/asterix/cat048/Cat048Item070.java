/**
 * Created by alexandru on 7/6/16.
 */
package jlg.jade.asterix.cat048;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.ModeACode;

import java.util.BitSet;

public class Cat048Item070 extends FixedLengthAsterixData {
    private boolean mode3AValidated;
    private boolean mode3AGarbled;
    private int mode3ADeduction;
    private int mode3AReply;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        decodeMode3AValidated(bs);
        decodeMode3Garbled(bs);
        decodeMode3Deduction(bs);
        decodeMode3ARepresentation(input, offset);
    }

    private void decodeMode3Deduction(BitSet bs) {
        final int MODE3A_DEDUCTION_BIT = 5;
        if (bs.get(MODE3A_DEDUCTION_BIT)) {
            this.mode3ADeduction = 1;
        } else {
            this.mode3ADeduction = 0;
        }
        appendItemDebugMsg("Mode3 Deduction", this.mode3ADeduction);
    }

    private void decodeMode3Garbled(BitSet bs) {
        final int MODE3A_GARBLED_BIT = 6;
        if (bs.get(MODE3A_GARBLED_BIT)) {
            this.mode3AGarbled = true;
        } else {
            this.mode3AGarbled = false;
        }
        appendItemDebugMsg("Mode3A Garbled", this.mode3AGarbled);
    }

    private void decodeMode3AValidated(BitSet bs) {
        final int MODE3_VALIDATED_BIT = 7;
        if (bs.get(MODE3_VALIDATED_BIT)) {
            this.mode3AValidated = false;
        } else {
            this.mode3AValidated = true;
        }
        appendItemDebugMsg("Mode3A Validated", this.mode3AValidated);
    }

    private void decodeMode3ARepresentation(byte[] input, int offset) {

        int firstByteValue = Byte.toUnsignedInt(input[offset]);
        BitSet firstByteBits = BitSet.valueOf(new byte[]{input[offset]});

        // for each present bit with pos = 7-4 substract 2^pos from integer value
        if (firstByteBits.get(7)) {
            firstByteValue = firstByteValue - 128;
        }
        if (firstByteBits.get(6)) {
            firstByteValue = firstByteValue - 64;
        }
        if (firstByteBits.get(5)) {
            firstByteValue = firstByteValue - 32;
        }
        if (firstByteBits.get(4)) {
            firstByteValue = firstByteValue - 16;
        }

        this.mode3AReply = firstByteValue * 256 + Byte.toUnsignedInt(input[offset + 1]);
        appendItemDebugMsg("Mode3A (decimal)", this.mode3AReply);
        appendItemDebugMsg("Mode3A (octal)", this.getMode3AReplyOctal());

    }

    @Override
    protected String setDisplayName() {
        return "Cat048Item070 - Mode-3/A Code in Octal Representation";
    }

    /**
     * @return 0 = Code validated
     * 1 = Code not validated
     */
    public boolean getMode3AValidated() {
        return mode3AValidated;
    }

    /**
     * @return 0 = Default
     * 1 = Garbled code
     */
    public boolean getMode3AGarbled() {
        return mode3AGarbled;
    }

    /**
     * @return 0 = Mode-3/A code derived from the reply of the transponder
     * 1 = Mode-3/A code not extracted during the last scan
     */
    public int getMode3ADeduction() {
        return mode3ADeduction;
    }

    /**
     * @return Mode-3/A reply in octal representation
     */
    public int getMode3AReply() {
        return mode3AReply;
    }

    public String getMode3AReplyOctal() {
        return ModeACode.toOctal(this.getMode3AReply());
    }
}
