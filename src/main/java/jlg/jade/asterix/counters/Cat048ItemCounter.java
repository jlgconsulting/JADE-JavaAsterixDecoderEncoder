/**
 * Created by Dan Geabunea on 8/3/2016.
 */

package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.cat048.Cat048Record;
import jlg.jade.common.DebugMessageSource;

public class Cat048ItemCounter extends DebugMessageSource implements AsterixItemCounter {
    private int nbRecords;
    private int nbOfInvalidRecords;

    private int item010Present;
    private int item010Invalid;
    private int item140Present;
    private int item140Invalid;
    private int item020Present;
    private int item020Invalid;
    private int item040Present;
    private int item040Invalid;
    private int item070Present;
    private int item070Invalid;
    private int item090Present;
    private int item090Invalid;
    private int item130Present;
    private int item130Invalid;

    private int item220Present;
    private int item220Invalid;
    private int item240Present;
    private int item240Invalid;
    private int item250Present;
    private int item250Invalid;
    private int item161Present;
    private int item161Invalid;
    private int item042Present;
    private int item042Invalid;
    private int item200Present;
    private int item200Invalid;
    private int item170Present;
    private int item170Invalid;

    private int item210Present;
    private int item210Invalid;
    private int item030Present;
    private int item030Invalid;
    private int item080Present;
    private int item080Invalid;
    private int item100Present;
    private int item100Invalid;
    private int item110Present;
    private int item110Invalid;
    private int item120Present;
    private int item120Invalid;
    private int item230Present;
    private int item230Invalid;

    private int item260Present;
    private int item260Invalid;
    private int item055Present;
    private int item055Invalid;
    private int item050Present;
    private int item050Invalid;
    private int item065Present;
    private int item065Invalid;
    private int item060Present;
    private int item060Invalid;
    private int itemSpPresent;
    private int item0SpInvalid;
    private int itemRePresent;
    private int item0ReInvalid;

    /**
     * Increments counter values with the ones received from a new data block
     *
     * @param asterixDataBlock represents an Asterix data block with has Cat 048 data
     */
    @Override
    public void increment(AsterixDataBlock asterixDataBlock) {
        for (AsterixRecord record : asterixDataBlock.getRecords()) {
            if (record.getCat048Record() != null) {
                increment(record.getCat048Record());
            }
        }
    }

