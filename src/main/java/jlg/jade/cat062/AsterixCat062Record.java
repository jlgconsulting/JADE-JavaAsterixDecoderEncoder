/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.cat062;

import jlg.jade.abstraction.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Represents a single Asterix entity which contains a number of data items
 */
public class AsterixCat062Record extends DebugMessageSource implements DecodableVariableLength, EncodableVariableLength {
    private AsterixCat062Fspec fspec;
    private AsterixCat062Item010 item010;
    private AsterixCat062Item015 item015;

    public AsterixCat062Record(){
        this.fspec = new AsterixCat062Fspec();
    }

    @Override
    public int decode(byte[] input, int offset) {
        throw new NotImplementedException();
    }

    @Override
    public int encode(byte[] dest, int offset) {
        throw new NotImplementedException();
    }
}
