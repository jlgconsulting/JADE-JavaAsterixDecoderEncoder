/**
 * Created by Dan Geabunea on 7/8/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item251;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat150Item251Test extends MandatoryRepeatableAsterixTests<Cat150Item251> {

    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat150Item251 setRepeatableAsterixDataInstance() {
        return new Cat150Item251();
    }
}
