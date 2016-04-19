/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.common.AsterixItem;
import jlg.jade.common.AsterixItemLength;

/**
 * Cat 062 Item 015 - Service Identification - Optional
 * Identification of the service provided to one or more users
 */
public class AsterixCat062Item015 extends AsterixItem {
    private int serviceIdentification;

    public AsterixCat062Item015(){
        itemLength = AsterixItemLength.ONE_BYTE;
    }

    @Override
    public int parseData(byte[] inputData, int currentIndex, int inputLength) {
        reset();
        checkLength(currentIndex, inputLength);

        serviceIdentification = Byte.toUnsignedInt(inputData[currentIndex]);
        appendDebugMsg(String.format("%-30s %-20s", "Service identification:", serviceIdentification));
        currentIndex++;

        return currentIndex;
    }

    @Override
    public void reset() {
        serviceIdentification = 0;
    }

    public int getServiceIdentification() {
        return serviceIdentification;
    }
}
