/**
 * Created by Dan Geabunea on 7/11/2016.
 */

package jlg.jade.asterix.counters;

import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.asterix.cat150.Cat150Record;
import jlg.jade.common.DebugMessageSource;

/**
 * Counter class for Cat150
 */
public class Cat150ItemCounter extends DebugMessageSource implements AsterixItemCounter {
    private int nbRecords = 0;
    private int nbOfInvalidRecords = 0;

    private int item010Present = 0;
    private int item010Invalid = 0;

    private int item020Present = 0;
    private int item020Invalid = 0;

    private int item030Present = 0;
    private int item030Invalid = 0;

    private int item040Present = 0;
    private int item040Invalid = 0;

    private int item050Present = 0;
    private int item050Invalid = 0;

    private int item060Present = 0;
    private int item060Invalid = 0;

    private int item070Present = 0;
    private int item070Invalid = 0;

    private int item080Present = 0;
    private int item080Invalid = 0;

    private int item090Present = 0;
    private int item090Invalid = 0;

    private int item100Present = 0;
    private int item100Invalid = 0;
    private int nbGatMsg = 0;
    private int nbOatMsg = 0;
    private int nbUnknownTrafficMsg = 0;

    private int item110Present = 0;
    private int item110Invalid = 0;
    private int nbRvsmEquippedMsg = 0;
    private int nbRvsmCapableMsg = 0;
    private int nbRvsmExemptedMsg = 0;
    private int nbRvsmUnknownMsg = 0;

    private int item120Present = 0;
    private int item120Invalid = 0;

    private int item130Present = 0;
    private int item130Invalid = 0;
    private int nbPlanCreationMsg = 0;
    private int nbPlanModificationMsg = 0;
    private int nbPlanRepetitionMsg = 0;
    private int nbManualPlanDeletionMsg = 0;
    private int nbAutoPlanDeletionMsg = 0;
    private int nbCorrelationMsg = 0;
    private int nbDecorrelationMsg = 0;
    private int nbStartLoopMsg = 0;
    private int nbEndLoopMsg = 0;
    private int nbUnknownPlanMsg = 0;

    private int item140Present = 0;
    private int item140Invalid = 0;

    private int item150Present = 0;
    private int item150Invalid = 0;

    private int item160Present = 0;
    private int item160Invalid = 0;

    private int item170Present = 0;
    private int item170Invalid = 0;

    private int item180Present = 0;
    private int item180Invalid = 0;

    private int item190Present = 0;
    private int item190Invalid = 0;

    private int item200Present = 0;
    private int item200Invalid = 0;

    private int item210Present = 0;
    private int item210Invalid = 0;

    private int item220Present = 0;
    private int item220Invalid = 0;

    private int item230Present = 0;
    private int item230Invalid = 0;

    private int item240Present = 0;
    private int item240Invalid = 0;

    private int item250Present = 0;
    private int item250Invalid = 0;

    private int item251Present = 0;
    private int item251Invalid = 0;

    private int item171Present = 0;
    private int item171Invalid = 0;

    private int item151Present = 0;
    private int item151Invalid = 0;

    /**
     * Increments counter values with the the ones received from a new data block
     *
     * @param asterixDataBlock An Asterix data block that has Cat 150 data
     */
    @Override
    public void increment(AsterixDataBlock asterixDataBlock) {
        for (AsterixRecord record : asterixDataBlock.getRecords()) {
            if (record.getCategory() == 150) {
                increment(record.getCat150Record());
            }
        }
    }

