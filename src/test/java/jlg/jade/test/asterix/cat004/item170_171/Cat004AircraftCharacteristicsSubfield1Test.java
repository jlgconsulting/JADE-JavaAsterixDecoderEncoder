package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.item170_171.Cat004AircraftCharacteristicsSubfield1;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield1Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield1> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 7;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield1 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield1();
    }
}
