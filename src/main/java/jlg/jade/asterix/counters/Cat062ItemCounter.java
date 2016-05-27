/* 
* Created by dan-geabunea on 5/17/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.cat062.Cat062Record;
import jlg.jade.asterix.counters.AsterixItemCounter;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.common.DebugMessageSource;

/**
 * Counter class for Cat062 items and most of subfields.
 */
public class Cat062ItemCounter extends DebugMessageSource implements AsterixItemCounter {
    private int item010Present = 0;
    private int item010Invalid = 0;
    private int item015Present = 0;
    private int item015Invalid = 0;
    private int item070Present = 0;
    private int item070Invalid = 0;
    private int item105Present = 0;
    private int item105Invalid = 0;
    private int item100Present = 0;
    private int item100Invalid = 0;
    private int item185Present = 0;
    private int item185Invalid = 0;
    private int item210Present = 0;
    private int item210Invalid = 0;
    private int item060Present = 0;
    private int item060Invalid = 0;
    private int item245Present = 0;
    private int item245Invalid = 0;

    //380
    private int item380Present = 0;
    private int item380Invalid = 0;
    private int item380Subfield1Present = 0;
    private int item380Subfield1Invalid = 0;
    private int item380Subfield3Present = 0;
    private int item380Subfield3Invalid = 0;
    private int item380Subfield4Present = 0;
    private int item380Subfield4Invalid = 0;
    private int item380Subfield5Present = 0;
    private int item380Subfield5Invalid = 0;
    private int item380Subfield6Present = 0;
    private int item380Subfield6Invalid = 0;
    private int item380Subfield7Present = 0;
    private int item380Subfield7Invalid = 0;
    private int item380Subfield12Present = 0;
    private int item380Subfield12Invalid = 0;
    private int item380Subfield15Present = 0;
    private int item380Subfield15Invalid = 0;
    private int item380Subfield17Present = 0;
    private int item380Subfield17Invalid = 0;
    private int item380Subfield18Present = 0;
    private int item380Subfield18Invalid = 0;
    private int item380Subfield20Present = 0;
    private int item380Subfield20Invalid = 0;
    private int item380Subfield21Present = 0;
    private int item380Subfield21Invalid = 0;
    private int item380Subfield26Present = 0;
    private int item380Subfield26Invalid = 0;
    private int item380Subfield27Present = 0;
    private int item380Subfield27Invalid = 0;
    private int item380Subfield28Present = 0;
    private int item380Subfield28Invalid = 0;

    private int item040Present = 0;
    private int item040Invalid = 0;
    private int item080Present = 0;
    private int item080Invalid = 0;
    private int item290Present = 0;
    private int item290Invalid = 0;
    private int item200Present = 0;
    private int item200Invalid = 0;
    private int item295Present = 0;
    private int item295Invalid = 0;
    private int item136Present = 0;
    private int item136Invalid = 0;
    private int item130Present = 0;
    private int item130Invalid = 0;
    private int item135Present = 0;
    private int item135Invalid = 0;

    //220
    private int item220Present = 0;
    private int item220Invalid = 0;
    private int item220Negative = 0;
    private int item220Positive = 0;
    private int item220Zero = 0;

    //390
    private int item390Present = 0;
    private int item390Invalid = 0;
    private int item390Subfield2Present = 0;
    private int item390Subfield2Invalid = 0;
    private int item390Subfield4Present = 0;
    private int item390Subfield4Invalid = 0;
    private int item390Subfield4TrafficGat = 0;
    private int item390Subfield4TrafficOat = 0;
    private int item390Subfield4TrafficUnk = 0;
    private int item390Subfield4TrafficNa = 0;
    private int item390Subfield4RulesIfr = 0;
    private int item390Subfield4RulesVfr = 0;
    private int item390Subfield4RulesNa = 0;
    private int item390Subfield4RulesCtrlVfr = 0;
    private int item390Subfield4RvsmUnk = 0;
    private int item390Subfield4RvsmApproved = 0;
    private int item390Subfield4RvsmExempt = 0;
    private int item390Subfield4RvsmNotApproved = 0;
    private int item390Subfield5Present = 0;
    private int item390Subfield5Invalid = 0;
    private int item390Subfield6Present = 0;
    private int item390Subfield6Invalid = 0;
    private int item390Subfield6L = 0;
    private int item390Subfield6M = 0;
    private int item390Subfield6H = 0;
    private int item390Subfield6J = 0;
    private int item390Subfield7Present = 0;
    private int item390Subfield7Invalid = 0;
    private int item390Subfield8Present = 0;
    private int item390Subfield8Invalid = 0;
    private int item390Subfield9Present = 0;
    private int item390Subfield9Invalid = 0;
    private int item390Subfield10Present = 0;
    private int item390Subfield10Invalid = 0;
    private int item390Subfield11Present = 0;
    private int item390Subfield11Invalid = 0;
    private int item390Subfield12Present = 0;
    private int item390Subfield12Invalid = 0;
    private int item390Subfield13Present = 0;
    private int item390Subfield13Invalid = 0;
    private int item390Subfield14Present = 0;
    private int item390Subfield14Invalid = 0;
    private int item390Subfield15Present = 0;
    private int item390Subfield15Invalid = 0;
    private int item390Subfield16Present = 0;
    private int item390Subfield16Invalid = 0;

