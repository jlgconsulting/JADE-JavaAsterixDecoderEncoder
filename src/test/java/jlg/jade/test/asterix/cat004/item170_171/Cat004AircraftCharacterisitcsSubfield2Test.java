package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.Cat004AircraftCharacterisitcsSubfield2;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacterisitcsSubfield2Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacterisitcsSubfield2> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004AircraftCharacterisitcsSubfield2 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacterisitcsSubfield2();
    }
}
