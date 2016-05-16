/* 
* Created by dan-geabunea on 5/3/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

/**
 * Item 380 Subfield 21 - Emmiter category
 * 1 = light aircraft ≤ 7000 kg
 * 2 = reserved
 * 3 = 7000 kg < medium aircraft < 136000 kg
 * 4 = reserved
 * 5 = 136000 kg ≤ heavy aircraft
 * 6 = highly manoeuvrable (5g acceleration capability) and high speed (>400 knots cruise)
 * 7 to 9 = reserved
 * 10 = rotocraft
 * 11 = glider / sailplane
 * 12 = lighter-than-air
 * 13 = unmanned aerial vehicle
 * 14 = space / transatmospheric vehicle
 * 15 = ultralight / handglider / paraglider
 * 16 = parachutist / skydiver
 * 17 to 19 = reserved
 * 20 = surface emergency vehicle
 * 21 = surface service vehicle
 * 22 = fixed ground or tethered obstruction
 * 23 to 24 = reserved
 */
public class Item380Subfield21 extends FixedLengthAsterixData {
    private int emiterCategory;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.ONE_BYTE.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.emiterCategory = input[offset];
        appendItemDebugMsg("Emmiter category", this.emiterCategory);
    }

    public int getEmiterCategory() {
        return emiterCategory;
    }
}
