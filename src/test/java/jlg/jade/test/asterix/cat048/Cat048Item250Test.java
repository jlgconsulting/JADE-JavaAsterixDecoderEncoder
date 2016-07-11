/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048;

import jlg.jade.asterix.cat048.Cat048Item250;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat048Item250Test extends MandatoryRepeatableAsterixTests<Cat048Item250> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 8;
    }

    @Override
    protected Cat048Item250 setRepeatableAsterixDataInstance() {
        return new Cat048Item250();
    }
}
