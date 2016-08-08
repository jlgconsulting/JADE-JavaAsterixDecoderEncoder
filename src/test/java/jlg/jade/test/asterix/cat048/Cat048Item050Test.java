/**
 * Created by alexandru on 8/8/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item050;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat048Item050Test extends MandatoryFixedLengthAsterixTests<Cat048Item050> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item050 setFixedLengthAsterixDataInstance() {
        return new Cat048Item050();
    }
}
