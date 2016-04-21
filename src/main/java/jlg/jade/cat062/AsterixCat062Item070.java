/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.*;
import jlg.jade.asterix.AsterixItemLength;

/**
 * Cat 062 Item 070 - Time of track information - Mandatory
 * Absolute time stamping of the information provided in the track message, in the form of elapsed time since last midnight,
 * expressed as UTC.
 * Unit of measure is 1/128 sec
 */
public class AsterixCat062Item070 extends AsterixItem implements DecodableFixedLength, EncodableFixedLength {
    private int timeOfTrack;

    public AsterixCat062Item070() {
        this.sizeInBytes = AsterixItemLength.THREE_BYTES.getValue();
    }


    @Override
    public void reset() {
        this.timeOfTrack = 0;
    }

    @Override
    public int decode(byte[] input, int offset) {
        reset();
        checkLength(input, offset, this.sizeInBytes);

        this.timeOfTrack =
                Byte.toUnsignedInt(input[offset]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 1]) * 256 +
                        Byte.toUnsignedInt(input[offset + 2]);

        appendItemDebugMsg("Time of track: ", this.timeOfTrack);
        appendItemDebugMsg("Time of track (Human Readable): ", getHours() + ":" + getMinutes() + ":" + getSeconds());

        return offset + this.sizeInBytes;
    }

    @Override
    public int encode(byte[] dest, int offset) {
        return 0;
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
