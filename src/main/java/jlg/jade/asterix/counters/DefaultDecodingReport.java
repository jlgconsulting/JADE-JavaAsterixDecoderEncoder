/**
 * Created by Dan Geabunea on 8/3/2016.
 */

package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;

public class DefaultDecodingReport implements AsterixDecodingReport {
    private boolean isCat048CounterUpdated;
    private boolean isCat034CounterUpdated;
    private boolean isCat004CounterUpdated;
    private boolean isCat062CounterUpdated;
    private boolean isCat065CounterUpdated;
    private boolean isCat150CounterUpdated;

    private Cat004ItemCounter cat004ItemCounter;
    private Cat034ItemCounter cat034ItemCounter;
    private Cat048ItemCounter cat048ItemCounter;
    private Cat062ItemCounter cat062ItemCounter;
    private Cat065ItemCounter cat065ItemCounter;
    private Cat150ItemCounter cat150ItemCounter;

    public DefaultDecodingReport(){
        cat004ItemCounter = new Cat004ItemCounter();
        cat034ItemCounter = new Cat034ItemCounter();
        cat048ItemCounter = new Cat048ItemCounter();
        cat062ItemCounter = new Cat062ItemCounter();
        cat065ItemCounter = new Cat065ItemCounter();
        cat150ItemCounter = new Cat150ItemCounter();
    }

    @Override
    public void update(AsterixDataBlock adb) {
        switch (adb.getCategory()) {
            case 4:{
                cat004ItemCounter.increment(adb);
                isCat004CounterUpdated = true;
                break;
            }
            case 34:{
                cat034ItemCounter.increment(adb);
                isCat034CounterUpdated = true;
                break;
            }
            case 48:{
                cat048ItemCounter.increment(adb);
                isCat048CounterUpdated = true;
            }
            case 62:{
                cat062ItemCounter.increment(adb);
                isCat062CounterUpdated = true;
                break;
            }
            case 65:{
                cat065ItemCounter.increment(adb);
                isCat065CounterUpdated = true;
                break;
            }
            case 150:{
                cat150ItemCounter.increment(adb);
                isCat150CounterUpdated = true;
                break;
            }
        }
    }

    @Override
    public Cat004ItemCounter getCat004ItemCounter() {
        return cat004ItemCounter;
    }

    @Override
    public Cat034ItemCounter getCat034ItemCounter() {
        return cat034ItemCounter;
    }

    @Override
    public Cat062ItemCounter getCat062ItemCounter() {
        return cat062ItemCounter;
    }

    @Override
    public Cat065ItemCounter getCat065ItemCounter() {
        return cat065ItemCounter;
    }

    @Override
    public Cat150ItemCounter getCat150ItemCounter() {
        return cat150ItemCounter;
    }

    @Override
    public String toDebugString(){
        StringBuilder sb = new StringBuilder();
        sb.append("*** ASTERIX DECODING REPORT ***");
        sb.append(System.lineSeparator());

        if(isCat004CounterUpdated) {
            sb.append(cat004ItemCounter.getDebugString());
        }
        if(isCat034CounterUpdated) {
            sb.append(cat034ItemCounter.getDebugString());
        }
        if(isCat048CounterUpdated) {
            sb.append(cat048ItemCounter.getDebugString());
        }
        if(isCat062CounterUpdated) {
            sb.append(cat062ItemCounter.getDebugString());
        }
        if(isCat065CounterUpdated) {
            sb.append(cat065ItemCounter.getDebugString());
        }
        if(isCat150CounterUpdated) {
            sb.append(cat150ItemCounter.getDebugString());
        }

        sb.append(System.lineSeparator());
        sb.append("*** END OF REPORT ***");
        sb.append(System.lineSeparator());

        return sb.toString();
    }

}
