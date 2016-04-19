/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixDecodingException;
import jlg.jade.asterix.AsterixItem;
import jlg.jade.asterix.AsterixItemLength;
import org.slf4j.Logger;

/**
 * Cat-062 Item 010 - Data Source Identifier - Mandatory
 * Identification of the system sending the data (SAC-SIC)
 */
public class AsterixCat062Item010 extends AsterixItem {
    private int sac;
    private int sic;

    public AsterixCat062Item010(Logger logger) {
        super(logger);
        itemLength = AsterixItemLength.TWO_BYTES;
        sac = 0;
        sic = 0;
    }

    public int getSac() {
        return sac;
    }

    public int getSic() {
        return sic;
    }

    @Override
    public int parseData(byte[] inputData, int currentIndex, int inputLength) {
        reset();
        checkLength(currentIndex, inputLength);

        sac = Byte.toUnsignedInt(inputData[currentIndex]);
        sic = Byte.toUnsignedInt(inputData[currentIndex + 1]);

        logger.debug(String.format("%-30s %-20s", "SAC:", sac));
        logger.debug(String.format("%-30s %-20s", "SAC:", sic));

        currentIndex += currentIndex + itemLength.getValue();
        return currentIndex;
    }

    @Override
    public void reset() {
        sac = 0;
        sic = 0;
    }
}
