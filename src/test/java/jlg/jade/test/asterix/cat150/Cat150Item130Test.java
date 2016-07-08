/**
 * Created by Dan Geabunea on 7/4/2016.
 */

package jlg.jade.test.asterix.cat150;

import jlg.jade.asterix.cat150.Cat150Item130;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat150Item130Test extends MandatoryFixedLengthAsterixTests<Cat150Item130> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat150Item130 setFixedLengthAsterixDataInstance() {
        return new Cat150Item130();
    }
}
