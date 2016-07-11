/**
 * Created by alexandru on 7/11/16.
 */
package jlg.jade.test.asterix.cat048.item120;

import jlg.jade.asterix.cat048.item120.Cat048Item120Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat048Item120Subfield1Test extends
                                        MandatoryFixedLengthAsterixTests<Cat048Item120Subfield1> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat048Item120Subfield1 setFixedLengthAsterixDataInstance() {
        return new Cat048Item120Subfield1();
    }
}
