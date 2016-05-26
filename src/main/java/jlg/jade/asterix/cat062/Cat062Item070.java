/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixTimeData;

/**
 * Cat 062 Item 070 - Time of track information - Mandatory
 * Absolute time stamping of the information provided in the track message, in the form of elapsed time since last midnight,
 * expressed as UTC.
 * Unit of measure is 1/128 sec
 */
public class Cat062Item070 extends AsterixTimeData {
    @Override
    protected String setDisplayName() {
        return "Cat062Item070 - Time of Track";
    }
}
