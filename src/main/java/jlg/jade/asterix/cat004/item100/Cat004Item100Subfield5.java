/**
 * Created by Dan Geabunea on 6/28/2016.
 */

package jlg.jade.asterix.cat004.item100;

/**
 * Cat004 Item100 Subfield 5 - Stop Bar Designator
 * Designator of Stop-Bar Involved in a RIMCA
 *
 * @implSpec The stop-bar designator is always left adjusted. If needed, the
 * remaining characters are filled with space characters
 */
public class Cat004Item100Subfield5 extends Cat004Item100RimcaDesignatorData {
    @Override
    protected String setDisplayName() {
        return "Cat004Item100Subfield5 - Stop Bar Designator";
    }
}
