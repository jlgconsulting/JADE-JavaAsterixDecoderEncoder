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
public interface Decodable {
    /**
     * Parse and decode the raw data from the input medium
     * @param input The raw data
     * @param offset The start offset in the raw data, at which reading should begin
     * @param inputLength The number of bytes to read. The length of the input stream until we may read. This is used because the input
     *                    array can be longer than the length of the data that we wish to read (network buffer reads)
     * @return The new offset in the raw data
     */
    int decode(byte[] input, int offset, int inputLength);
}
