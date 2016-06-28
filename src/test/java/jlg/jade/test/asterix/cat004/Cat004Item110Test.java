/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item110;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat004Item110Test extends MandatoryRepeatableAsterixTests<Cat004Item110> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item110 setRepeatableAsterixDataInstance() {
        return new Cat004Item110();
    }
}
