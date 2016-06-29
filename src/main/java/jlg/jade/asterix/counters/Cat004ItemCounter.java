/**
 * Created by Dan Geabunea on 6/29/2016.
 */

package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.cat004.Cat004MessageTypes;
import jlg.jade.asterix.cat004.Cat004Record;
import jlg.jade.common.DebugMessageSource;

/**
 * Counter class for Cat004
 */
public class Cat004ItemCounter extends DebugMessageSource implements AsterixItemCounter {
    private int nbRecords = 0;
    private int nbOfInvalidRecords = 0;

    private int item010Present = 0;
    private int item010Invalid = 0;

    private int item000Present = 0;
    private int item000Invalid = 0;
    private int nbStcaMessages = 0;
    private int nbApwMessages = 0;
    private int nbMsawMessages = 0;
    private int nbEocMessages = 0;

    private int item015Present = 0;
    private int item015Invalid = 0;

    private int item020Present = 0;
    private int item020Invalid = 0;

    private int item040Present = 0;
    private int item040Invalid = 0;

    private int item045Present = 0;
    private int item045Invalid = 0;

    private int item060Present = 0;
    private int item060Invalid = 0;

    private int item030Present = 0;
    private int item030Invalid = 0;

    private int item170Present = 0;
    private int item170Invalid = 0;

    private int item120Present = 0;
    private int item120Invalid = 0;

    private int item070Present = 0;
    private int item070Invalid = 0;

    private int item076Present = 0;
    private int item076Invalid = 0;

    private int item074Present = 0;
    private int item074Invalid = 0;

    private int item075Present = 0;
    private int item075Invalid = 0;

    private int item100Present = 0;
    private int item100Invalid = 0;

    private int item035Present = 0;
    private int item035Invalid = 0;

    private int item171Present = 0;
    private int item171Invalid = 0;

    private int item110Present = 0;
    private int item110Invalid = 0;

    private int itemRePresent = 0;
    private int itemReInvalid = 0;
    private int itemSpPresent = 0;
    private int itemSpInvalid = 0;

    /**
     * Increments counter values with the the ones received from a new data block
     *
     * @param asterixDataBlock An Asterix data block that has Cat 004 data
     */
    @Override
    public void increment(AsterixDataBlock asterixDataBlock) {
        for (AsterixRecord record : asterixDataBlock.getRecords()) {
            if (record.getCategory() == 4) {
                increment(record.getCat004Record());
            }
        }
    }


