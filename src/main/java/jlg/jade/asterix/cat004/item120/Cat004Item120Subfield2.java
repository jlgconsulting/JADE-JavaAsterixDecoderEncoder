/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.asterix.cat004.item120;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.NumericBitSet;

/**
 * Cat004 - Item120 - Subfield 2 - Conflict Classification
 */
public class Cat004Item120Subfield2 extends FixedLengthAsterixData {
    private int tableId;
    private int severityClass;
    private int conflictSeverity;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        int[] bits = NumericBitSet.transform(input[offset]);

        this.tableId = bits[7] * 2 * 2 * 2 +
                bits[6] * 2 * 2 +
                bits[5] * 2 +
                bits[4];
        appendItemDebugMsg("Table Id", this.getTableId());

        this.severityClass = bits[3] * 2 * 2 +
                bits[2] * 2 +
                bits[1];
        appendItemDebugMsg("Severity Class", this.severityClass);

        this.conflictSeverity = bits[0];
        appendItemDebugMsg("Severity [0=LOW, 1=HIGH]", this.conflictSeverity);
    }

    @Override
    protected String setDisplayName() {
        return "Cat004Item120Subfield2 - Conflict classification";
    }

    /**
     * For STCA, table id is 0001 (1)
     * For RIMCAS, table id is 0010 (2)
     *
     * @ The table id
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * For STCA, Table Id = 0001 defines the following filter settings:
     * bits-4 (LPF) Linear Prediction Filter
     * = 0 Filter not set
     * = 1 Filter set
     * bits-3 (CPF) Current Proximity Filter
     * = 0 Filter not set
     * = 1 Filter set
     * bits-2 (MHF) Manoeuvre Hazard Filter
     * = 0 Filter not set
     * = 1 Filter set
     * For RIMCAS, Table Id = 0010 defines the following alert stages:
     * bits-4 (RAS) RIMCAS Alert Stage
     * = 0 Stage One Alert
     * = 1 Stage Two Alert
     */
    public int getSeverityClass() {
        return severityClass;
    }

    /**
     * @return 0 for LOW severity, 1 for HIGH severity
     */
    public int getConflictSeverity() {
        return conflictSeverity;
    }
}
