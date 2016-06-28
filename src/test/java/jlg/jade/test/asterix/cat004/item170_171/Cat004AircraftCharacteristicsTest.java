/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.item170_171.Cat004AircraftCharacteristicsBase;
import jlg.jade.test.utils.MandatoryFspecAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004AircraftCharacteristicsTest extends
        MandatoryFspecAsterixTests<Cat004AircraftCharacteristicsBase> {

    @Override
    protected Cat004AircraftCharacteristicsBase setDataFieldInstance() {
        return new Cat004AircraftCharacteristicsBase();
    }

    @Override
    protected int setExpectedMaxFspecSize() {
        return 2;
    }

    /**
     * FPSEC is 13, 0
     * Subf4 is 0, 0, 1
     * Subf5 is 0, 1
     */
    private final byte[] input = {13, 0, 0, 0, 1, 0, 1};

    @Override
    @Test
    public void the_decode_method_should_correctly_populate_fspec_field() {
        //arrange
        int offset = 0;
        Cat004AircraftCharacteristicsBase characteristicsBase = new
                Cat004AircraftCharacteristicsBase();

        //act
        characteristicsBase.decode(input, offset, input.length);

        //assert
        assertEquals("FSPEC actual length not correct", 2, characteristicsBase
                .getActualFspecSizeInBytes());

        assertEquals("FSPEC not decoded correctly - #1", false, characteristicsBase
                .fspecDataAtIndex(7));
        assertEquals("FSPEC not decoded correctly - #2", false, characteristicsBase
                .fspecDataAtIndex(6));
        assertEquals("FSPEC not decoded correctly - #3", false, characteristicsBase
                .fspecDataAtIndex(5));
        assertEquals("FSPEC not decoded correctly - #4", false, characteristicsBase
                .fspecDataAtIndex(4));
        assertEquals("FSPEC not decoded correctly - #5", true, characteristicsBase
                .fspecDataAtIndex(3));
        assertEquals("FSPEC not decoded correctly - #6", true, characteristicsBase
                .fspecDataAtIndex(2));
        assertEquals("FSPEC not decoded correctly - #7", false, characteristicsBase
                .fspecDataAtIndex(1));
        assertEquals("FSPEC not decoded correctly - #8", false, characteristicsBase
                .fspecDataAtIndex(15));
    }

    @Override
    @Test
    public void the_decode_method_should_increment_offset_after_data_decoding() {
        //arrange
        int offset = 0;
        Cat004AircraftCharacteristicsBase characteristicsBase = new
                Cat004AircraftCharacteristicsBase();

        //act
        int result = characteristicsBase.decode(input, offset, input.length);

        //assert
        assertEquals("Offset not incremented correctly after decoding of data", input.length,
                result);
    }

    @Override
    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        int offset = 0;
        Cat004AircraftCharacteristicsBase characteristicsBase = new
                Cat004AircraftCharacteristicsBase();

        //act
        characteristicsBase.decode(input, offset, input.length);

        //assert
        assertEquals("Subfield#5 not decoded correctly", 1, characteristicsBase.getSubfield5()
                .getTime());
        assertEquals("Subfield#6 not decoded correctly", 1, characteristicsBase.getSubfield6()
                .getDistanceToThreshhold());
    }
}
