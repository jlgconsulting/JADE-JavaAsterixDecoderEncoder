/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item180;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat150Item180Test extends MandatoryRepeatableAsterixTests<Cat150Item180> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item180 setRepeatableAsterixDataInstance() {
        return new Cat150Item180();
    }
}
