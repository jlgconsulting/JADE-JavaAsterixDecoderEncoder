/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.asterix.cat004.item100;

import jlg.jade.asterix.cat004.item100.Cat004Item100Subfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004Item100Subfield1Test extends MandatoryFixedLengthAsterixTests<Cat004Item100Subfield1> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 6;
    }

    @Override
    protected Cat004Item100Subfield1 setFixedLengthAsterixDataInstance() {
        return new Cat004Item100Subfield1();
    }
}