    /**
     * Increments the existing counter with values from the Cat 048 record
     *
     * @param record represents a new Asterix record
     */
    public void increment(Cat048Record record) {
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

        if (record.getItem140() != null) {
            this.item140Present += 1;
            if (!record.getItem140().isValid()) {
                this.item140Invalid += 1;
            }
        }

        if (record.getItem020() != null) {
            this.item020Present += 1;
            if (!record.getItem020().isValid()) {
                this.item020Invalid += 1;
            }
        }

        if (record.getItem040() != null) {
            this.item040Present += 1;
            if (!record.getItem040().isValid()) {
                this.item040Invalid += 1;
            }
        }

        if (record.getItem070() != null) {
            this.item070Present += 1;
            if (!record.getItem070().isValid()) {
                this.item070Invalid += 1;
            }
        }

        if (record.getItem090() != null) {
            this.item090Present += 1;
            if (!record.getItem090().isValid()) {
                this.item090Invalid += 1;
            }
        }

        if (record.getItem130() != null) {
            this.item130Present += 1;
            if (!record.getItem130().isValid()) {
                this.item130Invalid += 1;
            }
        }

        if (record.getItem220() != null) {
            this.item220Present += 1;
            if (!record.getItem220().isValid()) {
                this.item220Invalid += 1;
            }
        }

        if (record.getItem240() != null) {
            this.item240Present += 1;
            if (!record.getItem240().isValid()) {
                this.item240Invalid += 1;
            }
        }

        if (record.getItem250() != null) {
            this.item250Present += 1;
            if (!record.getItem250().isValid()) {
                this.item250Invalid += 1;
            }
        }

        if (record.getItem161() != null) {
            this.item161Present += 1;
            if (!record.getItem161().isValid()) {
                this.item161Invalid += 1;
            }
        }

        if (record.getItem042() != null) {
            this.item042Present += 1;
            if (!record.getItem042().isValid()) {
                this.item042Invalid += 1;
            }
        }

        if (record.getItem200() != null) {
            this.item200Present += 1;
            if (!record.getItem200().isValid()) {
                this.item200Invalid += 1;
            }
        }

        if (record.getItem170() != null) {
            this.item170Present += 1;
            if (!record.getItem170().isValid()) {
                this.item170Invalid += 1;
            }
        }

        if (record.getItem210() != null) {
            this.item210Present += 1;
            if (!record.getItem210().isValid()) {
                this.item210Invalid += 1;
            }
        }

        if (record.getItem030() != null) {
            this.item030Present += 1;
            if (!record.getItem030().isValid()) {
                this.item030Invalid += 1;
            }
        }

        if (record.getItem080() != null) {
            this.item080Present += 1;
            if (!record.getItem080().isValid()) {
                this.item080Invalid += 1;
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

        if (record.getItem230() != null) {
            this.item230Present += 1;
            if (!record.getItem230().isValid()) {
                this.item230Invalid += 1;
            }
        }

        if (record.getItem260() != null) {
            this.item260Present += 1;
            if (!record.getItem260().isValid()) {
                this.item260Invalid += 1;
            }
        }

        if (record.getItem055() != null) {
            this.item055Present += 1;
            if (!record.getItem055().isValid()) {
                this.item055Invalid += 1;
            }
        }

        if (record.getItem050() != null) {
            this.item050Present += 1;
            if (!record.getItem050().isValid()) {
                this.item050Invalid += 1;
            }
        }

        if (record.getItem065() != null) {
            this.item065Present += 1;
            if (!record.getItem065().isValid()) {
                this.item065Invalid += 1;
            }
        }

        if (record.getItem060() != null) {
            this.item060Present += 1;
            if (!record.getItem060().isValid()) {
                this.item060Invalid += 1;
            }
        }

        if (record.getReservedSpecialPurposeField() != null) {
            this.itemSpPresent += 1;
            if (!record.getReservedSpecialPurposeField().isValid()) {
                this.item0SpInvalid += 1;
            }
        }

        if (record.getReservedExpansionField() != null) {
            this.itemRePresent += 1;
            if (!record.getReservedExpansionField().isValid()) {
                this.item0ReInvalid += 1;
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

    public int getItem140Present() {
        return item140Present;
    }

    public int getItem140Invalid() {
        return item140Invalid;
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

    public int getItem070Present() {
        return item070Present;
    }

    public int getItem070Invalid() {
        return item070Invalid;
    }

    public int getItem090Present() {
        return item090Present;
    }

    public int getItem090Invalid() {
        return item090Invalid;
    }

    public int getItem130Present() {
        return item130Present;
    }

    public int getItem130Invalid() {
        return item130Invalid;
    }

    public int getItem220Present() {
        return item220Present;
    }

    public int getItem220Invalid() {
        return item220Invalid;
    }

    public int getItem240Present() {
        return item240Present;
    }

    public int getItem240Invalid() {
        return item240Invalid;
    }

    public int getItem250Present() {
        return item250Present;
    }

    public int getItem250Invalid() {
        return item250Invalid;
    }

    public int getItem161Present() {
        return item161Present;
    }

    public int getItem161Invalid() {
        return item161Invalid;
    }

    public int getItem042Present() {
        return item042Present;
    }

    public int getItem042Invalid() {
        return item042Invalid;
    }

    public int getItem200Present() {
        return item200Present;
    }

    public int getItem200Invalid() {
        return item200Invalid;
    }

    public int getItem170Present() {
        return item170Present;
    }

    public int getItem170Invalid() {
        return item170Invalid;
    }

    public int getItem210Present() {
        return item210Present;
    }

    public int getItem210Invalid() {
        return item210Invalid;
    }

    public int getItem030Present() {
        return item030Present;
    }

    public int getItem030Invalid() {
        return item030Invalid;
    }

    public int getItem080Present() {
        return item080Present;
    }

    public int getItem080Invalid() {
        return item080Invalid;
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

    public int getItem230Present() {
        return item230Present;
    }

    public int getItem230Invalid() {
        return item230Invalid;
    }

    public int getItem260Present() {
        return item260Present;
    }

    public int getItem260Invalid() {
        return item260Invalid;
    }

    public int getItem055Present() {
        return item055Present;
    }

    public int getItem055Invalid() {
        return item055Invalid;
    }

    public int getItem050Present() {
        return item050Present;
    }

    public int getItem050Invalid() {
        return item050Invalid;
    }

    public int getItem065Present() {
        return item065Present;
    }

    public int getItem065Invalid() {
        return item065Invalid;
    }

    public int getItem060Present() {
        return item060Present;
    }

    public int getItem060Invalid() {
        return item060Invalid;
    }

    public int getItemSpPresent() {
        return itemSpPresent;
    }

    public int getItem0SpInvalid() {
        return item0SpInvalid;
    }

    public int getItemRePresent() {
        return itemRePresent;
    }

    public int getItem0ReInvalid() {
        return item0ReInvalid;
    }

    private void createPrintMsg() {
        clearDebugMsg();
        appendNewLine();
        appendItemCounterMsg("Asterix Category 048 Counters", "Nb. decoded", "Nb. invalid");
        appendItemCounterMsg("Number of records", nbRecords, nbOfInvalidRecords);
        appendItemCounterMsg("Item 010 - Data Source Identifier", this.item010Present,
                             this.item010Invalid);
        appendItemCounterMsg("Item 140 - Time of Day", this.item140Present,
                             this.item140Invalid);
        appendItemCounterMsg("Item 020 - Target Report Descriptor", this.item020Present,
                             this.item020Invalid);
        appendItemCounterMsg("Item 040 - Measured Position in Slant Polar Coordinates",
                             this.item040Present, this.item040Invalid);
        appendItemCounterMsg("Item 070 - Mode-3/A Code in Octal Representation",
                             this.item070Present, this.item070Invalid);
        appendItemCounterMsg("Item 090 - Flight Level in Binary Representation",
                             this.item090Present, this.item090Invalid);
        appendItemCounterMsg("Item 130 - Radar Plot Characteristics", this.item130Present,
                             this.item130Invalid);
        appendItemCounterMsg("Item 220 - Aircraft Address", this.item220Present,
                             this.item220Invalid);
        appendItemCounterMsg("Item 240 - Aircraft Identification", this.item240Present,
                             this.item240Invalid);
        appendItemCounterMsg("Item 250 - Mode S MB Data", this.item250Present,
                             this.item250Invalid);
        appendItemCounterMsg("Item 161 - Track Number", this.item161Present,
                             this.item161Invalid);
        appendItemCounterMsg("Item 042 - Calculated Position in Cartesian Coordinates",
                             this.item042Present, this.item042Invalid);
        appendItemCounterMsg("Item 200 - Calculated Track Velocity in Polar Representation",
                             this.item200Present, this.item200Invalid);
        appendItemCounterMsg("Item 170 - Track Status", this.item170Present,
                             this.item170Invalid);
        appendItemCounterMsg("Item 210 - Track Quality", this.item210Present,
                             this.item210Invalid);
        appendItemCounterMsg("Item 030 - Warning/Error Conditions", this.item030Present,
                             this.item030Invalid);
        appendItemCounterMsg("Item 080 - Mode-3/A Code Confidence Indicator",
                             this.item080Present, this.item080Invalid);
        appendItemCounterMsg("Item 100 - Mode-C Code and Confidence Indicator",
                             this.item100Present, this.item100Invalid);
        appendItemCounterMsg("Item 110 - Height Measured by 3D Radar", this.item110Present,
                             this.item110Invalid);
        appendItemCounterMsg("Item 120 - Radial Doppler Speed", this.item120Present,
                             this.item120Invalid);
        appendItemCounterMsg("Item 230 - Communications / ACAS Capability and Flight Status",
                             this.item230Present, this.item230Invalid);
        appendItemCounterMsg("Item 260 - ACAS Resolution Advisory Report", this.item260Present,
                             this.item260Invalid);
        appendItemCounterMsg("Item 055 - Mode-1 Code in Octal Representation",
                             this.item055Present, this.item055Invalid);
        appendItemCounterMsg("Item 050 - Mode-2 Code in Octal Representation",
                             this.item050Present, this.item050Invalid);
        appendItemCounterMsg("Item 065 - Mode-1 Code Confidence Indicator", this.item065Present,
                             this.item065Invalid);
        appendItemCounterMsg("Item 060 - Mode-2 Code Confidence Indicator", this.item060Present,
                             this.item060Invalid);
        appendItemCounterMsg("SP", this.itemSpPresent, this.item0SpInvalid);
        appendItemCounterMsg("RE", this.itemRePresent, this.item0ReInvalid);
    }
}