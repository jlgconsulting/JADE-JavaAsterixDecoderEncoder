/**
 * Created by alexandru on 6/30/16.
 */
package jlg.jade.asterix.cat034;

import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat034 Item000 - Message Type
 * This Data Item allows for a more convenient handling of the messages at the receiver side by further defining the type of transaction.
 */
public class Cat034Item000 extends FixedLengthAsterixData {
    private Cat034Item000MessageType messageType;

    @Override
    protected int setSizeInBytes() {
        return 1;
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        int messageTypeValue = UnsignedNumericDecoder.decodeFromOneByte(input, offset);
        switch (messageTypeValue) {
            case 1:
                this.messageType = Cat034Item000MessageType.NORTH_MARKER_MESSAGE;
                break;
            case 2:
                this.messageType = Cat034Item000MessageType.SECTOR_CROSSING_MESSAGE;
                break;
            case 3:
                this.messageType = Cat034Item000MessageType.GEOGRAPHICAL_FILTERING_MESSAGE;
                break;
            case 4:
                this.messageType = Cat034Item000MessageType.JAMMING_STROBE_MESSAGE;
                break;
            default:
                this.messageType = Cat034Item000MessageType.UNKNOWN;
                break;
        }

        appendItemDebugMsg("Message Type", this.messageType);
    }

    @Override
    protected String setDisplayName() {
        return "Cat034Item000 - Message Type";
    }

    public Cat034Item000MessageType getMessageType() {
        return messageType;
    }
}
