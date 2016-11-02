/*
* Created by dan-geabunea on 4/20/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/

package jlg.jade.common;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Interface used by all class that will be able to encode their data to Asterix format
 * in a byte array. The length of the data to be encoded must be unknown
 */
public interface Encodable {
    /**
     * Encodes the current class data into a byte array, that can be then sent over the network
     * or written to a file.
     * @return The Asterix encoded representation of the Asterix item (byte array)
     * @throws AsterixEncodingException if the item can not be encoded
     */
    default byte[] encode() throws AsterixEncodingException {
        //TODO: Remove default impl after we finish with all the items
        throw new NotImplementedException();
    }
}
