/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.Cat004AircraftCharacteristicsSubfield9;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield9Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield9>
{
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 4;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield9 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield9();
    }
}
