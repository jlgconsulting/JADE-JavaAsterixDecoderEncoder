/**
 * Created by alexandru on 7/12/16.
 */
package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.cat034.Cat034Record;
import jlg.jade.common.DebugMessageSource;

public class Cat034ItemCounter extends DebugMessageSource implements AsterixItemCounter {
    private int nbRecords;
    private int nbOfInvalidRecords;

    private int item010Present;
    private int item010Invalid;
    private int item000Present;
    private int item000Invalid;
    private int item030Present;
    private int item030Invalid;
    private int item020Present;
    private int item020Invalid;
    private int item041Present;
    private int item041Invalid;
    private int item050Present;
    private int item050Invalid;
    private int item060Present;
    private int item060Invalid;
    private int item070Present;
    private int item070Invalid;
    private int item100Present;
    private int item100Invalid;
    private int item110Present;
    private int item110Invalid;
    private int item120Present;
    private int item120Invalid;
    private int item090Present;
    private int item090Invalid;
    private int itemRePresent;
    private int itemReInvalid;
    private int itemSpPresent;
    private int itemSpInvalid;

    /**
     * Increments counter values with the ones received from a new data block
     *
     * @param asterixDataBlock represents an Asterix data block with has Cat 034 data
     */
    @Override
    public void increment(AsterixDataBlock asterixDataBlock) {
        for (AsterixRecord record : asterixDataBlock.getRecords()) {
            if (record.getCat034Record() != null) {
                increment(record.getCat034Record());
            }
        }
    }

    /**
     * Increments the existing counter with values from the Cat 034 record
     *
     * @param record represents a new Asterix record
     */
    private void increment(Cat034Record record) {
        this.nbRecords++;
        if (!record.isValid()) {
            this.nbOfInvalidRecords++;
        }

        if (record.getItem010() != null) {
            this.item010Present += 1;
            if (!record.getItem010().isValid()) {
                this.item010Invalid += 1;
            }
        }

        if (record.getItem000() != null) {
            this.item000Present += 1;
            if (!record.getItem000().isValid()) {
                this.item000Invalid += 1;
            }
        }

        if (record.getItem030() != null) {
            this.item030Present += 1;
            if (!record.getItem030().isValid()) {
                this.item030Invalid += 1;
            }
        }

        if (record.getItem020() != null) {
            this.item020Present += 1;
            if (!record.getItem020().isValid()) {
                this.item020Invalid += 1;
            }
        }

        if (record.getItem041() != null) {
            this.item041Present += 1;
            if (!record.getItem041().isValid()) {
                this.item041Invalid += 1;
            }
        }

        if (record.getItem050() != null) {
            this.item050Present += 1;
            if (!record.getItem050().isValid()) {
                this.item050Invalid += 1;
            }
        }

        if (record.getItem060() != null) {
            this.item060Present += 1;
            if (!record.getItem060().isValid()) {
                this.item060Invalid += 1;
            }
        }

        if (record.getItem070() != null) {
            this.item070Present += 1;
            if (!record.getItem070().isValid()) {
                this.item070Invalid += 1;
            }
        }

        if (record.getItem100() != null) {
            this.item100Present += 1;
            if (!record.getItem100().isValid()) {
                this.item100Invalid += 1;
            }
        }

        if (record.getItem110() != null) {
            this.item110Present += 1;
            if (!record.getItem110().isValid()) {
                this.item110Invalid += 1;
            }
        }

        if (record.getItem120() != null) {
            this.item120Present += 1;
            if (!record.getItem120().isValid()) {
                this.item120Invalid += 1;
            }
        }

        if (record.getItem090() != null) {
            this.item090Present += 1;
            if (!record.getItem090().isValid()) {
                this.item090Invalid += 1;
            }
        }

        if (record.getReservedExpansionField() != null) {
            this.itemRePresent += 1;
            if (!record.getReservedExpansionField().isValid()) {
                this.itemReInvalid += 1;
            }
        }

        if (record.getReservedSpecialPurposeField() != null) {
            this.itemSpPresent += 1;
            if (!record.getReservedSpecialPurposeField().isValid()) {
                this.itemSpInvalid += 1;
            }
        }

        createPrintMsg();
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

    public int getItem041Present() {
        return item041Present;
    }

    public int getItem041Invalid() {
        return item041Invalid;
    }

    public int getItem050Present() {
        return item050Present;
    }

    public int getItem050Invalid() {
        return item050Invalid;
    }

    public int getItem060Present() {
        return item060Present;
    }

    public int getItem060Invalid() {
        return item060Invalid;
    }

    public int getItem070Present() {
        return item070Present;
    }

    public int getItem070Invalid() {
        return item070Invalid;
    }

    public int getItem100Present() {
        return item100Present;
    }

    public int getItem100Invalid() {
        return item100Invalid;
    }

    public int getItem110Present() {
        return item110Present;
    }

    public int getItem110Invalid() {
        return item110Invalid;
    }

    public int getItem120Present() {
        return item120Present;
    }

    public int getItem120Invalid() {
        return item120Invalid;
    }

    public int getItem090Present() {
        return item090Present;
    }

    public int getItem090Invalid() {
        return item090Invalid;
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

    private void createPrintMsg() {
        clearDebugMsg();
        appendNewLine();
        appendItemCounterMsg("Asterix Category 034 Counters", "Nb. decoded", "Nb. invalid");
        appendItemCounterMsg("Number of records", nbRecords, nbOfInvalidRecords);
        appendItemCounterMsg("Item 010 - Data Source Identifier", this.item010Present,
                             this.item010Invalid);
        appendItemCounterMsg("Item 000 - Message Type", this.item000Present,
                             this.item000Invalid);
        appendItemCounterMsg("Item 030 - Time of Day", this.item030Present,
                             this.item030Invalid);
        appendItemCounterMsg("Item 020 - Sector Number", this.item020Present,
                             this.item020Invalid);
        appendItemCounterMsg("Item 041 - Antenna Rotation Speed", this.item041Present,
                             this.item041Invalid);
        appendItemCounterMsg("Item 050 - System Configuration and Status", this.item050Present,
                             this.item050Invalid);
        appendItemCounterMsg("Item 060 - System Processing Mode", this.item060Present,
                             this.item060Invalid);
        appendItemCounterMsg("Item 070 - Message Count Values", this.item070Present,
                             this.item070Invalid);
        appendItemCounterMsg("Item 100 - Generic Polar Window", this.item100Present,
                             this.item100Invalid);
        appendItemCounterMsg("Item 110 - Data Filter", this.item110Present,
                             this.item110Invalid);
        appendItemCounterMsg("Item 120 - 3D-Position Of Data Source", this.item120Present,
                             this.item120Invalid);
        appendItemCounterMsg("Item 090 - Collimation Error", this.item090Present,
                             this.item090Invalid);
        appendItemCounterMsg("RE", this.itemRePresent, this.itemReInvalid);
        appendItemCounterMsg("SP", this.itemSpPresent, this.itemSpInvalid);

    }
}
