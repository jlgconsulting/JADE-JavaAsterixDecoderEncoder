/* 
* Created by dan-geabunea on 5/4/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

import jlg.jade.common.Constants;

import java.util.BitSet;

/**
 * Represents an Asterix data item where the content is split in two parts: a spec and the actual data.
 * The spec is used to know what subfields/subitems are present in the data. This is usually represented by a FX field.
 * Will be extended by all Asterix data items that have fspec.
 */
public abstract class FspecAsterixData extends AsterixItem implements Decodable {
    private final int maxFspecSizeInBytes;
    private int actualFspecSizeInBytes;
    private int nbPresentDataFields;
    private final boolean[] fspec;

    protected FspecAsterixData() {
        //initialize max fspec size and fspec array. All items will be false;
        this.maxFspecSizeInBytes = setMaxFspecSizeInBytes();
        this.fspec = new boolean[maxFspecSizeInBytes * Constants.BYTE_TO_BITS];
    }

    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        appendDebugMsg(this.getClass().getSimpleName()+":");
        appendNewLine();

        actualFspecSizeInBytes = readFspec(input, offset);
        offset += actualFspecSizeInBytes;
        offset = decodeFromByteArray(input, offset, inputLength);

        return offset;
    }

    /**
     * CHecks if a particlar kind of data is present in the fpsec info.
     *
     * @param fsepcIndex the bit index in the fspec array
     * @return true, if item is present in FSPEC, false otherwise
     */
    public boolean fspecDataAtIndex(int fsepcIndex) {
        return fspec[fsepcIndex];
    }

    public int getActualFspecSizeInBytes() {
        return actualFspecSizeInBytes;
    }

    public int getMaxFspecSizeInBytes() {
        return maxFspecSizeInBytes;
    }

    public int getNbPresentDataFields() {
        return nbPresentDataFields;
    }

    /**
     * Set the maximum FSPEC size that can be read by a particluar item.
     */
    protected abstract int setMaxFspecSizeInBytes();

    protected abstract int decodeFromByteArray(byte[] input, int offset, int length);

    private int readFspec(byte[] input, int offset) {
        final int FX_BIT_POS = 0;
        final int BITS_IN_OCTET = 8;
        int currentLength = 0;

        for (int i = 0; i < maxFspecSizeInBytes; i++) {
            BitSet bs = BitSet.valueOf(new byte[]{input[offset + i]});

            //populate fspec
            for (int j = 0; j < BITS_IN_OCTET; j++) {
                int fspecIndex = currentLength * BITS_IN_OCTET + j;
                fspec[fspecIndex] = bs.get(j);
                if (bs.get(j) && j != FX_BIT_POS) {
                    nbPresentDataFields++;
                }
            }

            //increase length and read next octet
            currentLength++;
            if (!bs.get(FX_BIT_POS)) {
                appendDebugMsg("FX bit is 0. Finished reading data for this item");
                appendNewLine();
                break;
            }
            appendDebugMsg("FX bit is 1. Continue to read data");
            appendNewLine();
        }
        for (int i = 0; i < currentLength; i++) {
            appendItemDebugMsg("Octet " + i + " (dec)", Byte.toUnsignedInt(input[offset + i]));
            appendItemDebugMsg("Octet " + i + " (bin)", BitWriter.getBitsRightToLeft(input[offset + i]));
        }
        appendNewLine();

        //return current offset
        return offset + currentLength;
    }
}
