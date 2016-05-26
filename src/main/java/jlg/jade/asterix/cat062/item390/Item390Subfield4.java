/* 
* Created by dan-geabunea on 5/10/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.BitValueDecoder;

import java.util.BitSet;

/**
 * Item 390 - Subfield 4 - Flight category
 * Contains info about traffic type, instrumentaiton, rvsm and priority.
 */
public class Item390Subfield4 extends FixedLengthAsterixData {
    private int trafficType;
    private int flightRules;
    private int rvsm;
    private int priority;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        BitSet bs = BitSet.valueOf(new byte[]{input[offset]});

        //decode traffic type
        this.trafficType = BitValueDecoder.decodeFromTwoBits(bs, 6, 7);
        appendItemDebugMsg("Traffic type (0=Unk,1=GAT,2=OAT,3=NA)", this.trafficType);

        //decode flight rules
        this.flightRules = BitValueDecoder.decodeFromTwoBits(bs, 4, 5);
        appendItemDebugMsg("Flight rules (0=IFR,1=VFR,2=NA,3=Ctrl. VFR)", this.flightRules);

        //decode RVSM
        this.rvsm = BitValueDecoder.decodeFromTwoBits(bs, 2, 3);
        appendItemDebugMsg("RVSM (0=Unk,1=Approved,2=Exempt,3=Not approved)", this.rvsm);

        //decode HPR
        if (bs.get(0)) {
            this.priority = 1;
        } else {
            this.priority = 0;
        }
        appendItemDebugMsg("Flight priority (0=Normal,1=High)", this.priority);

    }

    /**
     * @return The traffic type of the aircraft
     * - 0 is Unknown
     * - 1 is GAT
     * - 2 is OAT
     * - 3 is NA
     */
    public int getTrafficType() {
        return trafficType;
    }

    /**
     * @return The flight rules
     * - 0 is IFR
     * - 1 is VFR
     * - 2 is NA
     * - 3 is CVFR
     */
    public int getFlightRules() {
        return flightRules;
    }

    /**
     * @return The RVSM info
     * - 0 is Unknown
     * - 1 is Approved
     * - 2 is Exempt
     * - 3 is Not approved
     */
    public int getRvsm() {
        return rvsm;
    }

    /**
     * @return The priority of the flight
     * - 0 is Normal flight
     * - 1 is High priority flight
     */
    public int getPriority() {
        return priority;
    }

    @Override
    protected String setDisplayName() {
        return "Item390Subfield4 - Flicht Category";
    }
}