    private int item270Present = 0;
    private int item270Invalid = 0;
    private int item300Present = 0;
    private int item300Invalid = 0;
    private int item110Present = 0;
    private int item110Invalid = 0;
    private int item120Present = 0;
    private int item120Invalid = 0;
    private int item510Present = 0;
    private int item510Invalid = 0;
    private int item500Present = 0;
    private int item500Invalid = 0;
    private int item340Present = 0;
    private int item340Invalid = 0;
    private int itemRePresent = 0;
    private int itemReInvalid = 0;
    private int itemSpPresent = 0;
    private int itemSpInvalid = 0;


    /**
     * Increments counter values with the the ones received from a new data block
     *
     * @param asterixDataBlock An Asterix data block that has Cat 062 data
     */
    public void increment(AsterixDataBlock asterixDataBlock) {
        for (AsterixRecord record : asterixDataBlock.getRecords()) {
            if (record.getCat062Record() != null) {
                increment(record.getCat062Record());
            }
        }
    }

    /**
     * Adds the current counter values with the new counter values
     *
     * @param record a new Asterix record
     */
    private void increment(Cat062Record record) {
        clearDebugMsg();
        appendNewLine();
        appendDebugMsg("Asterix Categoty 062 Counters");
        appendNewLine();

        if (record.getItem010() != null) {
            this.item010Present += 1;
            if (!record.getItem010().isValid()) {
                this.item010Invalid += 1;
            }
            appendItemCounterMsg("Item 010 - Data source identifier [M]", item010Present, item010Invalid);
        }

        if (record.getItem015() != null) {
            this.item015Present += 1;
            if (!record.getItem015().isValid()) {
                this.item015Invalid += 1;
            }
            appendItemCounterMsg("Item 015 - Data Service identification", item015Present, item015Invalid);
        }

        if (record.getItem070() != null) {
            this.item070Present += 1;
            if (!record.getItem070().isValid()) {
                this.item070Invalid += 1;
            }
            appendItemCounterMsg("Item 070 - Service identification [M]", item070Present, item070Invalid);
        }

        if (record.getItem105() != null) {
            this.item105Present += 1;
            if (!record.getItem105().isValid()) {
                this.item105Invalid += 1;
            }
            appendItemCounterMsg("Item 105 - Track position (WSG 84)", item105Present, item105Invalid);
        }

        if (record.getItem100() != null) {
            this.item100Present += 1;
            if (!record.getItem100().isValid()) {
                this.item100Invalid += 1;
            }
            appendItemCounterMsg("Item 100 - Track position (cartesian)", item100Present, item100Invalid);
        }
        if (record.getItem185() != null) {
            this.item185Present += 1;
            if (!record.getItem185().isValid()) {
                this.item185Invalid += 1;
            }
            appendItemCounterMsg("Item 185 - Track velocity (vx, vy)", item185Present, item185Invalid);
        }

        if (record.getItem210() != null) {
            this.item210Present += 1;
            if (!record.getItem210().isValid()) {
                this.item210Invalid += 1;
            }
            appendItemCounterMsg("Item 210 - Acceleration (cartesian)", item210Present, item210Invalid);
        }

        if (record.getItem060() != null) {
            this.item060Present += 1;
            if (!record.getItem060().isValid()) {
                this.item060Invalid += 1;
            }
            appendItemCounterMsg("Item 060 - Mode 3/A", item060Present, item060Invalid);
        }

        if (record.getItem245() != null) {
            this.item245Present += 1;
            if (!record.getItem245().isValid()) {
                this.item245Invalid += 1;
            }
            appendItemCounterMsg("Item 245 - Target identification", item245Present, item245Invalid);
        }

        addCountersForItem380(record);

        if (record.getItem040() != null) {
            this.item040Present += 1;
            if (!record.getItem040().isValid()) {
                this.item040Invalid += 1;
            }
            appendItemCounterMsg("Item 040 - Track number [M]", item040Present, item040Invalid);
        }

        if (record.getItem080() != null) {
            this.item080Present += 1;
            if (!record.getItem080().isValid()) {
                this.item080Invalid += 1;
            }
            appendItemCounterMsg("Item 080 - Track status [M]", item080Present, item080Invalid);
        }

        if (record.getItem290() != null) {
            this.item290Present += 1;
            if (!record.getItem290().isValid()) {
                this.item290Invalid += 1;
            }
            appendItemCounterMsg("Item 290 - Track update ages", item290Present, item290Invalid);
        }

        if (record.getItem200() != null) {
            this.item200Present += 1;
            if (!record.getItem200().isValid()) {
                this.item200Invalid += 1;
            }
            appendItemCounterMsg("Item 200 - Mode of movement", item200Present, item200Invalid);
        }

        if (record.getItem295() != null) {
            this.item295Present += 1;
            if (!record.getItem295().isValid()) {
                this.item295Invalid += 1;
            }
            appendItemCounterMsg("Item 295 - Track data ages", item295Present, item295Invalid);
        }

        if (record.getItem136() != null) {
            this.item136Present += 1;
            if (!record.getItem136().isValid()) {
                this.item136Invalid += 1;
            }
            appendItemCounterMsg("Item 136 - Measured Flight Level", item136Present, item136Invalid);
        }

        if (record.getItem130() != null) {
            this.item130Present += 1;
            if (!record.getItem130().isValid()) {
                this.item130Invalid += 1;
            }
            appendItemCounterMsg("Item 130 - Geometric altitude", item130Present, item130Invalid);
        }

        if (record.getItem135() != null) {
            this.item135Present += 1;
            if (!record.getItem135().isValid()) {
                this.item135Invalid += 1;
            }
            appendItemCounterMsg("Item 135 - Barometric altitude", item135Present, item135Invalid);
        }

        if (record.getItem220() != null) {
            this.item220Present += 1;
            if (!record.getItem220().isValid()) {
                this.item220Invalid += 1;
            }
            appendItemCounterMsg("Item 220 - ROCD", item220Present, item220Invalid);

            if (record.getItem220().getRocd() < 0) {
                this.item220Negative += 1;
            } else if (record.getItem220().getRocd() > 0) {
                this.item220Positive += 1;
            } else {
                this.item220Zero += 1;
            }
            appendItemCounterMsg("  Negative", item220Negative, item220Invalid);
            appendItemCounterMsg("  Zero", item220Zero, item220Invalid);
            appendItemCounterMsg("  Positive", item220Positive, item220Invalid);
        }

        addCountersForItem390(record);

        if (record.getItem270() != null) {
            this.item270Present += 1;
            if (!record.getItem270().isValid()) {
                this.item270Invalid += 1;
            }
            appendItemCounterMsg("Item 270 - Target size and orientation", item270Present, item270Invalid);
        }

        if (record.getItem300() != null) {
            this.item300Present += 1;
            if (!record.getItem300().isValid()) {
                this.item300Invalid += 1;
            }
            appendItemCounterMsg("Item 300 - Vehicle fleet identification", item300Present, item300Invalid);
        }

        if (record.getItem110() != null) {
            this.item110Present += 1;
            if (!record.getItem110().isValid()) {
                this.item110Invalid += 1;
            }
            appendItemCounterMsg("Item 110 - Mode 5", item110Present, item110Invalid);
        }

        if (record.getItem120() != null) {
            this.item120Present += 1;
            if (!record.getItem120().isValid()) {
                this.item120Invalid += 1;
            }
            appendItemCounterMsg("Item 120 - Mode 2", item120Present, item120Invalid);
        }

        if (record.getItem510() != null) {
            this.item510Present += 1;
            if (!record.getItem510().isValid()) {
                this.item510Invalid += 1;
            }
            appendItemCounterMsg("Item 510 - Composed track nb", item510Present, item510Invalid);
        }

        if (record.getItem500() != null) {
            this.item500Present += 1;
            if (!record.getItem500().isValid()) {
                this.item500Invalid += 1;
            }
            appendItemCounterMsg("Item 500 - Estimated accuracies", item500Present, item500Invalid);
        }

        if (record.getItem340() != null) {
            this.item340Present += 1;
            if (!record.getItem340().isValid()) {
                this.item340Invalid += 1;
            }
            appendItemCounterMsg("Item 340 - Measured information", item340Present, item340Invalid);
        }

        if (record.getReservedExpansionField() != null) {
            this.itemRePresent += 1;
            if (!record.getReservedExpansionField().isValid()) {
                this.itemReInvalid += 1;
            }
            appendItemCounterMsg("RE", itemRePresent, itemReInvalid);
        }

        if (record.getSpecialPurposeField() != null) {
            this.itemSpPresent += 1;
            if (!record.getSpecialPurposeField().isValid()) {
                this.itemSpInvalid += 1;
            }
            appendItemCounterMsg("SP", itemSpPresent, itemSpInvalid);
        }

    }

