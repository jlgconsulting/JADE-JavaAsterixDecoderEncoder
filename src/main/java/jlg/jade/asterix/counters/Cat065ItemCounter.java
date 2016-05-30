/* 
* Created by dan-geabunea on 5/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.cat065.Cat065Record;
import jlg.jade.common.DebugMessageSource;

/**
 * Counter class for Cat065
 */
public class Cat065ItemCounter extends DebugMessageSource implements AsterixItemCounter {
    private int nbRecords = 0;
    private int nbOfInvalidRecords = 0;

    private int item010Present = 0;
    private int item010Invalid = 0;
    private int item000Present = 0;
    private int item000Invalid = 0;
    private int item015Present = 0;
    private int item015Invalid = 0;
    private int item030Present = 0;
    private int item030Invalid = 0;
    private int item020Present = 0;
    private int item020Invalid = 0;
    private int item040Present = 0;
    private int item040Invalid = 0;
    private int item050Present = 0;
    private int item050Invalid = 0;
    private int itemRePresent = 0;
    private int itemReInvalid = 0;
    private int itemSpPresent = 0;
    private int itemSpInvalid = 0;


    /**
     * Increments counter values with the the ones received from a new data block
     *
     * @param asterixDataBlock An Asterix data block that has Cat 065 data
     */
    public void increment(AsterixDataBlock asterixDataBlock) {
        for (AsterixRecord record : asterixDataBlock.getRecords()) {
            if (record.getCat065Record() != null) {
                increment(record.getCat065Record());
            }
        }
    }

    /**
     * Adds the current counter values with the new counter values
     *
     * @param record a new Asterix record
     */
    private void increment(Cat065Record record) {
        clearDebugMsg();
        appendNewLine();
        appendNewLine();
        appendItemCounterMsg("Asterix Category 062 Counters", "Nb. decoded","Nb. invalid");

        this.nbRecords++;
        if (!record.isValid()) {
            this.nbOfInvalidRecords++;
        }
        appendItemCounterMsg("Number of records", nbRecords, nbOfInvalidRecords);

        if (record.getItem010() != null) {
            this.item010Present = this.getItem010Present() + 1;
            if (!record.getItem010().isValid()) {
                this.item010Invalid = this.getItem010Invalid() + 1;
            }
            appendItemCounterMsg("Item 010 - Data source identifier", getItem010Present(), getItem010Invalid());
        }

        if (record.getItem000() != null) {
            this.item000Present = this.getItem000Present() + 1;
            if (!record.getItem000().isValid()) {
                this.item000Invalid = this.getItem000Invalid() + 1;
            }
            appendItemCounterMsg("Item 000 - Message Type", getItem000Present(), getItem000Invalid());
        }

        if (record.getItem015() != null) {
            this.item015Present = this.getItem015Present() + 1;
            if (!record.getItem015().isValid()) {
                this.item015Invalid = this.getItem015Invalid() + 1;
            }
            appendItemCounterMsg("Item 015 - Service Identification", getItem015Present(), getItem015Invalid());
        }

        if (record.getItem030() != null) {
            this.item030Present = this.getItem030Present() + 1;
            if (!record.getItem030().isValid()) {
                this.item030Invalid = this.getItem030Invalid() + 1;
            }
            appendItemCounterMsg("Item 030 - Time of Message", getItem030Present(), getItem030Invalid());
        }

        if (record.getItem020() != null) {
            this.item020Present = this.getItem020Present() + 1;
            if (!record.getItem020().isValid()) {
                this.item020Invalid = this.getItem020Invalid() + 1;
            }
            appendItemCounterMsg("Item 020 - Batch Number", getItem020Present(), getItem020Invalid());
        }

        if (record.getItem040() != null) {
            this.item040Present = this.getItem040Present() + 1;
            if (!record.getItem040().isValid()) {
                this.item040Invalid = this.getItem040Invalid() + 1;
            }
            appendItemCounterMsg("Item 040 - SDPS Config and Status", getItem040Present(), getItem040Invalid());
        }

        if (record.getItem050() != null) {
            this.item050Present = this.getItem050Present() + 1;
            if (!record.getItem050().isValid()) {
                this.item050Invalid = this.getItem050Invalid() + 1;
            }
            appendItemCounterMsg("Item 050 - Service Status", getItem050Present(), getItem050Invalid());
        }

        if (record.getReservedExpansionField() != null) {
            this.itemRePresent = this.getItemRePresent() + 1;
            if (!record.getReservedExpansionField().isValid()) {
                this.itemReInvalid = this.getItemReInvalid() + 1;
            }
            appendItemCounterMsg("RE", getItemRePresent(), getItemReInvalid());
        }

        if (record.getSpecialPurposeField() != null) {
            this.itemSpPresent = this.getItemSpPresent() + 1;
            if (!record.getSpecialPurposeField().isValid()) {
                this.itemSpInvalid = this.getItemSpInvalid() + 1;
            }
            appendItemCounterMsg("SP", getItemSpPresent(), getItemSpInvalid());
        }
    }

    public int getItem010Present() {
        return item010Present;
    }

    public int getItem010Invalid() {
        return item010Invalid;
    }

    public int getItem000Present() {
        return item000Present;
    }

    public int getItem000Invalid() {
        return item000Invalid;
    }

    public int getItem015Present() {
        return item015Present;
    }

    public int getItem015Invalid() {
        return item015Invalid;
    }

    public int getItem030Present() {
        return item030Present;
    }

    public int getItem030Invalid() {
        return item030Invalid;
    }

    public int getItem020Present() {
        return item020Present;
    }

    public int getItem020Invalid() {
        return item020Invalid;
    }

    public int getItem040Present() {
        return item040Present;
    }

    public int getItem040Invalid() {
        return item040Invalid;
    }

    public int getItem050Present() {
        return item050Present;
    }

    public int getItem050Invalid() {
        return item050Invalid;
    }

    public int getItemRePresent() {
        return itemRePresent;
    }

    public int getItemReInvalid() {
        return itemReInvalid;
    }

    public int getItemSpPresent() {
        return itemSpPresent;
    }

    public int getItemSpInvalid() {
        return itemSpInvalid;
    }
}