    /**
     * Adds the current counter values with the new counter values
     *
     * @param record a new Asterix record
     */
    private void increment(Cat004Record record) {
        clearDebugMsg();
        appendNewLine();
        appendNewLine();
        appendItemCounterMsg("Asterix Category 004 Counters", "Nb. decoded", "Nb. invalid");

        this.nbRecords = this.getNbRecords() + 1;
        if (!record.isValid()) {
            this.nbOfInvalidRecords = this.getNbOfInvalidRecords() + 1;
        }
        appendItemCounterMsg("Number of records", getNbRecords(), getNbOfInvalidRecords());

        //increment counters for item 010
        if (record.getItem010() != null) {
            this.item010Present = this.item010Present + 1;
            if (!record.getItem010().isValid()) {
                this.item010Invalid = this.item010Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 010 - Data source identifier",
                    item010Present,
                    item010Invalid);
        }

        //increment counters for item 000
        if (record.getItem000() != null) {
            this.item000Present = this.item000Present + 1;
            if (!record.getItem000().isValid()) {
                this.item000Invalid = this.item000Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 000 - Message Type",
                    item000Present,
                    item000Invalid);

            switch (record.getItem000().getMessageType()) {
                case (Cat004MessageTypes.STCA):
                    nbStcaMessages++;
                    break;
                case (Cat004MessageTypes.APW):
                    nbApwMessages++;
                    break;

                case (Cat004MessageTypes.MSAW):
                    nbMsawMessages++;
                    break;

                case (Cat004MessageTypes.EOC):
                    nbEocMessages++;
                    break;

                default: {
                    break;
                }
            }
            appendItemCounterMsg("  - STCA", nbStcaMessages, 0);
            appendItemCounterMsg("  - APW", nbApwMessages, 0);
            appendItemCounterMsg("  - MSAW", nbMsawMessages, 0);
            appendItemCounterMsg("  - EOC", nbEocMessages, 0);
        }

        //increment counters for item 015
        if (record.getItem015() != null) {
            this.item015Present = this.item015Present + 1;
            if (!record.getItem015().isValid()) {
                this.item015Invalid = this.item015Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 015 - SDPS Identifier (Skipped)",
                    item015Present,
                    item015Invalid);
        }

        //increment counters for item 020
        if (record.getItem020() != null) {
            this.item020Present = this.item020Present + 1;
            if (!record.getItem020().isValid()) {
                this.item020Invalid = this.item020Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 020 - Time of Message",
                    item020Present,
                    item020Invalid);
        }

        //increment counters for item 040
        if (record.getItem040() != null) {
            this.item040Present = this.item040Present + 1;
            if (!record.getItem040().isValid()) {
                this.item040Invalid = this.item040Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 040 - Alert Identifier",
                    item040Present,
                    item040Invalid);
        }

        //increment counters for item 045
        if (record.getItem045() != null) {
            this.item045Present = this.item045Present + 1;
            if (!record.getItem045().isValid()) {
                this.item045Invalid = this.item045Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 045 - Alert Status",
                    item045Present,
                    item045Invalid);
        }

        //increment counters for item 060
        if (record.getItem060() != null) {
            this.item060Present = this.item060Present + 1;
            if (!record.getItem060().isValid()) {
                this.item060Invalid = this.item060Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 060 - Safety Net Function and Status (Skipped)",
                    item060Present,
                    item060Invalid);
        }

        //increment counters for item 030
        if (record.getItem030() != null) {
            this.item030Present = this.item030Present + 1;
            if (!record.getItem030().isValid()) {
                this.item030Invalid = this.item030Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 030 - Track Number 1",
                    item030Present,
                    item030Invalid);
        }

        //increment counters for item 170
        if (record.getItem170() != null) {
            this.item170Present = this.item170Present + 1;
            if (!record.getItem170().isValid()) {
                this.item170Invalid = this.item170Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 170 - Aircraft Characteristics 1",
                    item170Present,
                    item170Invalid);
        }

        //increment counters for item 120
        if (record.getItem120() != null) {
            this.item120Present = this.item120Present + 1;
            if (!record.getItem120().isValid()) {
                this.item120Invalid = this.item120Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 120 - Conflict Characteristics",
                    item120Present,
                    item120Invalid);
        }

        //increment counters for item 070
        if (record.getItem070() != null) {
            this.item070Present = this.item070Present + 1;
            if (!record.getItem070().isValid()) {
                this.item070Invalid = this.item070Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 070 - Conflict Timing and Separation",
                    item070Present,
                    item070Invalid);
        }

        //increment counters for item 076
        if (record.getItem076() != null) {
            this.item076Present = this.item076Present + 1;
            if (!record.getItem076().isValid()) {
                this.item076Invalid = this.item076Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 076 - Vertical Deviation",
                    item076Present,
                    item076Invalid);
        }

        //increment counters for item 074
        if (record.getItem074() != null) {
            this.item074Present = this.item074Present + 1;
            if (!record.getItem074().isValid()) {
                this.item074Invalid = this.item074Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 074 - Longitudinal Deviation",
                    item074Present,
                    item074Invalid);
        }

        //increment counters for item 075
        if (record.getItem075() != null) {
            this.item075Present = this.item075Present + 1;
            if (!record.getItem075().isValid()) {
                this.item075Invalid = this.item075Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 075 - Transversal Distance Deviation",
                    item075Present,
                    item075Invalid);
        }

        //increment counters for item 100
        if (record.getItem100() != null) {
            this.item100Present = this.item100Present + 1;
            if (!record.getItem100().isValid()) {
                this.item100Invalid = this.item100Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 100 - Area Definitions",
                    item100Present,
                    item100Invalid);
        }

        //increment counters for item 035
        if (record.getItem035() != null) {
            this.item035Present = this.item035Present + 1;
            if (!record.getItem035().isValid()) {
                this.item035Invalid = this.item035Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 035 - Track Number 2",
                    item035Present,
                    item035Invalid);
        }

        //increment counters for item 171
        if (record.getItem171() != null) {
            this.item171Present = this.item171Present + 1;
            if (!record.getItem171().isValid()) {
                this.item171Invalid = this.item171Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 171 - Aircraft Characteristics 2",
                    item171Present,
                    item171Invalid);
        }

        //increment counters for item 110
        if (record.getItem110() != null) {
            this.item110Present = this.item110Present + 1;
            if (!record.getItem110().isValid()) {
                this.item110Invalid = this.item110Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 110 - FDPS Control Identifier (Skipped)",
                    item110Present,
                    item110Invalid);
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

    public int getNbRecords() {
        return nbRecords;
    }

    public int getNbOfInvalidRecords() {
        return nbOfInvalidRecords;
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

    public int getItem045Present() {
        return item045Present;
    }

    public int getItem045Invalid() {
        return item045Invalid;
    }

    public int getItem060Present() {
        return item060Present;
    }

    public int getItem060Invalid() {
        return item060Invalid;
    }

    public int getItem030Present() {
        return item030Present;
    }

    public int getItem030Invalid() {
        return item030Invalid;
    }

    public int getItem170Present() {
        return item170Present;
    }

    public int getItem170Invalid() {
        return item170Invalid;
    }

    public int getItem120Present() {
        return item120Present;
    }

    public int getItem120Invalid() {
        return item120Invalid;
    }

    public int getItem070Present() {
        return item070Present;
    }

    public int getItem070Invalid() {
        return item070Invalid;
    }

    public int getItem076Present() {
        return item076Present;
    }

    public int getItem076Invalid() {
        return item076Invalid;
    }

    public int getItem074Present() {
        return item074Present;
    }

    public int getItem074Invalid() {
        return item074Invalid;
    }

    public int getItem075Present() {
        return item075Present;
    }

    public int getItem075Invalid() {
        return item075Invalid;
    }

    public int getItem100Present() {
        return item100Present;
    }

    public int getItem100Invalid() {
        return item100Invalid;
    }

    public int getItem035Present() {
        return item035Present;
    }

    public int getItem035Invalid() {
        return item035Invalid;
    }

    public int getItem171Present() {
        return item171Present;
    }

    public int getItem171Invalid() {
        return item171Invalid;
    }

    public int getItem110Present() {
        return item110Present;
    }

    public int getItem110Invalid() {
        return item110Invalid;
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
