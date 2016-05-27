/*
* Created by dan-geabunea on 5/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/

package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;

public interface AsterixItemCounter {
    void increment(AsterixDataBlock asterixDataBlock);
}
