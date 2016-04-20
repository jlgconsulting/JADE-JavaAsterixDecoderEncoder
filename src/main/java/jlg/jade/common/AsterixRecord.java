/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

import jlg.jade.cat062.AsterixCat062Record;

public class AsterixRecord extends DebugMessageSource {
    private int category;
    private AsterixCat062Record cat062Record;

    public AsterixRecord(int category) {
        this.category = category;
        switch (category) {
            case 62: {
                break;
            }
            case 65: {
                break;
            }
            default:
                break;
        }
    }

    public int getCategory() {
        return category;
    }

    public AsterixCat062Record getCat062Record() {
        return cat062Record;
    }

    public int parseData(byte[] inputData, int currentIndex, int inputLength){
        return currentIndex + inputLength - currentIndex;
    }
}
