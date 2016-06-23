package jlg.jade.asterix.cat004.item170_171;

import jlg.jade.asterix.AsterixTimeData;

/**
 * Cat 004 - Item 170/171 - Subfield 5 - Time to treshold
 * Time to runway threshold for approaching aircraft in a
 * RIMCAS
 *
 * @implSpec Time to Threshold expressed in Two’s Complement
 * @implSpec Unit of measure is 1/128 sec
 */
public class Cat004AircraftCharacteristicsSubfield5 extends AsterixTimeData {
    @Override
    protected String setDisplayName() {
        return "Subfield5 - Time to Treshlod RIMCAS";
    }
}
