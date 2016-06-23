/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.Cat004AircraftCharacteristicsSubfield10;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield10Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield10> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield10 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield10();
    }
}
