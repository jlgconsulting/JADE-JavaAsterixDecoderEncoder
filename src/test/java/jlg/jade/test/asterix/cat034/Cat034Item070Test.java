/**
 * Created by alexandru on 7/1/16.
 */
package jlg.jade.test.asterix.cat034;

import jlg.jade.asterix.cat034.Cat034Item070;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat034Item070Test extends MandatoryRepeatableAsterixTests<Cat034Item070> {
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat034Item070 setRepeatableAsterixDataInstance() {
        return new Cat034Item070();
    }

}
