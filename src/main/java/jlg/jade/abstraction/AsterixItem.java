/* 
* Created by dan-geabunea on 4/18/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

/**
 * Generic definition of an Asterix item. All implementation of items will derive from
 * this base class
 */
abstract class AsterixItem extends DebugMessageSource {
    protected int sizeInBytes;
    protected boolean valid;

    public AsterixItem(){
        this.valid = true;
    }

    protected abstract boolean validate();

    protected abstract int setSizeInBytes();

    /**
     * @return True when item is valid according to Asterix validation rules, and false otherwise.
     */
    public boolean isValid() {
        return this.valid;
    }

    /**
     * Gets the length of the Asterix Item
     * @return An integer, representing the length in bytes or -1 if the length has not been set or is not fixed.
     */
    public int getSizeInBytes() {
        return sizeInBytes;
    }
}
