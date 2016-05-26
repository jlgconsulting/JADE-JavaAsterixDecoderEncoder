/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat065;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat 065 Item 050 - Service Status Report
 */
public class Cat065Item050 extends FixedLengthAsterixData {
    private int report;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.report = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        appendItemDebugMsg("Report (see meaning in Cat-065 ICD)", this.report);

        if (report < 1 || report > 16) {
            appendDebugMsg("[WARNING] According to ICD, values should be between 1 and 16");
            appendNewLine();
        }
    }

    @Override
    protected String setDisplayName() {
        return "Cat065Item050 - Service Status Report";
    }

    /**
     * @return The report status, as a number
     * 1: service degradation
     * 2: service degradation ended
     * 3: main radar out of service
     * 4: service interrupted by the operator
     * 5: service interrupted due to contingency
     * 6: ready for service restart after contingency
     * 7: service ended by the operator
     * 8: failure of user main radar
     * 9: service restarted by the operator
     * 10: main radar becoming operational
     * 11: main radar becoming degraded
     * 12: service continuity interrupted due to
     * disconnection with adjacent unit
     * 13: service continuity restarted
     * 14: service synchronised on backup radar
     * 15: service synchronised on main radar
     * 16: main and backup radar, if any, failed
     */
    public int getReport() {
        return report;
    }
}