    public int getItem010Present() {
        return item010Present;
    }

    public int getItem010Invalid() {
        return item010Invalid;
    }

    public int getItem015Present() {
        return item015Present;
    }

    public int getItem015Invalid() {
        return item015Invalid;
    }

    public int getItem070Present() {
        return item070Present;
    }

    public int getItem070Invalid() {
        return item070Invalid;
    }

    public int getItem105Present() {
        return item105Present;
    }

    public int getItem105Invalid() {
        return item105Invalid;
    }

    public int getItem100Present() {
        return item100Present;
    }

    public int getItem100Invalid() {
        return item100Invalid;
    }

    public int getItem185Present() {
        return item185Present;
    }

    public int getItem185Invalid() {
        return item185Invalid;
    }

    public int getItem210Present() {
        return item210Present;
    }

    public int getItem210Invalid() {
        return item210Invalid;
    }

    public int getItem060Present() {
        return item060Present;
    }

    public int getItem060Invalid() {
        return item060Invalid;
    }

    public int getItem245Present() {
        return item245Present;
    }

    public int getItem245Invalid() {
        return item245Invalid;
    }

    public int getItem380Present() {
        return item380Present;
    }

    public int getItem380Invalid() {
        return item380Invalid;
    }

    public int getItem380Subfield1Present() {
        return item380Subfield1Present;
    }

