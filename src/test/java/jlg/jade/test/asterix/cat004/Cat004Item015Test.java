/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat004;

import jlg.jade.asterix.cat004.Cat004Item015;
import jlg.jade.test.utils.MandatoryRepeatableAsterixTests;

public class Cat004Item015Test extends MandatoryRepeatableAsterixTests<Cat004Item015>{
    @Override
    protected int setExpectedRepeatableBlockSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004Item015 setRepeatableAsterixDataInstance() {
        return new Cat004Item015();
    }
}
