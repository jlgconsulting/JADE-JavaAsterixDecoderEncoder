/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.FixedLengthAsterixItem;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 070 - Time of track information - Mandatory
 * Absolute time stamping of the information provided in the track message, in the form of elapsed time since last midnight,
 * expressed as UTC.
 * Unit of measure is 1/128 sec
 */
public class Cat062Item070 extends FixedLengthAsterixItem {
    private int timeOfTrack;

    @Override
    protected int decodeFromByteArray(byte[] input, int offset) {
        checkLength(input, offset);

        this.timeOfTrack =
                Byte.toUnsignedInt(input[offset]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 1]) * 256 +
                        Byte.toUnsignedInt(input[offset + 2]);

        appendItemDebugMsg("Time of track: ", this.timeOfTrack);
        appendItemDebugMsg("Time of track (Human Readable): ", getHours() + ":" + getMinutes() + ":" + getSeconds());

        return offset + this.sizeInBytes;
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    public int getTimeOfTrack() {
        return this.timeOfTrack;
    }

    public int getHours() {
        return this.timeOfTrack / 128 / 3600;
    }

    public int getMinutes() {
        return ((this.timeOfTrack / 128) % 3600) / 60;
    }

    public int getSeconds() {
        return (this.timeOfTrack / 128) % 60;
    }
}