    public int getItem380Subfield1Invalid() {
        return item380Subfield1Invalid;
    }

    public int getItem380Subfield3Present() {
        return item380Subfield3Present;
    }

    public int getItem380Subfield3Invalid() {
        return item380Subfield3Invalid;
    }

    public int getItem380Subfield4Present() {
        return item380Subfield4Present;
    }

    public int getItem380Subfield4Invalid() {
        return item380Subfield4Invalid;
    }

    public int getItem380Subfield5Present() {
        return item380Subfield5Present;
    }

    public int getItem380Subfield5Invalid() {
        return item380Subfield5Invalid;
    }

    public int getItem380Subfield6Present() {
        return item380Subfield6Present;
    }

    public int getItem380Subfield6Invalid() {
        return item380Subfield6Invalid;
    }

    public int getItem380Subfield7Present() {
        return item380Subfield7Present;
    }

    public int getItem380Subfield7Invalid() {
        return item380Subfield7Invalid;
    }

    public int getItem380Subfield12Present() {
        return item380Subfield12Present;
    }

    public int getItem380Subfield12Invalid() {
        return item380Subfield12Invalid;
    }

    public int getItem380Subfield15Present() {
        return item380Subfield15Present;
    }

    public int getItem380Subfield15Invalid() {
        return item380Subfield15Invalid;
    }

    public int getItem380Subfield17Present() {
        return item380Subfield17Present;
    }

    public int getItem380Subfield17Invalid() {
        return item380Subfield17Invalid;
    }

    public int getItem380Subfield18Present() {
        return item380Subfield18Present;
    }

    public int getItem380Subfield18Invalid() {
        return item380Subfield18Invalid;
    }

    public int getItem380Subfield20Present() {
        return item380Subfield20Present;
    }

    public int getItem380Subfield20Invalid() {
        return item380Subfield20Invalid;
    }

    public int getItem380Subfield21Present() {
        return item380Subfield21Present;
    }

    public int getItem380Subfield21Invalid() {
        return item380Subfield21Invalid;
    }

    public int getItem380Subfield26Present() {
        return item380Subfield26Present;
    }

    public int getItem380Subfield26Invalid() {
        return item380Subfield26Invalid;
    }

    public int getItem380Subfield27Present() {
        return item380Subfield27Present;
    }

    public int getItem380Subfield27Invalid() {
        return item380Subfield27Invalid;
    }

    public int getItem380Subfield28Present() {
        return item380Subfield28Present;
    }

    public int getItem380Subfield28Invalid() {
        return item380Subfield28Invalid;
    }

    public int getItem040Present() {
        return item040Present;
    }

    public int getItem040Invalid() {
        return item040Invalid;
    }

    public int getItem080Present() {
        return item080Present;
    }

    public int getItem080Invalid() {
        return item080Invalid;
    }

    public int getItem290Present() {
        return item290Present;
    }

