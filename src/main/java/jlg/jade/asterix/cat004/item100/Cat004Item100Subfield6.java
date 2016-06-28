/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004.item100;

/**
 * Cat004 Item100 Subfield 6 - Gate Desingator
 * Gate Designator (in 7 characters) of the approaching aircraft in a
 * RIMCA
 *
 * @implSpec The gate designator is always left adjusted. If needed, the remaining
 * characters are filled with space character
 */
public class Cat004Item100Subfield6 extends Cat004Item100RimcaDesignatorData {
    @Override
    protected String setDisplayName() {
        return "Cat004Item100Subfield6 - Gate Designator";
    }
}
