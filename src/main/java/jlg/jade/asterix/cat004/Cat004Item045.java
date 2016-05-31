/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.util.BitSet;

/**
 * Cat 004 - Item015 - Alert Status
 *
 * @implSpec Inv ersion 1.8, the informaiton is only given by bits 2,3,4. The rest are spare bits.
 * @implSpec The content of this item is implementation dependent
 */
public class Cat004Item045 extends FixedLengthAsterixData {
    private byte rawInput;
    private int alertStatus;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        rawInput = input[offset];

        //we shift with one byte because bit0 is spare bit and not used for the value computation
        int decodedValue = input[offset] >> 1;
        this.alertStatus = decodedValue;
        appendItemDebugMsg("Alert Status", this.alertStatus);
    }


    @Override
    protected String setDisplayName() {
        return "Cat004Item045 - Alert Status";
    }

    @Override
    protected boolean validate() {
        BitSet bs = BitSet.valueOf(new byte[]{rawInput});
        if(bs.get(0) == true){
            appendWarningMessage("Invalid data. Bit 1 is spare and should be 0. Counting begins from 1 to match ICD.");
            return false;
        }
        if(bs.get(4) == true){
            appendWarningMessage("Invalid data. Bit 5 is spare and should be 0. Counting begins from 1 to match ICD.");
            return false;
        }
        if(bs.get(5) == true){
            appendWarningMessage("Invalid data. Bit 6 is spare and should be 0. Counting begins from 1 to match ICD.");
            return false;
        }
        if(bs.get(6) == true){
            appendWarningMessage("Invalid data. Bit 7 is spare and should be 0. Counting begins from 1 to match ICD.");
            return false;
        }
        if(bs.get(7) == true){
            appendWarningMessage("Invalid data. Bit 8 is spare and should be 0. Counting begins from 1 to match ICD.");
            return false;
        }

        return true;
    }

    public int getAlertStatus() {
        return alertStatus;
    }

}