    public int getItem290Invalid() {
        return item290Invalid;
    }

    public int getItem200Present() {
        return item200Present;
    }

    public int getItem200Invalid() {
        return item200Invalid;
    }

    public int getItem295Present() {
        return item295Present;
    }

    public int getItem295Invalid() {
        return item295Invalid;
    }

    public int getItem136Present() {
        return item136Present;
    }

    public int getItem136Invalid() {
        return item136Invalid;
    }

    public int getItem130Present() {
        return item130Present;
    }

    public int getItem130Invalid() {
        return item130Invalid;
    }

    public int getItem135Present() {
        return item135Present;
    }

    public int getItem135Invalid() {
        return item135Invalid;
    }

    public int getItem220Present() {
        return item220Present;
    }

    public int getItem220Invalid() {
        return item220Invalid;
    }

    public int getItem220Negative() {
        return item220Negative;
    }

    public int getItem220Positive() {
        return item220Positive;
    }

    public int getItem220Zero() {
        return item220Zero;
    }

    public int getItem390Present() {
        return item390Present;
    }

    public int getItem390Invalid() {
        return item390Invalid;
    }

    public int getItem390Subfield2Present() {
        return item390Subfield2Present;
    }

    public int getItem390Subfield2Invalid() {
        return item390Subfield2Invalid;
    }

    public int getItem390Subfield4Present() {
        return item390Subfield4Present;
    }

    public int getItem390Subfield4Invalid() {
        return item390Subfield4Invalid;
    }

    public int getGetItem390Subfield4TrafficGat() {
        return item390Subfield4TrafficGat;
    }

    public int getGetItem390Subfield4TrafficOat() {
        return item390Subfield4TrafficOat;
    }

    public int getGetItem390Subfield4TrafficUnk() {
        return item390Subfield4TrafficUnk;
    }

    public int getGetItem390Subfield4TrafficNa() {
        return item390Subfield4TrafficNa;
    }

    public int getGetItem390Subfield4RulesIfr() {
        return item390Subfield4RulesIfr;
    }

    public int getGetItem390Subfield4RulesVfr() {
        return item390Subfield4RulesVfr;
    }

    public int getGetItem390Subfield4RulesNa() {
        return item390Subfield4RulesNa;
    }

    public int getGetItem390Subfield4RulesCtrlVfr() {
        return item390Subfield4RulesCtrlVfr;
    }

    public int getGetItem390Subfield4RvsmUnk() {
        return item390Subfield4RvsmUnk;
    }

    public int getGetItem390Subfield4RvsmApproved() {
        return item390Subfield4RvsmApproved;
    }

    public int getGetItem390Subfield4RvsmExempt() {
        return item390Subfield4RvsmExempt;
    }

    public int getGetItem390Subfield4RvsmNotApproved() {
        return item390Subfield4RvsmNotApproved;
    }

    public int getItem390Subfield5Present() {
        return item390Subfield5Present;
    }

    public int getItem390Subfield5Invalid() {
        return item390Subfield5Invalid;
    }

    public int getItem390Subfield6Present() {
        return item390Subfield6Present;
    }

    public int getItem390Subfield6Invalid() {
        return item390Subfield6Invalid;
    }

    public int getItem390Subfield6L() {
        return item390Subfield6L;
    }

    public int getItem390Subfield6M() {
        return item390Subfield6M;
    }

    public int getItem390Subfield6H() {
        return item390Subfield6H;
    }

    public int getItem390Subfield6J() {
        return item390Subfield6J;
    }

    public int getItem390Subfield7Present() {
        return item390Subfield7Present;
    }

    public int getItem390Subfield7Invalid() {
        return item390Subfield7Invalid;
    }

    public int getItem390Subfield8Present() {
        return item390Subfield8Present;
    }

    public int getItem390Subfield8Invalid() {
        return item390Subfield8Invalid;
    }

    public int getItem390Subfield9Present() {
        return item390Subfield9Present;
    }

    public int getItem390Subfield9Invalid() {
        return item390Subfield9Invalid;
    }

    public int getItem390Subfield10Present() {
        return item390Subfield10Present;
    }

    public int getItem390Subfield10Invalid() {
        return item390Subfield10Invalid;
    }

    public int getItem390Subfield11Present() {
        return item390Subfield11Present;
    }

    public int getItem390Subfield11Invalid() {
        return item390Subfield11Invalid;
    }

    public int getItem390Subfield12Present() {
        return item390Subfield12Present;
    }

    public int getItem390Subfield12Invalid() {
        return item390Subfield12Invalid;
    }