    /**
     * Adds the current counter values with the new counter values
     *
     * @param record a new Asterix record
     */
    private void increment(Cat150Record record) {
        clearDebugMsg();
        appendNewLine();
        appendNewLine();
        appendItemCounterMsg("Asterix Category 150 Counters", "Nb. decoded", "Nb. invalid");

        this.nbRecords = this.getNbRecords() + 1;
        if (!record.isValid()) {
            this.nbOfInvalidRecords = this.getNbOfInvalidRecords() + 1;
        }
        appendItemCounterMsg("Number of records", getNbRecords(), getNbOfInvalidRecords());

        if (record.getItem010() != null) {
            this.item010Present = this.item010Present + 1;
            if (!record.getItem010().isValid()) {
                this.item010Invalid = this.item010Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 010 - Destination ID",
                    item010Present,
                    item010Invalid);
        }

        //counters for item 020
        if (record.getItem020() != null) {
            this.item020Present = this.item020Present + 1;
            if (!record.getItem020().isValid()) {
                this.item020Invalid = this.item020Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 020 - Source ID",
                    item020Present,
                    item020Invalid);
        }

        //counters for item 030
        if (record.getItem030() != null) {
            this.item030Present = this.item030Present + 1;
            if (!record.getItem030().isValid()) {
                this.item030Invalid = this.item030Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 030 - MessageType",
                    item030Present,
                    item030Invalid);

            switch (record.getItem030().getMessageType()) {
                case FLIGHT_PLAN_CREATION:
                    this.nbPlanCreationMsg++;
                    break;
                case FLIGHT_PLAN_MODIFICATION:
                    this.nbPlanModificationMsg++;
                    break;
                case FLIGHT_PLAN_REPETITION:
                    this.nbPlanRepetitionMsg++;
                    break;
                case MANUAL_FLIGHT_PLAN_DELETION:
                    this.nbManualPlanDeletionMsg++;
                    break;
                case AUTOMATIC_FLIGHT_PLAN_DELETION:
                    this.nbAutoPlanDeletionMsg++;
                    break;
                case CORRELATIONS:
                    this.nbCorrelationMsg++;
                    break;
                case DECORRELATIONS:
                    this.nbDecorrelationMsg++;
                    break;
                case START_BACKGROUND_LOOP:
                    this.nbStartLoopMsg++;
                    break;
                case END_BACKGROUND_LOOG:
                    this.nbEndLoopMsg++;
                    break;
                default: {
                    break;
                }
            }
            appendItemCounterMsg("  CREATION", this.nbPlanCreationMsg, 0);
            appendItemCounterMsg("  MODIFICATION", this.nbPlanModificationMsg, 0);
            appendItemCounterMsg("  REPETITION", this.nbPlanRepetitionMsg, 0);
            appendItemCounterMsg("  MANUAL DELETION", this.nbAutoPlanDeletionMsg, 0);
            appendItemCounterMsg("  AUTO DELETION", this.nbAutoPlanDeletionMsg, 0);
            appendItemCounterMsg("  CORRELATION", this.nbCorrelationMsg, 0);
            appendItemCounterMsg("  DE-CORRELATION", this.nbDecorrelationMsg, 0);
            appendItemCounterMsg("  START LOOP", this.nbStartLoopMsg, 0);
            appendItemCounterMsg("  END LOOP", this.nbEndLoopMsg, 0);
        }


        //counters for item 040
        if (record.getItem040() != null) {
            this.item040Present = this.item040Present + 1;
            if (!record.getItem040().isValid()) {
                this.item040Invalid = this.item040Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 040 - Plan Number",
                    item040Present,
                    item040Invalid);
        }

        //counters for item 050
        if (record.getItem050() != null) {
            this.item050Present = this.item050Present + 1;
            if (!record.getItem050().isValid()) {
                this.item050Invalid = this.item050Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 050 - Callsign",
                    item050Present,
                    item050Invalid);
        }

        //counters for item 060
        if (record.getItem060() != null) {
            this.item060Present = this.item060Present + 1;
            if (!record.getItem060().isValid()) {
                this.item060Invalid = this.item060Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 060 - Present Mode-A",
                    item060Present,
                    item060Invalid);
        }

        //counters for item 070
        if (record.getItem070() != null) {
            this.item070Present = this.item070Present + 1;
            if (!record.getItem070().isValid()) {
                this.item070Invalid = this.item070Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 070 - Next Mode-A",
                    item070Present,
                    item070Invalid);
        }

        //counters for item 080
        if (record.getItem080() != null) {
            this.item080Present = this.item080Present + 1;
            if (!record.getItem080().isValid()) {
                this.item080Invalid = this.item080Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 080 - Departure",
                    item080Present,
                    item080Invalid);
        }

        //counters for item 090
        if (record.getItem090() != null) {
            this.item090Present = this.item090Present + 1;
            if (!record.getItem090().isValid()) {
                this.item090Invalid = this.item090Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 090 - Destination",
                    item090Present,
                    item090Invalid);
        }

        //counters for item 100
        if (record.getItem100() != null) {
            this.item100Present = this.item100Present + 1;
            if (!record.getItem100().isValid()) {
                this.item100Invalid = this.item100Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 100 - Flight Type Flags",
                    item100Present,
                    item100Invalid);

            if (record.getItem100().getGatFlag()) {
                nbGatMsg++;
            }
            if (record.getItem100().getOatFlag()) {
                nbOatMsg++;
            }
            if (record.getItem100().getGatFlag() == false && record.getItem100().getOatFlag() ==
                    false) {
                nbUnknownTrafficMsg++;
            }
            appendItemCounterMsg("  GAT", this.nbGatMsg, 0);
            appendItemCounterMsg("  OAT", this.nbOatMsg, 0);
            appendItemCounterMsg("  UNKNOWN", this.nbUnknownTrafficMsg, 0);
        }

        //counters for item 110
        if (record.getItem110() != null) {
            this.item110Present = this.item110Present + 1;
            if (!record.getItem110().isValid()) {
                this.item110Invalid = this.item110Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 110 - Flight Status Flags",
                    item110Present,
                    item110Invalid);
            switch (record.getItem110().getRvsmStatus()) {
                case UNKNOWN:
                    this.nbRvsmUnknownMsg++;
                    break;
                case EQUIPPED:
                    this.nbRvsmEquippedMsg++;
                    break;
                case CAPABLE:
                    this.nbRvsmCapableMsg++;
                    break;
                case EXEMPTED:
                    this.nbRvsmExemptedMsg++;
                    break;
            }
            appendItemCounterMsg("  EQUIPPED", this.nbRvsmEquippedMsg, 0);
            appendItemCounterMsg("  CAPABLE", this.nbRvsmCapableMsg, 0);
            appendItemCounterMsg("  EXEMPTED", this.nbRvsmExemptedMsg, 0);
            appendItemCounterMsg("  UNKNOWN", this.nbRvsmUnknownMsg, 0);
        }

        //counters for item 120
        if (record.getItem120() != null) {
            this.item120Present = this.item120Present + 1;
            if (!record.getItem120().isValid()) {
                this.item120Invalid = this.item120Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 120 - Aircraft Type & Wake Turbulence",
                    item120Present,
                    item120Invalid);
        }

        //counters for item 130
        if (record.getItem130() != null) {
            this.item130Present = this.item130Present + 1;
            if (!record.getItem130().isValid()) {
                this.item130Invalid = this.item130Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 130 - Cleared Flight Level (CFL)",
                    item130Present,
                    item130Invalid);
        }

        //counters for item 140
        if (record.getItem140() != null) {
            this.item140Present = this.item140Present + 1;
            if (!record.getItem140().isValid()) {
                this.item140Invalid = this.item140Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 140 - Route Points, Description",
                    item140Present,
                    item140Invalid);
        }

        //counters for item 150
        if (record.getItem150() != null) {
            this.item150Present = this.item150Present + 1;
            if (!record.getItem150().isValid()) {
                this.item150Invalid = this.item150Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 150 - Route Points, Coordinates",
                    item150Present,
                    item150Invalid);
        }

        //counters for item 160
        if (record.getItem160() != null) {
            this.item160Present = this.item160Present + 1;
            if (!record.getItem160().isValid()) {
                this.item160Invalid = this.item160Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 160 - Route Points, Time",
                    item160Present,
                    item160Invalid);
        }

        //counters for item 170
        if (record.getItem170() != null) {
            this.item170Present = this.item170Present + 1;
            if (!record.getItem170().isValid()) {
                this.item170Invalid = this.item170Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 170 - Route Points, Flight Level",
                    item170Present,
                    item170Invalid);
        }

        //counters for item 180
        if (record.getItem180() != null) {
            this.item180Present = this.item180Present + 1;
            if (!record.getItem180().isValid()) {
                this.item180Invalid = this.item180Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 180 - Route Points, Speed",
                    item180Present,
                    item180Invalid);
        }

        //counters for item 190
        if (record.getItem190() != null) {
            this.item190Present = this.item190Present + 1;
            if (!record.getItem190().isValid()) {
                this.item190Invalid = this.item190Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 190 - Controller ID",
                    item190Present,
                    item190Invalid);
        }

        //counters for item 200
        if (record.getItem200() != null) {
            this.item200Present = this.item200Present + 1;
            if (!record.getItem200().isValid()) {
                this.item200Invalid = this.item200Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 200 - Field 18",
                    item200Present,
                    item200Invalid);
        }

        //counters for item 210
        if (record.getItem210() != null) {
            this.item210Present = this.item210Present + 1;
            if (!record.getItem210().isValid()) {
                this.item210Invalid = this.item210Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 210 - Correlated Track Number",
                    item210Present,
                    item210Invalid);
        }

        //counters for item 171
        if (record.getItem171() != null) {
            this.item171Present = this.item171Present + 1;
            if (!record.getItem171().isValid()) {
                this.item171Invalid = this.item171Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 171 - Route Points, RFL",
                    item171Present,
                    item171Invalid);
        }

        //counters for item 151
        if (record.getItem151() != null) {
            this.item151Present = this.item151Present + 1;
            if (!record.getItem151().isValid()) {
                this.item151Invalid = this.item151Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 151 - Route Points, Geographic Pos",
                    item151Present,
                    item151Invalid);
        }

        //counters for item 220
        if (record.getItem220() != null) {
            this.item220Present = this.item220Present + 1;
            if (!record.getItem220().isValid()) {
                this.item220Invalid = this.item220Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 220 - Maximum Plan Count",
                    item220Present,
                    item220Invalid);
        }

        //counters for item 230
        if (record.getItem230() != null) {
            this.item230Present = this.item230Present + 1;
            if (!record.getItem230().isValid()) {
                this.item230Invalid = this.item230Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 230 - Number of Plans",
                    item230Present,
                    item230Invalid);
        }

        //counters for item 240
        if (record.getItem240() != null) {
            this.item240Present = this.item240Present + 1;
            if (!record.getItem240().isValid()) {
                this.item240Invalid = this.item240Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 240 - Newly Correlated Plans",
                    item240Present,
                    item240Invalid);
        }

        //counters for item 250
        if (record.getItem250() != null) {
            this.item250Present = this.item250Present + 1;
            if (!record.getItem250().isValid()) {
                this.item250Invalid = this.item250Invalid + 1;
            }
            appendItemCounterMsg(
                    "Item 250 - Newly De-correlated Plans",
                    item250Present,
                    item250Invalid);
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

    public int getItem020Present() {
        return item020Present;
    }

    public int getItem020Invalid() {
        return item020Invalid;
    }

    public int getItem030Present() {
        return item030Present;
    }

    public int getItem030Invalid() {
        return item030Invalid;
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

    public int getItem080Present() {
        return item080Present;
    }

    public int getItem080Invalid() {
        return item080Invalid;
    }

    public int getItem090Present() {
        return item090Present;
    }

    public int getItem090Invalid() {
        return item090Invalid;
    }

    public int getItem100Present() {
        return item100Present;
    }

    public int getItem100Invalid() {
        return item100Invalid;
    }

    public int getNbGatMsg() {
        return nbGatMsg;
    }

    public int getNbOatMsg() {
        return nbOatMsg;
    }

    public int getNbUnknownTrafficMsg() {
        return nbUnknownTrafficMsg;
    }

    public int getItem110Present() {
        return item110Present;
    }

    public int getItem110Invalid() {
        return item110Invalid;
    }

    public int getNbRvsmEquippedMsg() {
        return nbRvsmEquippedMsg;
    }

    public int getNbRvsmCapableMsg() {
        return nbRvsmCapableMsg;
    }

    public int getNbRvsmExemptedMsg() {
        return nbRvsmExemptedMsg;
    }

    public int getNbRvsmUnknownMsg() {
        return nbRvsmUnknownMsg;
    }

    public int getItem120Present() {
        return item120Present;
    }

    public int getItem120Invalid() {
        return item120Invalid;
    }

    public int getItem130Present() {
        return item130Present;
    }

    public int getItem130Invalid() {
        return item130Invalid;
    }

    public int getNbPlanCreationMsg() {
        return nbPlanCreationMsg;
    }

    public int getNbPlanModificationMsg() {
        return nbPlanModificationMsg;
    }

    public int getNbPlanRepetitionMsg() {
        return nbPlanRepetitionMsg;
    }

    public int getNbManualPlanDeletionMsg() {
        return nbManualPlanDeletionMsg;
    }

    public int getNbAutoPlanDeletionMsg() {
        return nbAutoPlanDeletionMsg;
    }

    public int getNbCorrelationMsg() {
        return nbCorrelationMsg;
    }

    public int getNbDecorrelationMsg() {
        return nbDecorrelationMsg;
    }

    public int getNbStartLoopMsg() {
        return nbStartLoopMsg;
    }

    public int getNbEndLoopMsg() {
        return nbEndLoopMsg;
    }

    public int getItem140Present() {
        return item140Present;
    }

    public int getItem140Invalid() {
        return item140Invalid;
    }

    public int getItem150Present() {
        return item150Present;
    }

    public int getItem150Invalid() {
        return item150Invalid;
    }

    public int getItem160Present() {
        return item160Present;
    }

    public int getItem160Invalid() {
        return item160Invalid;
    }

    public int getItem170Present() {
        return item170Present;
    }

    public int getItem170Invalid() {
        return item170Invalid;
    }

    public int getItem180Present() {
        return item180Present;
    }

    public int getItem180Invalid() {
        return item180Invalid;
    }

    public int getItem190Present() {
        return item190Present;
    }

    public int getItem190Invalid() {
        return item190Invalid;
    }

    public int getItem200Present() {
        return item200Present;
    }

    public int getItem200Invalid() {
        return item200Invalid;
    }

    public int getItem210Present() {
        return item210Present;
    }

    public int getItem210Invalid() {
        return item210Invalid;
    }

    public int getItem220Present() {
        return item220Present;
    }

    public int getItem220Invalid() {
        return item220Invalid;
    }

    public int getItem230Present() {
        return item230Present;
    }

    public int getItem230Invalid() {
        return item230Invalid;
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

    public int getItem251Present() {
        return item251Present;
    }

    public int getItem251Invalid() {
        return item251Invalid;
    }

    public int getItem171Present() {
        return item171Present;
    }

    public int getItem171Invalid() {
        return item171Invalid;
    }

    public int getItem151Present() {
        return item151Present;
    }

    public int getItem151Invalid() {
        return item151Invalid;
    }

    public int getNbUnknownPlanMsg() {
        return nbUnknownPlanMsg;
    }
}
