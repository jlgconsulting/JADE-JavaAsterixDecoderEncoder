/* 
* Created by dan-geabunea on 5/11/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item390;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;

import java.io.UnsupportedEncodingException;

/**
 * Item 390 Subfield 5 - Type of Aircraft
 * Each one of the four Octets composing the type of an aircraft contains an
 * ASCII Character (upper-case alphabetic characters with trailing spaces)
 */
public class Cat062Item390Subfield5 extends FixedLengthAsterixData {
    private String typeOfAircraft;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.FOUR_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        try {
            this.typeOfAircraft = new String(input, offset, getSizeInBytes(), "UTF-8").replace(" ", "");
            appendItemDebugMsg("Type of aircraft", this.typeOfAircraft);

        } catch (UnsupportedEncodingException e) {
            appendErrorMessage("Unsupported encoding exception");
        }
    }

    @Override
    public byte[] encode() {
        if(this.typeOfAircraft.length() > this.sizeInBytes){
            throw new RuntimeException("Invalid type of aircraft. Length exceeded. Value: " + this.typeOfAircraft);
        }

        byte[] itemAsByteArray = this.typeOfAircraft.getBytes();

        return itemAsByteArray;
    }

    /**
     * @return The type of the aircraft, as a String
     */
    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    /**
     * Set the type of aircraft. Maximum 4 characters.
     * @param typeOfAircraft
     */
    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    @Override
    protected String setDisplayName() {
        return "Cat062Item390Subfield5 - Type of Aircraft";
    }
}
