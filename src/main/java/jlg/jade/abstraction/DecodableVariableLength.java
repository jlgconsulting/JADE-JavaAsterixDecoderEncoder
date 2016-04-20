/* 
* Created by dan-geabunea on 4/20/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

/**
 * Interface to be used by classes that will decode Asterix information with a variable,
 * unknown length
 */
public interface DecodableVariableLength {
    /**
     * Parse and decode the raw data from the input medium
     * @param input The raw data
     * @param offset The start offset in the raw data, at which reading should begin
     * @return The new offset in the raw data
     */
    int decode(byte[] input, int offset);
}
