/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.abstraction;

import java.util.Objects;

/**
 * A class that provides basic debug information that can be used by the child classes in logging
 * scenarios
 */
public abstract class DebugMessageSource {
    private StringBuilder debugStringBuilder;

    public DebugMessageSource() {
        this.debugStringBuilder = new StringBuilder();
    }

    public void appendDebugMsg(String msg) {
        debugStringBuilder.append(msg);
    }

    public void appendItemDebugMsg(String property, Object value) {
        debugStringBuilder.append(String.format("%-30s %-20s", property, value));
        debugStringBuilder.append(System.lineSeparator());
    }

    public void appendNewLine(){
        debugStringBuilder.append(System.lineSeparator());
    }

    public String getDebugString() {
        return debugStringBuilder.toString();
    }

    public void clearDebugMsg() {
        debugStringBuilder.setLength(0);
    }
}
