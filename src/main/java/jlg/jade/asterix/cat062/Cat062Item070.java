/* 
* Created by dan-geabunea on 4/21/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Cat 062 Item 070 - Time of track information - Mandatory
 * Absolute time stamping of the information provided in the track message, in the form of elapsed time since last midnight,
 * expressed as UTC.
 * Unit of measure is 1/128 sec
 */
public class Cat062Item070 extends FixedLengthAsterixData {
    private int timeOfTrack;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.timeOfTrack =
                Byte.toUnsignedInt(input[offset]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 1]) * 256 +
                        Byte.toUnsignedInt(input[offset + 2]);

        appendItemDebugMsg("Time of track: ", this.timeOfTrack);

        //we create strings for hours, minutes and seconds to be able to represent time like 04:45:09 (leading 0)
        String hours = String.valueOf(getHours());
        if(hours.length() == 1){
            hours = "0" + hours;
        }

        String minutes = String.valueOf(getMinutes());
        if(minutes.length() == 1){
            minutes = "0" + minutes;
        }
        String seconds = String.valueOf(getSeconds());
        if(seconds.length() == 1){
            seconds = "0" + seconds;
        }

        appendItemDebugMsg("Time of track (HH:MM:SS): ", hours + ":" + minutes + ":" + seconds);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item070 - Time of Track";
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
