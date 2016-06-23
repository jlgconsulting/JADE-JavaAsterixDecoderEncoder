/**
 * Created by Dan Geabunea on 6/23/2016.
 */

package jlg.jade.test.asterix.cat004.item170_171;

import jlg.jade.asterix.cat004.Cat004AircraftCharacteristicsSubfield8;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;

public class Cat004AircraftCharacteristicsSubfield8Test extends
        MandatoryFixedLengthAsterixTests<Cat004AircraftCharacteristicsSubfield8>
{
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 6;
    }

    @Override
    protected Cat004AircraftCharacteristicsSubfield8 setFixedLengthAsterixDataInstance() {
        return new Cat004AircraftCharacteristicsSubfield8();
    }
}
