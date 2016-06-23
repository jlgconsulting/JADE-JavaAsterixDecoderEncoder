package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.item170_171.Cat004AircraftCharacteristicsSubfield4;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield4Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield4>
{
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 8;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield4 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield4();
    }
}
