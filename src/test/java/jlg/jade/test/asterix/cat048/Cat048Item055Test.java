/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item055;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat048Item055Test extends MandatoryFixedLengthAsterixTests<Cat048Item055> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item055 setFixedLengthAsterixDataInstance() {
        return new Cat048Item055();
    }
}
