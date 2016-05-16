/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.common;

/**
 * A class that provides basic debug information that can be used by the child classes in logging
 * scenarios
 */
public abstract class DebugMessageSource {
    private final StringBuilder debugStringBuilder;

    protected DebugMessageSource() {
        this.debugStringBuilder = new StringBuilder();
    }

    public String getDebugString() {
        return debugStringBuilder.toString();
    }

    protected void appendDebugMsg(String msg) {
        debugStringBuilder.append(msg);
    }

    protected void appendItemDebugMsg(String property, Object value) {
        debugStringBuilder.append(String.format("-- %-50s %-20s", property, value));
        debugStringBuilder.append(System.lineSeparator());
    }

    protected void appendNewLine(){
        debugStringBuilder.append(System.lineSeparator());
    }

    protected void appendNotImplementedMsg(){
        debugStringBuilder.append("-- This data is not implemented yet and will not be decoded.");
        debugStringBuilder.append(System.lineSeparator());
    }

    protected void clearDebugMsg() {
        debugStringBuilder.setLength(0);
    }

    protected void appendErrorMessage(String msg){
        debugStringBuilder.append("-- [ERR] - ");
        debugStringBuilder.append(msg);
        debugStringBuilder.append(System.lineSeparator());
    }
}
