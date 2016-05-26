/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixDataSourceIdentifierData;

/**
 * Cat-062 Item 010 - Data Source Identifier - Mandatory
 * Identification of the system sending the data (SAC-SIC)
 */
public class Cat062Item010 extends AsterixDataSourceIdentifierData {
    @Override
    protected String setDisplayName() {
        return "Cat062Item010 - Data Source Identifier";
    }
}
