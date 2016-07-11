/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item065;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat048Item065Test extends MandatoryFixedLengthAsterixTests<Cat048Item065> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat048Item065 setFixedLengthAsterixDataInstance() {
        return new Cat048Item065();
    }
}