    public int getItem390Subfield13Present() {
        return item390Subfield13Present;
    }

    public int getItem390Subfield13Invalid() {
        return item390Subfield13Invalid;
    }

    public int getItem390Subfield14Present() {
        return item390Subfield14Present;
    }

    public int getItem390Subfield14Invalid() {
        return item390Subfield14Invalid;
    }

    public int getItem390Subfield15Present() {
        return item390Subfield15Present;
    }

    public int getItem390Subfield15Invalid() {
        return item390Subfield15Invalid;
    }

    public int getItem390Subfield16Present() {
        return item390Subfield16Present;
    }

    public int getItem390Subfield16Invalid() {
        return item390Subfield16Invalid;
    }

    public int getItem270Present() {
        return item270Present;
    }

    public int getItem270Invalid() {
        return item270Invalid;
    }

    public int getItem300Present() {
        return item300Present;
    }

    public int getItem300Invalid() {
        return item300Invalid;
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

    public int getItem510Present() {
        return item510Present;
    }

    public int getItem510Invalid() {
        return item510Invalid;
    }

    public int getItem500Present() {
        return item500Present;
    }

    public int getItem500Invalid() {
        return item500Invalid;
    }

    public int getItem340Present() {
        return item340Present;
    }

    public int getItem340Invalid() {
        return item340Invalid;
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

    private void addCountersForItem390(Cat062Record record) {
        if (record.getItem390() != null) {
            this.item390Present += 1;
            if (!record.getItem390().isValid()) {
                this.item390Invalid += 1;
            }
            appendItemCounterMsg("Item 390 - Flight plan data", item390Present, item390Invalid);

            //subfields
            if (record.getItem390().getSubfield2() != null) {
                this.item390Subfield2Present += 1;
                if (!record.getItem390().getSubfield2().isValid()) {
                    this.item390Subfield2Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 2 - Callsign", item390Subfield2Present,
                        item390Subfield2Invalid);
            }

            if (record.getItem390().getSubfield4() != null) {
                this.item390Subfield4Present += 1;
                if (!record.getItem390().getSubfield4().isValid()) {
                    this.item390Subfield4Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 4 - Flight category", item390Subfield4Present,
                        item390Subfield4Invalid);

                //traffic
                if (record.getItem390().getSubfield4().getTrafficType() == 0) {
                    item390Subfield4TrafficUnk += 1;
                } else if (record.getItem390().getSubfield4().getTrafficType() == 1) {
                    item390Subfield4TrafficGat += 1;
                } else if (record.getItem390().getSubfield4().getTrafficType() == 2) {
                    item390Subfield4TrafficOat += 1;
                } else {
                    item390Subfield4TrafficNa += 1;
                }
                appendItemCounterMsg("    Traffic type Unknown", item390Subfield4TrafficUnk, "");
                appendItemCounterMsg("    Traffic type GAT", item390Subfield4TrafficGat, "");
                appendItemCounterMsg("    Traffic type OAT", item390Subfield4TrafficOat, "");
                appendItemCounterMsg("    Traffic type NA", item390Subfield4TrafficNa, "");

                //rules
                if (record.getItem390().getSubfield4().getFlightRules() == 0) {
                    item390Subfield4RulesIfr += 1;
                } else if (record.getItem390().getSubfield4().getFlightRules() == 1) {
                    item390Subfield4RulesVfr += 1;
                } else if (record.getItem390().getSubfield4().getFlightRules() == 2) {
                    item390Subfield4RulesNa += 1;
                } else {
                    item390Subfield4RulesCtrlVfr += 1;
                }
                appendItemCounterMsg("    Rules IFR", item390Subfield4RulesIfr, "");
                appendItemCounterMsg("    Rules VFR", item390Subfield4RulesVfr, "");
                appendItemCounterMsg("    Rules CtrlVFR", item390Subfield4RulesCtrlVfr, "");
                appendItemCounterMsg("    Rules NA", item390Subfield4RulesNa, "");

                //rvsm
                if (record.getItem390().getSubfield4().getRvsm() == 0) {
                    item390Subfield4RvsmUnk += 1;
                } else if (record.getItem390().getSubfield4().getRvsm() == 1) {
                    item390Subfield4RvsmApproved += 1;
                } else if (record.getItem390().getSubfield4().getRvsm() == 2) {
                    item390Subfield4RvsmExempt += 1;
                } else {
                    item390Subfield4RvsmNotApproved += 1;
                }
                appendItemCounterMsg("    RVSM Unknwn", item390Subfield4RvsmUnk, "");
                appendItemCounterMsg("    RVSM Approved", item390Subfield4RvsmApproved, "");
                appendItemCounterMsg("    RVSM Exempt", item390Subfield4RvsmExempt, "");
                appendItemCounterMsg("    RVSM Not Approved", item390Subfield4RvsmNotApproved, "");
            }

            if (record.getItem390().getSubfield5() != null) {
                this.item390Subfield5Present += 1;
                if (!record.getItem390().getSubfield5().isValid()) {
                    this.item390Subfield5Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 5 - Type of aircraft", item390Subfield5Present,
                        item390Subfield5Invalid);
            }

            if (record.getItem390().getSubfield6() != null) {
                this.item390Subfield6Present += 1;
                if (!record.getItem390().getSubfield6().isValid()) {
                    this.item390Subfield6Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 6 - Wake Turbulence Category", item390Subfield6Present,
                        item390Subfield6Invalid);

                switch (record.getItem390().getSubfield6().getWakeTurbulenceCategory()) {
                    case "L":
                        this.item390Subfield6L += 1;
                        break;
                    case "M":
                        this.item390Subfield6M += 1;
                        break;
                    case "H":
                        this.item390Subfield6H += 1;
                        break;
                    default:
                        this.item390Subfield6J += 1;
                        break;
                }
                appendItemCounterMsg("    Light", item390Subfield6L, "");
                appendItemCounterMsg("    Medium", item390Subfield6M, "");
                appendItemCounterMsg("    Heavy", item390Subfield6H, "");
                appendItemCounterMsg("    Super", item390Subfield6J, "");
            }

            if (record.getItem390().getSubfield7() != null) {
                this.item390Subfield7Present += 1;
                if (!record.getItem390().getSubfield7().isValid()) {
                    this.item390Subfield7Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 7 - Departure", item390Subfield7Present,
                        item390Subfield7Invalid);
            }

            if (record.getItem390().getSubfield8() != null) {
                this.item390Subfield8Present += 1;
                if (!record.getItem390().getSubfield8().isValid()) {
                    this.item390Subfield8Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 8 - Destination", item390Subfield8Present,
                        item390Subfield8Invalid);
            }

            if (record.getItem390().getSubfield9() != null) {
                this.item390Subfield9Present += 1;
                if (!record.getItem390().getSubfield9().isValid()) {
                    this.item390Subfield9Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 9 - Runway Designation", item390Subfield9Present,
                        item390Subfield9Invalid);
            }

            if (record.getItem390().getSubfield10() != null) {
                this.item390Subfield10Present += 1;
                if (!record.getItem390().getSubfield10().isValid()) {
                    this.item390Subfield10Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 10 - Current CFL", item390Subfield10Present,
                        item390Subfield10Invalid);
            }

            if (record.getItem390().getSubfield11() != null) {
                this.item390Subfield11Present += 1;
                if (!record.getItem390().getSubfield11().isValid()) {
                    this.item390Subfield11Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 11 - Current Control Position", item390Subfield11Present,
                        item390Subfield11Invalid);
            }

            if (record.getItem390().getSubfield12() != null) {
                this.item390Subfield12Present += 1;
                if (!record.getItem390().getSubfield12().isValid()) {
                    this.item390Subfield12Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 12 - Time of departure / arrival", item390Subfield12Present,
                        item390Subfield12Invalid);
            }

            if (record.getItem390().getSubfield13() != null) {
                this.item390Subfield13Present += 1;
                if (!record.getItem390().getSubfield13().isValid()) {
                    this.item390Subfield13Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 13 - Aircraft stand", item390Subfield13Present,
                        item390Subfield13Invalid);
            }

            if (record.getItem390().getSubfield14() != null) {
                this.item390Subfield14Present += 1;
                if (!record.getItem390().getSubfield14().isValid()) {
                    this.item390Subfield14Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 14 - Stand Status", item390Subfield14Present,
                        item390Subfield14Invalid);
            }

            if (record.getItem390().getSubfield15() != null) {
                this.item390Subfield15Present += 1;
                if (!record.getItem390().getSubfield15().isValid()) {
                    this.item390Subfield15Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 15 - SID", item390Subfield15Present,
                        item390Subfield15Invalid);
            }

            if (record.getItem390().getSubfield16() != null) {
                this.item390Subfield16Present += 1;
                if (!record.getItem390().getSubfield16().isValid()) {
                    this.item390Subfield16Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 16 - STAR", item390Subfield16Present,
                        item390Subfield16Invalid);
            }
        }
    }

    private void addCountersForItem380(Cat062Record record) {
        if (record.getItem380() != null) {
            this.item380Present += 1;
            if (!record.getItem380().isValid()) {
                this.item380Invalid += 1;
            }
            appendItemCounterMsg("Item 380 - Aircraft derivd data", item380Present, item380Invalid);
            //subfield info
            if (record.getItem380().getSubfield1() != null) {
                this.item380Subfield1Present += 1;
                if (!record.getItem380().getSubfield1().isValid()) {
                    this.item380Subfield1Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 1 - Target identification", item380Subfield1Present,
                        item380Subfield1Invalid);
            }

            if (record.getItem380().getSubfield3() != null) {
                this.item380Subfield3Present += 1;
                if (!record.getItem380().getSubfield3().isValid()) {
                    this.item380Subfield3Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 3 - Magnetic heading", item380Subfield3Present,
                        item380Subfield3Invalid);
            }

            if (record.getItem380().getSubfield4() != null) {
                this.item380Subfield4Present += 1;
                if (!record.getItem380().getSubfield4().isValid()) {
                    this.item380Subfield4Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 4 - Indicated airspeed / Mach no [Compat only]",
                        item380Subfield4Present,
                        item380Subfield4Invalid);
            }

            if (record.getItem380().getSubfield5() != null) {
                this.item380Subfield5Present += 1;
                if (!record.getItem380().getSubfield5().isValid()) {
                    this.item380Subfield5Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 5 - True airspeed", item380Subfield5Present,
                        item380Subfield5Invalid);
            }

            if (record.getItem380().getSubfield6() != null) {
                this.item380Subfield6Present += 1;
                if (!record.getItem380().getSubfield6().isValid()) {
                    this.item380Subfield6Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 6 - Selected altitude", item380Subfield6Present,
                        item380Subfield6Invalid);
            }

            if (record.getItem380().getSubfield7() != null) {
                this.item380Subfield7Present += 1;
                if (!record.getItem380().getSubfield7().isValid()) {
                    this.item380Subfield7Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 7 - Final state selected altitude", item380Subfield7Present,
                        item380Subfield7Invalid);
            }

            if (record.getItem380().getSubfield12() != null) {
                this.item380Subfield12Present += 1;
                if (!record.getItem380().getSubfield12().isValid()) {
                    this.item380Subfield12Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 12 - ACAS Report", item380Subfield12Present,
                        item380Subfield12Invalid);
            }

            if (record.getItem380().getSubfield15() != null) {
                this.item380Subfield15Present += 1;
                if (!record.getItem380().getSubfield15().isValid()) {
                    this.item380Subfield15Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 15 - Roll angle", item380Subfield15Present,
                        item380Subfield15Invalid);
            }

            if (record.getItem380().getSubfield17() != null) {
                this.item380Subfield17Present += 1;
                if (!record.getItem380().getSubfield17().isValid()) {
                    this.item380Subfield17Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 17 - Track angle", item380Subfield17Present,
                        item380Subfield17Invalid);
            }

            if (record.getItem380().getSubfield18() != null) {
                this.item380Subfield18Present += 1;
                if (!record.getItem380().getSubfield18().isValid()) {
                    this.item380Subfield18Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 18 - Ground speed", item380Subfield18Present,
                        item380Subfield18Invalid);
            }

            if (record.getItem380().getSubfield20() != null) {
                this.item380Subfield20Present += 1;
                if (!record.getItem380().getSubfield20().isValid()) {
                    this.item380Subfield20Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 20 - Meteo data", item380Subfield20Present,
                        item380Subfield20Invalid);
            }

            if (record.getItem380().getSubfield21() != null) {
                this.item380Subfield21Present += 1;
                if (!record.getItem380().getSubfield21().isValid()) {
                    this.item380Subfield21Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 21 - Emmiter category", item380Subfield21Present,
                        item380Subfield21Invalid);
            }

            if (record.getItem380().getSubfield26() != null) {
                this.item380Subfield26Present += 1;
                if (!record.getItem380().getSubfield26().isValid()) {
                    this.item380Subfield26Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 26 - Indicated airspeed", item380Subfield26Present,
                        item380Subfield26Invalid);
            }

            if (record.getItem380().getSubfield27() != null) {
                this.item380Subfield27Present += 1;
                if (!record.getItem380().getSubfield27().isValid()) {
                    this.item380Subfield27Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 27 - Mach nb", item380Subfield27Present,
                        item380Subfield27Invalid);
            }

            if (record.getItem380().getSubfield28() != null) {
                this.item380Subfield28Present += 1;
                if (!record.getItem380().getSubfield28().isValid()) {
                    this.item380Subfield28Invalid += 1;
                }
                appendItemCounterMsg("  Subfield 28 - Barometric pressure setting", item380Subfield28Present,
                        item380Subfield28Invalid);
            }
        }
    }
}
