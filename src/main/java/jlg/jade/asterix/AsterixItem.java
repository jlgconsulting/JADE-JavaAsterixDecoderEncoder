/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

import org.slf4j.Logger;

/**
 * Generic definition of an Asterix item. All implementation of items will derive from
 * this base class
 */
public abstract class AsterixItem {
    protected final Logger logger;
    protected AsterixItemLength itemLength;

    public AsterixItem(Logger logger){
        this.logger = logger;
    }

    /**
     * Parses the data in an attempt to populate the Asterix item. If the data is valid, the item is populated.
     * @param inputData the byte array containing the data
     * @param currentIndex the current index of the array
     * @param inputLength the length of the current data, because not all the input array is populated
     * @return the current index of the array after the data has been read and the information has been populated
     */
    public abstract int parseData(byte[] inputData, int currentIndex, int inputLength);

    protected void validate(){
        return;
    }

    /**
     * Reset all Asterix item fields to their default values
     */
    public abstract void reset();

    /**
     * Checks if the remaining length in the input array is greater or equal than the needed length for
     * this item. If not, an UnexpectedEndOfData exception is thrown
     * @param currentIndex the current index in the input array
     * @param inputLength the length of the input array
     * @throws jlg.jade.asterix.AsterixDecodingException.UnexpectedEndOfData
     */
    protected void checkLength(int currentIndex, int inputLength){
        String itemName = this.getClass().getSimpleName();
        logger.debug(itemName + ":");
        int remainingLength = inputLength - currentIndex;
        if (itemLength.getValue() > remainingLength) {
            logger.error("Unexpected end of data found while creating " + itemName);
            throw new AsterixDecodingException.UnexpectedEndOfData();
        }
    }
}
