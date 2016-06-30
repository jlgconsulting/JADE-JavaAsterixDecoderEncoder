/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.test.asterix.cat034.item050;

import jlg.jade.asterix.cat034.item050.Cat034Item050Subfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat034Item050Subfield4Test extends MandatoryFixedLengthAsterixTests<Cat034Item050Subfield4> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat034Item050Subfield4 setFixedLengthAsterixDataInstance() {
        return new Cat034Item050Subfield4();
    }
}
