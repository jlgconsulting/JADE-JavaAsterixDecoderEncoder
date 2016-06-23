package jlg.jade.test.asterix.cat004.item170_171;


import jlg.jade.asterix.cat004.Cat004AircraftCharacteristicsSubfield3;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield3Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield3>
{
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 10;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield3 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield3();
    }
}
