/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item100;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat048Item100Test extends MandatoryFixedLengthAsterixTests<Cat048Item100> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat048Item100 setFixedLengthAsterixDataInstance() {
        return new Cat048Item100();
    }
}
