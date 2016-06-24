/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.test.asterix.cat004.item120;

import jlg.jade.asterix.cat004.item120.Cat004Item120Subfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class Cat004Item120Subfield2Test extends
        MandatoryFixedLengthAsterixTests<Cat004Item120Subfield2> {

    @Override
    protected int setExpectedItemSizeInBytes() {
        return 1;
    }

    @Override
    protected Cat004Item120Subfield2 setFixedLengthAsterixDataInstance() {
        return new Cat004Item120Subfield2();
    }

    @Test
    @Parameters({"16,1", "31,1", "32,2", "47,2"})
    public void the_decode_method_should_correctly_decode_table_id(int octetValue, int expected) {
        //arrange
        byte[] input = {(byte) octetValue};
        int offset = 0;
        Cat004Item120Subfield2 subfield2 = new Cat004Item120Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("Table Id not decoded correctly", expected, subfield2.getTableId());
    }

    @Test
    @Parameters({"240,0", "241,0", "0,0", "242,1", "243,1", "1,0"})
    public void the_decode_method_should_correctly_decode_the_severity_class(int octetValue,
                                                                             int expected) {
        //arrange
        byte[] input = {(byte) octetValue};
        int offset = 0;
        Cat004Item120Subfield2 subfield2 = new Cat004Item120Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("Severity class not decoded correctly", expected,
                subfield2.getSeverityClass());
    }

    @Test
    @Parameters({"1,1","0,0","254,0","255,1"})
    public void the_decode_method_should_correctly_decode_the_conflict_severity(int octetValue,
                                                                                int expected){
        //arrange
        byte[] input = {(byte) octetValue};
        int offset = 0;
        Cat004Item120Subfield2 subfield2 = new Cat004Item120Subfield2();

        //act
        subfield2.decode(input, offset, input.length);

        //assert
        assertEquals("Conflict severity not decoded correctly", expected,
                subfield2.getConflictSeverity());
    }
}
