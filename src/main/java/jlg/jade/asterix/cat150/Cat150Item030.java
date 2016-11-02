/**
 * Created by Dan Geabunea on 6/30/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat150 Item030 - Message Type
 * The event that triggered the message transmission
 */
public class Cat150Item030 extends FixedLengthAsterixData {
    private Cat150Item030MessageType messageType;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        int numericValue = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        switch (numericValue) {
            case 1: {
                this.messageType = Cat150Item030MessageType.FLIGHT_PLAN_CREATION;
                break;
            }
            case 2: {
                this.messageType = Cat150Item030MessageType.FLIGHT_PLAN_MODIFICATION;
                break;
            }
            case 3: {
                this.messageType = Cat150Item030MessageType.FLIGHT_PLAN_REPETITION;
                break;
            }
            case 4: {
                this.messageType = Cat150Item030MessageType.MANUAL_FLIGHT_PLAN_DELETION;
                break;
            }
            case 5: {
                this.messageType = Cat150Item030MessageType.AUTOMATIC_FLIGHT_PLAN_DELETION;
                break;
            }
            case 6: {
                this.messageType = Cat150Item030MessageType.FLIGHT_BEYOND_EXTRACTION_AREA;
                break;
            }
            case 251: {
                this.messageType = Cat150Item030MessageType.STCA;
                break;
            }
            case 252: {
                this.messageType = Cat150Item030MessageType.CORRELATIONS;
                break;
            }
            case 253: {
                this.messageType = Cat150Item030MessageType.DECORRELATIONS;
                break;
            }
            case 254: {
                this.messageType = Cat150Item030MessageType.START_BACKGROUND_LOOP;
                break;
            }
            case 255: {
                this.messageType = Cat150Item030MessageType.END_BACKGROUND_LOOG;
                break;
            }
            default: {
                this.messageType = Cat150Item030MessageType.UNKNOWN;
                break;
            }
        }
        this.appendItemDebugMsg("Message Type", this.messageType);
    }

    @Override
    protected String setDisplayName() {
        return "Cat150Item030 - Message Type";
    }

    public Cat150Item030MessageType getMessageType() {
        return messageType;
    }
}
