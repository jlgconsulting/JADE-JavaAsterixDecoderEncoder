/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat084Item050;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat084Item050Test extends MandatoryFixedLengthAsterixTests<Cat084Item050> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat084Item050 setFixedLengthAsterixDataInstance() {
        return new Cat084Item050();
    }
}
