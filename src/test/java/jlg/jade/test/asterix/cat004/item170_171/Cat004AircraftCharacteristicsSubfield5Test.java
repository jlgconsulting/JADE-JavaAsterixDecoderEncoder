package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.item170_171.Cat004AircraftCharacteristicsSubfield5;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield5Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield5> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 3;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield5 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield5();
    }

    /**
     * Decoding is tested in base class
     */
}
