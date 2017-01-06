package jlg.jade.test.asterix;

import jlg.jade.asterix.AsterixDataBlock;
import org.junit.Test;

/**
 * Created by Dan Geabunea on 1/6/2017.
 */
public class AsterixDataBlockTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_if_we_pass_null_custom_reserved_field_factory_in_ctor(){
        AsterixDataBlock dataBlock = new AsterixDataBlock(62, null);
    }
}
