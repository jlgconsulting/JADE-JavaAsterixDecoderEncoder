package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.Cat004AircraftCharacteristicsSubfield6;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cat004AircraftCharacteristicsSubfield6Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield6> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield6 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield6();
    }

    @Test
    public void the_decode_method_should_correctly_decode_data() {
        //arrange
        byte[] input = {1,2};
        int offset = 0;
        Cat004AircraftCharacteristicsSubfield6 subfield6 = new
                Cat004AircraftCharacteristicsSubfield6();

        //act
        subfield6.decode(input, offset, input.length);

        //assert
        assertEquals("Item not decoded correctly", 258, subfield6.getDistanceToThreshhold());
    }
}
