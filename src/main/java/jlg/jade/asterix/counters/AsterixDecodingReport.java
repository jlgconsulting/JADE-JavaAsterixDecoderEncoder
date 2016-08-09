/**
 * Created by Dan Geabunea on 8/3/2016.
 */

package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;

public interface AsterixDecodingReport {
    void update(AsterixDataBlock adb);

    Cat004ItemCounter getCat004ItemCounter();

    Cat034ItemCounter getCat034ItemCounter();

    Cat048ItemCounter getCat048ItemCounter();

    Cat062ItemCounter getCat062ItemCounter();

    Cat065ItemCounter getCat065ItemCounter();

    Cat150ItemCounter getCat150ItemCounter();

    String toDebugString();
}
