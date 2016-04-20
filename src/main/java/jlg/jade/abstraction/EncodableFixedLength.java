/*
* Created by dan-geabunea on 4/20/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

/**
 * Interface used by all class that will be able to encode their data to Asterix format
 * in a byte array. The length of the data to be encoded must be known
 */
public interface EncodableFixedLength {

    /**
     * Encodes the current class data into a byte array, that can be then sent over the network
     * or written to a file.
     * @param dest The destination array
     * @param offset The start offset in array dest at which writing should begin
     * @param length The number of bytes to write
     * @return The new offset in the dest array, after the data has been encoded, or -1 if data can not be written because end of array has
     * been reached
     */
    int encode(byte[] dest, int offset, int length);
}
