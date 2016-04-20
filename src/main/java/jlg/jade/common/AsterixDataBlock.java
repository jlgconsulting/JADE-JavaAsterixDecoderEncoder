/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

import java.util.ArrayList;
import java.util.List;

public class AsterixDataBlock extends DebugMessageSource {
    private int category;
    private int length;
    private List<AsterixRecord> records;

    public AsterixDataBlock(int category, int length) {
        this.category = category;
        this.length = length;
        this.records = new ArrayList<>();
    }

    public int parseData(byte[] inputData, int inputIndex) {
        while (inputIndex < length) {
            AsterixRecord record = new AsterixRecord(category);
            inputIndex = record.parseData(inputData, inputIndex, length);
            records.add(record);
        }
        return inputIndex;
    }
}
