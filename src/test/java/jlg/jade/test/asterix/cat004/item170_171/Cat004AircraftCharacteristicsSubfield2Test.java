package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.item170_171.Cat004AircraftCharacteristicsSubfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield2Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield2 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield2();
    }
}
