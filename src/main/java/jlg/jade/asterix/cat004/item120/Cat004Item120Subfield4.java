/**
 * Created by Dan Geabunea on 6/24/2016.
 */

package jlg.jade.asterix.cat004.item120;

import jlg.jade.asterix.AsterixTimeData;

/**
 * Cat004 - Item120 - Subfield4 - Conflict Duration
 * The duration of the conflict is the elapsed time since the
 * declaration of the conflict.
 *
 * @implSpec Unit of measure is 1/128 sec
 */
public class Cat004Item120Subfield4 extends AsterixTimeData {
    @Override
    protected String setDisplayName() {
        return "Cat004Item120Subfield4 - Conflict Duration";
    }
}
