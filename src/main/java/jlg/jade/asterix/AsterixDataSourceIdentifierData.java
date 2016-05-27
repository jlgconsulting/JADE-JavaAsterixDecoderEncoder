/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

/**
 * Data Source Identifier - Mandatory
 * Identification of the system sending the data (SAC-SIC)
 * BAse class for all items that will represent SAC SIC informaiton
 */
public abstract class AsterixDataSourceIdentifierData extends FixedLengthAsterixData {
    private int sac;
    private int sic;

    protected AsterixDataSourceIdentifierData() {
        this.sizeInBytes = AsterixItemLength.TWO_BYTES.getValue();
        this.sac = 0;
        this.sic = 0;
    }

    public int getSac() {
        return this.sac;
    }

    public int getSic() {
        return this.sic;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.sac = Byte.toUnsignedInt(input[offset]);
        this.sic = Byte.toUnsignedInt(input[offset + 1]);

        appendItemDebugMsg("SAC:", this.sac);
        appendItemDebugMsg("SIC:", this.sic);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }
}
