/* 
* Created by dan-geabunea on 5/26/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix;

/**
 * Base class that represents time information in Asterix.
 * Absolute time stamping of the message, in the form of elapsed
 * time since last midnight, expressed as UTC.
 *
 * @implSpec The time of the day value is reset to zero at every midnight
 */
public abstract class AsterixTimeData extends FixedLengthAsterixData {
    private int time;

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.time =
                Byte.toUnsignedInt(input[offset]) * 256 * 256 +
                        Byte.toUnsignedInt(input[offset + 1]) * 256 +
                        Byte.toUnsignedInt(input[offset + 2]);

        appendItemDebugMsg("Time: ", this.time);

        //we create strings for hours, minutes and seconds to be able to represent time like 04:45:09 (leading 0)
        String hours = String.valueOf(getHours());
        if (hours.length() == 1) {
            hours = "0" + hours;
        }

        String minutes = String.valueOf(getMinutes());
        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        }
        String seconds = String.valueOf(getSeconds());
        if (seconds.length() == 1) {
            seconds = "0" + seconds;
        }

        appendItemDebugMsg("Time of track (HH:MM:SS): ", hours + ":" + minutes + ":" + seconds);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.THREE_BYTES.getValue();
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getHours() {
        return this.time / 128 / 3600;
    }

    public int getMinutes() {
        return ((this.time / 128) % 3600) / 60;
    }

    public int getSeconds() {
        return (this.time / 128) % 60;
    }
}
