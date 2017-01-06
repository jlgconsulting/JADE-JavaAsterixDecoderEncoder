package jlg.jade.test.asterix;

import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.StandardAsterixRecord;
import org.junit.Test;

/**
 * Created by Dan Geabunea on 1/6/2017.
 */
public class AsterixRecordTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_if_we_pass_null_custom_reserved_filed_factory_in_ctor(){
        AsterixRecord asterixRecord = new StandardAsterixRecord(62, null);
    }
}
