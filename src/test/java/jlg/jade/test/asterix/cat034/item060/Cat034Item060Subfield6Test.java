/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.test.asterix.cat034.item060;

import jlg.jade.asterix.cat034.item060.Cat034Item060Subfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat034Item060Subfield6Test extends MandatoryFixedLengthAsterixTests<Cat034Item060Subfield6> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat034Item060Subfield6 setFixedLengthAsterixDataInstance() {
        return new Cat034Item060Subfield6();
    }
}
