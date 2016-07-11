/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048.item120;

import jlg.jade.asterix.cat048.item120.Cat048Item120Subfield2;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat048Item120Subfield2Test extends
                                        MandatoryRepeatableAsterixTests<Cat048Item120Subfield2> {

    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 6;
    }

    @Override
    protected Cat048Item120Subfield2 setRepeatableAsterixDataInstance() {
        return new Cat048Item120Subfield2();
    }
}
