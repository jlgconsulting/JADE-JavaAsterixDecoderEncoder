/* 
* Created by dan-geabunea on 5/30/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat004;

import jlg.jade.asterix.AsterixMessageTypeData;

/**
 * Cat 004 - Item 000 - Message Type
 */
public class Cat004Item000 extends AsterixMessageTypeData {
    @Override
    protected String setDisplayName() {
        return "Cat004Item000 - Message Type";
    }

    @Override
    protected boolean validate() {
        if (this.getMessageType() >= 1 && this.getMessageType() <= 19) {
            return true;
        }
        appendWarningMessage("Item is not valid. The message type should be between 1 and 19. Actual value: " + this
                .getMessageType());
        return false;
    }
}
