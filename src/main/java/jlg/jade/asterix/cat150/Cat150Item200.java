/**
 * Created by Dan Geabunea on 7/6/2016.
 */

package jlg.jade.asterix.cat150;

import jlg.jade.asterix.AsterixItem;
import jlg.jade.common.Decodable;
import jlg.jade.common.UnsignedNumericDecoder;

/**
 * Cat150 Item200 - FIeld18
 * Field 18 free text information. Contains subfields, each starting with a 3 or 4 letter keyword
 * followed by forward slash; e.g. RMK/free text
 */
public class Cat150Item200 extends AsterixItem implements Decodable {

    private String text;

    @Override
    protected String setDisplayName() {
        return "Cat150Item200 - Field 18";
    }

    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        //size in bytes + first byte that indicates the length
        this.sizeInBytes = UnsignedNumericDecoder.decodeFromOneByte(input, offset) + 1;
        this.text = new String(input, offset + 1, this.sizeInBytes - 1);
        appendItemDebugMsg("Free Text", this.text);

        return offset + sizeInBytes;
    }

    /**
     * @return Free text, containing subfields. Each subfield starts by a 3-4 letter keyword and
     * is followed ny forward slash;
     */
    public String getText() {
        return text;
    }
}
